package com.tieshan.api.controller.chebaofeiController.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderMyTradeBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderMyTradeInfoBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.common.chebaofeiCommon.SystemParameter;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderService;
import com.tieshan.api.service.chebaofeiService.v1.ClientCUserService;
import com.tieshan.api.util.toolUtil.ClientUtil;
import com.tieshan.api.util.toolUtil.CookieUtils;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;
import shaded.org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟邪
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 *
 *
 *
 * @author ningrz C端(铁扇网App)用户接口
 * @version 1.0
 * @date 2019/9/12 9:40
 */
@RestController
@CrossOrigin
@RequestMapping(value="/carscraporder-applet/account")
public class ClientCAccountController {

    @Autowired
    private ClientCUserService clientUserService;

    @Autowired
    private CarScrapOrderService carScrapOrderService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户登录接口
     * @param username 登陆名
     * @param password 密码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public ResultBean<Map<String,Object>> doLogin(@RequestParam("username") String username,
                                                  @RequestParam("password") String password, HttpServletRequest request,
                                                  HttpServletResponse response) throws Exception {

        ClientBO user = this.clientUserService.doLogin(username, password);
        if (user != null) {
            // 登录成功
            String ticket = DigestUtils.md5Hex(user.getLoginName() + System.currentTimeMillis());
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
            return new ResultBean<>(map);
        } else {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("state", false);
            map.put("session", "");
            map.put("areaid", "");
            map.put("realName", "");
            map.put("userType", "");
            map.put("phone", "");
            map.put("businessType", "");
            return new ResultBean<>(map);
        }
    }

    /**
     * 用户修改密码接口
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "setPwd",method = RequestMethod.PUT)
    public ResultBean<Boolean> setPwd(@RequestParam(value="oldPassword" ,required=true) String oldPassword,
                                      @RequestParam(value="newPassword" ,required=true) String newPassword) throws Exception{
        Boolean data = clientUserService.setPwd(ClientUtil.getUser().getId(),oldPassword,newPassword,ClientUtil.getUser().getId(),ClientUtil.getUser().getLoginName());
        return new ResultBean<>(data);
    }

    /**
     * 获得用户基本信息接口
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getInfo",method = RequestMethod.GET)
    public ResultBean<ClientBO> getInfo() throws Exception{
        ClientBO bo = clientUserService.queryUserById(ClientUtil.getUser().getId());
        return new ResultBean<>(bo);
    }

    /**
     * 获取验证码接口
     * @param phone
     * @return
     * @throws Exception
     */
    @RequestMapping(value="getValidateCode", method = RequestMethod.POST)
    public ResultBean<Boolean> getVerificationCode(@RequestParam(value="phone") String phone) throws Exception{
        Boolean data = clientUserService.getValidateCode(phone);
        return new ResultBean<>(data);
    }

    /**
     * 个人用户注册
     * @param clientVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public ResultBean<Boolean> doRegister(ClientVO clientVO)throws Exception {
        return new ResultBean<>(this.clientUserService.doRegister(clientVO));
    }

    /**
     * 实名认证接口
     * @param clientVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "certification", method = RequestMethod.PUT)
    public ResultBean<Boolean> certification(ClientCertificationVO clientVO) throws Exception {
        clientVO.setId(ClientUtil.getUser().getId());
        clientVO.setOperator(ClientUtil.getUser().getId());
        return new ResultBean<>(clientUserService.certification(clientVO));
    }

    /**
     * 忘记密码-校验验证码接口
     * @param phone 手机号
     * @param validateCode 用户输入的验证码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "verifyValidateCode", method = RequestMethod.GET)
    public ResultBean<Boolean> verifyValidateCode(@RequestParam(value = "phone") String phone,
                                                  @RequestParam(value = "validateCode") String validateCode) throws Exception {

        ClientBO user = clientUserService.queryUserByPhone(phone);
        if (user==null || StringUtils.isBlank(user.getPhone())) {
            throw new DataException("无此用户");
        }
        Boolean data = (clientUserService.verifyValidateCode(user.getPhone()).equals(validateCode));
        return new ResultBean<>(data);
    }

    /**
     * 忘记密码-更新密码接口
     * @param phone 手机号
     * @param newPwd 新密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "forgetPwd", method = RequestMethod.PUT)
    public ResultBean<Boolean> forgetPwd(@RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "newPwd") String newPwd) throws Exception {

        ClientBO user = clientUserService.queryUserByPhone(phone);
        if (user==null || StringUtils.isBlank(user.getPhone())) {
            throw new DataException("无此用户");
        }
        Boolean data = clientUserService.forgetPwd(user.getId(), newPwd, user.getId());
        return new ResultBean<>(data);
    }

    /**
     * 获取当前用户银行卡信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getBankCard", method = RequestMethod.GET)
    public ResultBean<ClientBankCardBO> getBankCard() throws Exception {
        return new ResultBean<>(clientUserService.queryUserBankCard(ClientUtil.getUser().getId()));
    }

    /**
     * 添加银行卡
     * @param clientVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addBankCard", method = RequestMethod.PUT)
    public ResultBean<Boolean> addBankCard(ClientAddBankVO clientVO) throws Exception {
        clientVO.setClientid(ClientUtil.getUser().getId());
        return new ResultBean<>(clientUserService.addBankCard(clientVO));
    }

    /**
     * 根据id获取订单审核进度详情
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "myTrade", method = RequestMethod.GET)
    public ResultBean<CarScrapOrderMyTradeBO> myTrade() throws Exception {
        return new ResultBean<>(carScrapOrderService.myTrade(ClientUtil.getUser().getId()));
    }


    /**
     * 获取我的交易详情列表
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "myTradeInfo", method = RequestMethod.GET)
    public ResultBean<PageResult<CarScrapOrderMyTradeInfoBO>> myTradeInfo(@RequestParam(value="page",required = true,defaultValue="1")Integer page,
                                                                          @RequestParam(value="rows",required = true,defaultValue="10")Integer rows) throws Exception {

        PageResult<CarScrapOrderMyTradeInfoBO> pageResult = null;
        PageInfo<CarScrapOrderMyTradeInfoBO> pageInfo = carScrapOrderService.myTradeInfo(page, rows, ClientUtil.getUser().getId());
        if (pageInfo != null) {
            pageResult = new PageResult<>();
            pageResult.setRows(pageInfo.getList());
            pageResult.setTotal(pageInfo.getTotal());
        }
        return new ResultBean<>(pageResult);
    }


    /**
     * 设置redis模板
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();//序列化为String
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//序列化为Json
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        this.redisTemplate = redisTemplate;
        StringRedisSerializer stringSerializer = new StringRedisSerializer();//序列化为String
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//序列化为Json
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        this.redisTemplate = redisTemplate;
    }
}

