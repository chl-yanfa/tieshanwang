package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarModelService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "v1/carmodel/")
public class TieshangjCarModelController {
    @Autowired
    private TieshangjCarModelService tieshangjCarModelService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "selectCarModel",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarModel(HttpServletRequest request){
        Integer chexiId=Integer.parseInt(request.getParameter("chexiId"));
        //redis
        ValueOperations<String, List<TieshangjCarModel>> operations = redisTemplate.opsForValue();
        //声明key
        String key = "chexiKey_" + chexiId;
        //判断key
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<TieshangjCarModel> list= operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            return ResultUtil.success(list);
        } else {
            List<TieshangjCarModel> list=tieshangjCarModelService.selectCheXiId(chexiId);
            System.out.println("==========从数据表中获得数据=========");
            // 写入缓存
            operations.set(key, list, 5, TimeUnit.HOURS);
            return ResultUtil.success(list);
        }

    }
}
