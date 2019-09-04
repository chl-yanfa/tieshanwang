package com.tieshan.api.controller.chegujiaController.v1.chegujiaAppController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationsBO;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
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
        //查询该vin是否存在
        List<ChlCarModel>list=jyModelService.selectModelVin(vin);
        if(list.size()==0){
            //调用第三方精友接口查询
            String json=jySelectVin.jyselectVins(vin);
            //解析json数据
            vinjson(json,vin);
            list=jyModelService.selectModelVin(vin);
        }
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
    public   void vinjson(String json,String vin){
        List<String>list=new ArrayList<>();
        JSONObject jobj = JSON.parseObject(json);
        JSONArray link2 = jobj.getJSONObject("result").getJSONArray("vehicleList");
        if(link2!=null){
            for (int i = 0 ; i < link2.size();i++){
                JSONObject key1 = (JSONObject)link2.get(i);
                System.out.println("key1:"+key1.toString());
                String answerConent = (String)key1.get("absFlag");
                String answerValue = (String)key1.get("airbagNum");
                String question = (String)key1.get("ansFlag");//问题标志
                String antiTheft = (String)key1.get("antiTheft");
                String arrayType = (String)key1.get("arrayType");
                String bodyType = (String)key1.get("bodyType");
                String brandCode = (String)key1.get("brandCode");
                String brandId = (String)key1.get("brandId");
                String brandName = (String)key1.get("brandName");//品牌名称
                String cfgLevel = (String)key1.get("cfgLevel");
                String cms = (String)key1.get("cms");
                String companyCode = (String)key1.get("companyCode");
                String companyName = (String)key1.get("companyName");
                String cylinderNum = (String)key1.get("cylinderNum");//气缸数
                String displacement = (String)key1.get("displacement");//排量
                String drivenType = (String)key1.get("drivenType");//驱动形式
                String effluentStandard = (String)key1.get("effluentStandard");
                String engineDesc = (String)key1.get("engineDesc");//
                String engineModel = (String)key1.get("engineModel");//发动机型号
                String familyCode = (String)key1.get("familyCode");
                String familyId = (String)key1.get("familyId");
                String familyName = (String)key1.get("familyName");//车系名称
                String fuelJetType = (String)key1.get("fuelJetType");//燃油喷射形式
                String fullWeight = (String)key1.get("fullWeight");
                String fullWeightMaxKg = (String)key1.get("fullWeightMaxKg");
                String fullWeightMinKg = (String)key1.get("fullWeightMinKg");
                String gearNum = (String)key1.get("gearNum");
                String gearboxType = (String)key1.get("gearboxType");//变速箱类型
                String groupCode = (String)key1.get("groupCode");//车组编码
                String groupId = (String)key1.get("groupId");
                String groupName = (String)key1.get("groupName");//车组名称
                String hasConfig = (String)key1.get("hasConfig");
                String hltgg = (String)key1.get("hltgg");
                String importFlag = (String)key1.get("importFlag");
                String kindredPrice = (String)key1.get("kindredPrice");
                String kindredPriceTax = (String)key1.get("kindredPriceTax");
                String letStand = (String)key1.get("letStand");
                String listPrice = (String)key1.get("listPrice");
                String listPriceTax = (String)key1.get("listPriceTax");
                String marketDate = (String)key1.get("marketDate");
                String newClassNameTwo = (String)key1.get("newClassNameTwo");
                String power = (String)key1.get("power");
                String powerType = (String)key1.get("powerType");
                String purchasePrice = (String)key1.get("purchasePrice");
                String purchasePriceTax = (String)key1.get("purchasePriceTax");
                String qltgg = (String)key1.get("qltgg");
                String remark = (String)key1.get("remark");//备注
                String riskFlag = (String)key1.get("riskFlag");
                String roz = (String)key1.get("roz");//燃油标号
                String seat = (String)key1.get("seat");
                String standardName = (String)key1.get("standardName");
                String standardname2 = (String)key1.get("standardname2");
                String stopDate = (String)key1.get("stopDate");//停产日期
                String stopFlag = (String)key1.get("stopFlag");
                String supplyOil = (String)key1.get("supplyOil");//供油方式
                String trackFront = (String)key1.get("trackFront");
                String trackRear = (String)key1.get("trackRear");
                String uploadDate = (String)key1.get("uploadDate");//出厂日期(生产日期)
                String valveNum = (String)key1.get("valveNum");
                String vehIsSeri = (String)key1.get("vehIsSeri");
                String vehPicNum = (String)key1.get("vehPicNum");
                String vehicleAlias = (String)key1.get("vehicleAlias");
                String vehicleClass = (String)key1.get("vehicleClass");
                String vehicleColor = (String)key1.get("vehicleColor");//车型颜色
                String vehicleId = (String)key1.get("vehicleId");//车型ID
                String vehicleName = (String)key1.get("vehicleName");//车型俗称
                String vehicleSize = (String)key1.get("vehicleSize");
                String vinCode = (String)key1.get("vinCode");
                String wheelbase = (String)key1.get("wheelbase");
                String yearPattern = (String)key1.get("yearPattern");//年款
                String zllx = (String)key1.get("zllx");
                String sb = vehicleId;
                String sb2=sb.substring(3);
                System.out.println("vehicleId:"+sb2);
                //查看该精友id的车型是否存在
                ChlCarModel chlCarModel=jyModelService.selectModelJyid(sb2);
                if(chlCarModel==null){
                    //if该车型不存在，新增一条车型
                    System.out.println("该车型不存在，新增一条车型");
                }else {
                    //if该车型存在，为车型添加vin(修改车型信息)
                    System.out.println("该车型存在，为车型添加vin:"+vin+"*精友id*"+sb2);
                    ChlCarModel chlCarModel1=new ChlCarModel();
                    chlCarModel1.setAliasId(sb2);
                    chlCarModel1.setVinCode(vin);
                    jyModelService.updateVinByJyid(chlCarModel1);
                }


                /*System.out.println("answerConent:"+answerConent);
                System.out.println("answerValue:"+answerValue);
                System.out.println("question:"+question);
                System.out.println("antiTheft:"+antiTheft);
                System.out.println("arrayType:"+arrayType);
                System.out.println("bodyType:"+bodyType);
                System.out.println("brandCode:"+brandCode);
                System.out.println("brandId:"+brandId);
                System.out.println("brandName:"+brandName);
                System.out.println("cfgLevel:"+cfgLevel);
                System.out.println("cms:"+cms);
                System.out.println("companyCode:"+companyCode);
                System.out.println("companyName:"+companyName);
                System.out.println("cylinderNum:"+cylinderNum);//气缸数
                System.out.println("displacement:"+displacement);
                System.out.println("drivenType:"+drivenType);
                System.out.println("effluentStandard:"+effluentStandard);
                System.out.println("engineDesc:"+engineDesc);
                System.out.println("engineModel:"+engineModel);
                System.out.println("familyCode:"+familyCode);
                System.out.println("familyId:"+familyId);
                System.out.println("familyName:"+familyName);
                System.out.println("fuelJetType:"+fuelJetType);
                System.out.println("fullWeight:"+fullWeight);
                System.out.println("fullWeightMaxKg:"+fullWeightMaxKg);
                System.out.println("fullWeightMinKg:"+fullWeightMinKg);
                System.out.println("gearNum:"+gearNum);
                System.out.println("gearboxType:"+gearboxType);
                System.out.println("groupCode:"+groupCode);
                System.out.println("groupId:"+groupId);
                System.out.println("groupName:"+groupName);
                System.out.println("hasConfig:"+hasConfig);
                System.out.println("hltgg:"+hltgg);
                System.out.println("importFlag:"+importFlag);
                System.out.println("kindredPrice:"+kindredPrice);
                System.out.println("kindredPriceTax:"+kindredPriceTax);
                System.out.println("letStand:"+letStand);
                System.out.println("listPrice:"+listPrice);
                System.out.println("listPriceTax:"+listPriceTax);
                System.out.println("marketDate:"+marketDate);
                System.out.println("vehicleId:"+vehicleId);
                String sb = vehicleId;
                String sb2=sb.substring(3);
                System.out.println("sb2:"+sb2);*/
            }
        }


    }
}
