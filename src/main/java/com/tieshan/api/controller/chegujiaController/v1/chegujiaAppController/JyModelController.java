package com.tieshan.api.controller.chegujiaController.v1.chegujiaAppController;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationsBO;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import com.tieshan.api.util.jyInterfaceUtil.jySelectId;
import com.tieshan.api.util.jyInterfaceUtil.jySelectVin;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "v1/jyCarModel/")
public class JyModelController {
    @Autowired
    private JyModelService jyModelService;
    @Autowired
    private RedisTemplate redisTemplate;
    //根据vin查询车型
    @RequestMapping(value = "selectModelVin",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectModelVin(HttpServletRequest request){
        String vin=request.getParameter("vin");
        List<ChlCarModel>list=jyModelService.selectModelVin(vin);
        if(list==null){
            //调用第三方精友接口查询
            String json=jySelectVin.jyselectVins(vin);
            //解析json数据
            //if该车型存在，为车型添加vin
            //if该车型不存在，新增一条车型


        }
        //查询该vin是否存在
        return ResultUtil.success(list);
    }
    //查询年份
    @RequestMapping(value = "selectYearApp",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectYearApp(HttpServletRequest request){
        String year=request.getParameter("year");
        if(org.apache.commons.lang3.StringUtils.isBlank(year)){
            year="2012";
        }
        Integer yearr=Integer.parseInt(year);
        Calendar date = Calendar.getInstance();
        String years = String.valueOf(date.get(Calendar.YEAR));
        Integer num=Integer.parseInt(years)-yearr;
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<=num;i++){
            System.out.println(yearr);
            list.add(yearr);
            yearr++;
        }
        return  ResultUtil.success(list);


    }
    //查询车型
    @RequestMapping(value = "selectCarModelApp",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarModel(HttpServletRequest request){
        Integer chexiId=Integer.parseInt(request.getParameter("chexiId"));
        //redis
        ValueOperations<String, List<ChlCarModel>> operations = redisTemplate.opsForValue();
        //声明key
        String key = "jychexiKey_" + chexiId;
        //判断key
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<ChlCarModel> list= operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            return ResultUtil.success(list);
        } else {
            List<ChlCarModel> list=jyModelService.selectCheXiId(chexiId);
            System.out.println("==========从数据表中获得数据=========");
            // 写入缓存
            operations.set(key, list, 5, TimeUnit.HOURS);
            return ResultUtil.success(list);
        }

    }
    //查询品牌+车系
    @RequestMapping(value = "selectCarBrandApp",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarBrand(HttpServletRequest request){
        Integer autoLogoId=Integer.parseInt(request.getParameter("autoLogoId"));
        List<ChlBrand> list=jyModelService.selectCBId(autoLogoId);
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        //声明key
        String key = "jybrandKey_" +autoLogoId;
        //redis
        ValueOperations<String, List<EncapsulationBO>> operations = redisTemplate.opsForValue();
        for (ChlBrand tieshangjCarBrand : list) {
            //判断key
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                List<EncapsulationBO> encapsulationBO = operations.get(key);
                System.out.println("==========从缓存中获得数据=========");
                return ResultUtil.success(encapsulationBO);
            } else {
                System.out.println("==========从数据库中获得数据=========");
                EncapsulationBO dsbo = new EncapsulationBO();
                dsbo.setType(tieshangjCarBrand.getBrname());
                List<ChlCarModelSeries> lists= jyModelService.selectBrandId(tieshangjCarBrand.getId());
                if (lists != null) {
                    List<EncapsulationsBO> dictionaryBOs = new ArrayList<EncapsulationsBO>();
                    for (ChlCarModelSeries tieshangjCarVehicleSystem : lists) {
                        EncapsulationsBO encapsulationsBO=new EncapsulationsBO();
                        encapsulationsBO.setId(tieshangjCarVehicleSystem.getId().toString());
                        encapsulationsBO.setName(tieshangjCarVehicleSystem.getVehicleSystemName());
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
    //查询车标
    @RequestMapping(value = "selectAutoLogosApp",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectAutoLogosApp()throws Exception{
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        List<ChlAutoLogos>list=jyModelService.selectAll();
        if(list!=null){
            for (ChlAutoLogos tieshangjCarAutoLogos : list) {
                EncapsulationsBO encapsulationsBO=new EncapsulationsBO();
                encapsulationsBO.setId(tieshangjCarAutoLogos.getAutoLogosId().toString());
                encapsulationsBO.setName(tieshangjCarAutoLogos.getAutoLogosName());
                String szm = ToFirstChar(tieshangjCarAutoLogos.getAutoLogosName());
                Boolean flag = true;
                if(encapsulationBOS != null && encapsulationBOS.size() >0) {
                    for (int i = 0; i < encapsulationBOS.size(); i++) {
                        EncapsulationBO dictionarySystemBO = encapsulationBOS.get(i);
                        if(StringUtils.equals(dictionarySystemBO.getType(), szm)) {
                            dictionarySystemBO.getChildren().add(encapsulationsBO);
                            flag = false;
                        }
                    }
                }
                if(flag) {
                    List<EncapsulationsBO> dictionaryBOs = new ArrayList<EncapsulationsBO>();
                    dictionaryBOs.add(encapsulationsBO);
                    EncapsulationBO dsbo = new EncapsulationBO();
                    dsbo.setType(szm);
                    dsbo.setChildren(dictionaryBOs);
                    encapsulationBOS.add(dsbo);
                }
            }
            Collections.sort(encapsulationBOS,new Comparator<EncapsulationBO>() {
                @Override
                public int compare(EncapsulationBO o1, EncapsulationBO o2) {
                    return o1.getType().compareTo(o2.getType());
                }

            });
        }
        return ResultUtil.success(encapsulationBOS);
    }
    private static String ToFirstChar(String chinese) {
        String pinyinStr = "";
        char newChar = chinese.toCharArray()[0];
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (newChar > 128) {
            try {
                pinyinStr = PinyinHelper.toHanyuPinyinStringArray(newChar, defaultFormat)[0].charAt(0)+"";
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            pinyinStr = newChar+"";
        }
        return pinyinStr.toUpperCase();
    }
}
