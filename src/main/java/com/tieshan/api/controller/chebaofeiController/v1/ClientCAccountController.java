package com.tieshan.api.controller.chebaofeiController.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.common.chebaofeiCommon.SystemParameter;
import com.tieshan.api.service.chebaofeiService.v1.ClientCUserService;
import com.tieshan.api.util.toolUtil.CookieUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ningrz C端用户接口
 * @version 1.0
 * @date 2019/9/12 9:40
 */
@RestController
@CrossOrigin
@RequestMapping(value="/account")
public class ClientCAccountController {

    @Autowired
    private ClientCUserService clientUserService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public ResultBean<Map<String,Object>> doLogin(@RequestParam("username") String username,
                                                  @RequestParam("password") String password, HttpServletRequest request,
                                                  HttpServletResponse response) throws Exception {

        ClientBO user = this.clientUserService.doLogin(username, password);
        if (user != null) {
            // 登录成功
            String ticket = DigestUtils.md5Hex(user.getLoginName() + System.currentTimeMillis());
            System.out.println("这是"+user.getLoginName()+"所拥有的ticket: "+ticket);
            String userstr = SystemParameter.MAPPER.writeValueAsString(user);

            //放入缓存,设置缓存过期时间为一月
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(SystemParameter.TICKET+ticket, userstr,3600 * 24 * 30, TimeUnit.SECONDS);

            // 将ticket写入到cookie中
            CookieUtils.setCookie(request, response, SystemParameter.COOKIE_TICKET, ticket);

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("state", true);
            map.put("session", ticket);
            map.put("areaid", user.getAreaid());
            map.put("realName", user.getUserName());
            map.put("userType", user.getUserType());
            map.put("phone", user.getPhone());
            map.put("businessType", user.getBusinessType());
            map.put("userId", user.getId());
            map.put("isScrapOrde", user.getIsScrapOrde());
            map.put("isPartsOrde", user.getIsPartsOrde());
            return new ResultBean<Map<String,Object>>(map);
        } else {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("state", false);
            map.put("session", "");
            map.put("areaid", "");
            map.put("realName", "");
            map.put("userType", "");
            map.put("phone", "");
            map.put("businessType", "");
            return new ResultBean<Map<String,Object>>(map);
        }
    }


    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();//序列化为String
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//序列化为Json
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        this.redisTemplate = redisTemplate;
    }
}
