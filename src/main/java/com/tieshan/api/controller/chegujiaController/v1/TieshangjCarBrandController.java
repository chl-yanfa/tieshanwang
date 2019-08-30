package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationsBO;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarBrandService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarVehicleSystemService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "v1/brand/")
public class TieshangjCarBrandController {
    @Autowired
    private TieshangjCarBrandService tieshangjCarBrandService;
    @Autowired
    private TieshangjCarVehicleSystemService tieshangjCarVehicleSystemService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "selectCarBrand",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarBrand(HttpServletRequest request){
        Integer autoLogoId=Integer.parseInt(request.getParameter("autoLogoId"));
        List<TieshangjCarBrand> list=tieshangjCarBrandService.selectCBId(autoLogoId);
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        //声明key
        String key = "brandKey_" +autoLogoId;
        //redis
        ValueOperations<String, List<EncapsulationBO>> operations = redisTemplate.opsForValue();
        for (TieshangjCarBrand tieshangjCarBrand : list) {
            //判断key
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                List<EncapsulationBO> encapsulationBO = operations.get(key);
                System.out.println("==========从缓存中获得数据=========");
                return ResultUtil.success(encapsulationBO);
            } else {
                System.out.println("==========从数据库中获得数据=========");
                EncapsulationBO dsbo = new EncapsulationBO();
                dsbo.setType(tieshangjCarBrand.getbName());
                List<TieshangjCarVehicleSystem> lists= tieshangjCarVehicleSystemService.selectBrandId(tieshangjCarBrand.getId());
                if (lists != null) {
                    List<EncapsulationsBO> dictionaryBOs = new ArrayList<EncapsulationsBO>();
                    for (TieshangjCarVehicleSystem tieshangjCarVehicleSystem : lists) {
                        EncapsulationsBO encapsulationsBO=new EncapsulationsBO();
                        encapsulationsBO.setId(tieshangjCarVehicleSystem.getId().toString());
                        encapsulationsBO.setName(tieshangjCarVehicleSystem.getvName());
                        dictionaryBOs.add(encapsulationsBO);
                    }
                    dsbo.setChildren(dictionaryBOs);
                }
                encapsulationBOS.add(dsbo);
            }
        }
        // 写入缓存
        operations.set(key, encapsulationBOS, 5, TimeUnit.HOURS);
        return ResultUtil.success(encapsulationBOS);
    }
}
