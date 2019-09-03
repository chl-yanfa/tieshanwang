package com.tieshan.api.controller.chegujiaController.v1;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarModelService;
import com.tieshan.api.util.jyInterfaceUtil.jySelectId;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.tieshan.api.util.jyInterfaceUtil.jySelectId.analysis;

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
    //查询精友id接口
    @RequestMapping(value = "selectjyModelId",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectjyModelId(HttpServletRequest request) {
        //查询铁扇车型库的所有id,根据合并编码分组
        List<TieshangjCarModel>list=tieshangjCarModelService.selectAlls();
        int i=1;
        for (TieshangjCarModel tieshangjCarModel : list) {
            try {
                if(StringUtils.isBlank(tieshangjCarModel.getZbzl())){
                    String model = jySelectId.jyModelId(tieshangjCarModel.getJyid());
                    String weight=analysis(model);
                    if(StringUtils.isBlank(weight)){
                        weight="0";
                    }
                    TieshangjCarModel tieshangjCarModel1=new TieshangjCarModel();
                    tieshangjCarModel1.setMergecode(tieshangjCarModel.getMergecode());
                    tieshangjCarModel1.setZbzl(weight);
                    tieshangjCarModelService.updateByHe(tieshangjCarModel1);
                    System.out.println("weight:" + weight+"***当前循环次数："+i++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return   ResultUtil.success("");
    }
    @RequestMapping(value = "aaaa",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult aaaa(HttpServletRequest request) {
        String id=request.getParameter("id");
        String model = jySelectId.jyModelId(id);

        System.out.println(model);
        return   ResultUtil.success(model);
    }
}
