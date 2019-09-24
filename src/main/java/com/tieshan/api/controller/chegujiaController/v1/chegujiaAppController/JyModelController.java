package com.tieshan.api.controller.chegujiaController.v1.chegujiaAppController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.controller.chegujiaController.v1.TieshanGuJiaController;
import com.tieshan.api.po.chegujiaPo.v1.Exceljyid;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.bo.chegujiaBo.ChlCarModelBo;
import com.tieshan.api.bo.chegujiaBo.EncapsulationBO;
import com.tieshan.api.bo.chegujiaBo.EncapsulationsBO;
import com.tieshan.api.service.chegujiaService.v1.ExceljyidService;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import com.tieshan.api.util.jyInterfaceUtil.jySelectVin;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import com.tieshan.api.util.toolUtil.Thousand;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
@RestController
@RequestMapping(value = "v1/jyCarModel/")
public class JyModelController {
    @Autowired
    private JyModelService jyModelService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ExceljyidService exceljyidService;
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
    static Logger logger = Logger.getLogger(TieshanGuJiaController.class); //LogDemo为相关的类
    //根据vin查询车型
    @RequestMapping(value = "selectModelVin",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectModelVin(HttpServletRequest request){
        String vin=request.getParameter("vin");
        /*vin="LFV2B21K9D3504459";*/
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
    //搜索
    @RequestMapping(value = "selectServiceSearch",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectServiceSearch(HttpServletRequest request,Map map){

        String conditionName=request.getParameter("conditionName");
        List<ChlCarModelSeries>list=new ArrayList<>();
        if(StringUtils.isNotBlank(conditionName)){
            map.put("conditionName",conditionName);
            map.put("fieldName","a.auto_logos_name");
            list=jyModelService.selectSearch(map);
            if(list.size()==0){
                map.put("fieldName","s.vehicle_system_name");
                list=jyModelService.selectSearch(map);
            }
            return  ResultUtil.success(list);
        }
        return ResultUtil.success(list);
    }
    //查询车型
    @RequestMapping(value = "selectCarModelApp",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarModel(HttpServletRequest request){
        Integer chexiId=Integer.parseInt(request.getParameter("chexiId"));
        //redis
        ValueOperations<String,  List<ChlCarModelBo>> operations = redisTemplate.opsForValue();
        //声明key
        String key = "jychexiKey_" + chexiId;
        //判断key
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<ChlCarModelBo> list= operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            return ResultUtil.success(list);
        } else {
            List<ChlCarModel> list=jyModelService.selectCheXiId(chexiId);
            List<ChlCarModelBo>list1=new ArrayList<>();
            for (ChlCarModel chlCarModel : list) {
                String Called="";
                String serName="";
                String Displacement="";
                String DriveType="";
                String ConfigureLevel="";
                String money="";
                if(chlCarModel.getPurchasePrice()!=null){
                    money= Thousand.getNumberWanTwo(chlCarModel.getPurchasePrice());
                }
                ChlCarModelBo chlCarModelBo=new ChlCarModelBo();
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCalled())){
                    Called=chlCarModel.getCalled();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getChlCarModelSeries().getVehicleSystemName())){
                    serName=chlCarModel.getChlCarModelSeries().getVehicleSystemName();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getDisplacement())){
                    Displacement=chlCarModel.getDisplacement();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getDriveType())){
                    DriveType=chlCarModel.getDriveType();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getConfigureLevel())){
                    ConfigureLevel=chlCarModel.getConfigureLevel();
                }
                chlCarModelBo.setId(chlCarModel.getId());
                chlCarModelBo.setAliasId(chlCarModel.getAliasId());
                chlCarModelBo.setCalled(Called);
                chlCarModelBo.setCarYear(chlCarModel.getCarYear());
                chlCarModelBo.setTiema(chlCarModel.getTiema());
                if(org.apache.commons.lang3.StringUtils.isBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()!=null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+money+"万元");
                    }else{
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+money+"万元");
                    }
                }else if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()==null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel);
                    }else{
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+ConfigureLevel);
                    }
                }else if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()!=null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+money+"万元");
                    }else{
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+money+"万元");
                    }
                }else if(org.apache.commons.lang3.StringUtils.isBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()==null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType);
                    }else{
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel);
                    }
                }
                list1.add(chlCarModelBo);
            }
            System.out.println("==========从数据表中获得数据=========");
            // 写入缓存
            operations.set(key, list1, 365, TimeUnit.DAYS);
            return ResultUtil.success(list1);
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
        operations.set(key, encapsulationBOS, 365, TimeUnit.DAYS);
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
        try {
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
                    String listPriceTax = (String)key1.get("listPriceTax");//厂家指导价
                    String marketDate = (String)key1.get("marketDate");//上市年份
                    String newClassNameTwo = (String)key1.get("newClassNameTwo");
                    String power = (String)key1.get("power");
                    String powerType = (String)key1.get("powerType");
                    String purchasePrice = (String)key1.get("purchasePrice");
                    String purchasePriceTax = (String)key1.get("purchasePriceTax");
                    String qltgg = (String)key1.get("qltgg");
                    String remark = (String)key1.get("remark");//备注
                    String riskFlag = (String)key1.get("riskFlag");
                    String roz = (String)key1.get("roz");//燃油标号
                    String seat = (String)key1.get("seat");//座位数
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
                        Exceljyid exceljyid=exceljyidService.selectByJyid(sb2);
                        if(exceljyid!=null){
                            chlCarModel.setTiema(exceljyid.getTiema());
                        }
                        //if该车型不存在，新增一条车型
                        chlCarModel.setVinCode(vin);
                        chlCarModel.setDisplacement(displacement);
                        chlCarModel.setModelYear(marketDate);
                        chlCarModel.setDriveType(gearboxType);
                        chlCarModel.setEngine(engineModel);
                        chlCarModel.setBodyStructure(bodyType);
                        BigDecimal b = new BigDecimal(listPriceTax);
                        chlCarModel.setPurchasePrice(b.setScale(2, BigDecimal.ROUND_DOWN));
                        chlCarModel.setRangeOfService("0");
                        chlCarModel.setRangeOfPickup("0");
                        chlCarModel.setStatus(1);
                        chlCarModel.setCreatedTime(new Date());
                        chlCarModel.setCreatedBy("vin接口新增");
                        chlCarModel.setUpdatedBy("vin接口新增");
                        chlCarModel.setUpdatedTime(new Date());
                        chlCarModel.setDeleteState(0);
                        chlCarModel.setPartNum("401");
                        chlCarModel.setCalled(vehicleName);
                        chlCarModel.setCarYear(yearPattern);
                        chlCarModel.setDynamic(powerType);
                        chlCarModel.setDrives(drivenType);
                        chlCarModel.setSeatNum(seat);
                        chlCarModel.setEmissionStandard(effluentStandard);
                        chlCarModel.setConfigureLevel(cfgLevel);
                        chlCarModel.setCylinder(arrayType);
                        chlCarModel.setEngineValveNum(valveNum);
                        chlCarModel.setTransmission(gearNum);
                        chlCarModel.setWheelbase(wheelbase);
                        chlCarModel.setCardoornum(cms);
                        chlCarModel.setSupply(supplyOil);
                        chlCarModel.setCarAlias(vehicleAlias);
                        chlCarModel.setPower(power);
                        chlCarModel.setRemarks(remark);
                        chlCarModel.setAliasId(sb2);
                        Integer groupIds=jyModelService.selectByName(groupName);
                        if(groupIds>0){
                            chlCarModel.setSubSeriesId(groupIds);
                        }
                        jyModelService.insertSelective(chlCarModel);
                        System.out.println("该车型不存在，新增一条车型");
                        logger.info("该车型不存在，新增一条车型");
                    }else {
                        //if该车型存在，为车型添加vin(修改车型信息)
                        System.out.println("该车型存在，为车型添加vin:"+vin+"*精友id*"+sb2);
                        logger.info("该车型存在，为车型添加vin:"+vin+"*精友id*"+sb2);
                        ChlCarModel chlCarModel1=new ChlCarModel();
                        chlCarModel1.setAliasId(sb2);
                        chlCarModel1.setVinCode(vin);
                        jyModelService.updateVinByJyid(chlCarModel1);
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    //查询车标-------缓存全部车型
    @RequestMapping(value = "selectAutoLogosAppRedis",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectAutoLogosApp2()throws Exception{
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        List<ChlAutoLogos>list=jyModelService.selectAll();
        if(list!=null){
            //遍历所有list
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
        for (EncapsulationBO encapsulationBO : encapsulationBOS) {
            for (EncapsulationsBO child : encapsulationBO.getChildren()) {
                selectCarBrand2(Integer.parseInt(child.getId()));
            }
        }
        return ResultUtil.success("缓存完成");
    }
    //redis---缓存车系
    public String selectCarBrand2(Integer autoLogoId){
        List<ChlBrand> list=jyModelService.selectCBId(autoLogoId);
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        //声明key
        String key = "jybrandKey_" +autoLogoId;
        //redis
        ValueOperations<String, List<EncapsulationBO>> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            System.out.println("==========从缓存中获得数据=========");
        }else{
            for (ChlBrand tieshangjCarBrand : list) {
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
            // 写入缓存
            operations.set(key, encapsulationBOS, 365, TimeUnit.DAYS);
            for (EncapsulationBO encapsulationBO : encapsulationBOS) {
                for (EncapsulationsBO child : encapsulationBO.getChildren()) {
                    selectCarModel3(Integer.parseInt(child.getId()));
                }
            }
        }
        return "b";
    }
    //redis--缓存车型
    public ApiResult selectCarModel3(Integer chexiId){
        //redis
        ValueOperations<String,  List<ChlCarModelBo>> operations = redisTemplate.opsForValue();
        //声明key
        String key = "jychexiKey_" + chexiId;
        //判断key
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            System.out.println("==========从缓存中获得数据=========");
            return ResultUtil.success("");
        } else {
            List<ChlCarModel> list=jyModelService.selectCheXiId(chexiId);
            List<ChlCarModelBo>list1=new ArrayList<>();
            for (ChlCarModel chlCarModel : list) {
                String Called="";
                String serName="";
                String Displacement="";
                String DriveType="";
                String ConfigureLevel="";
                String money="";
                if(chlCarModel.getPurchasePrice()!=null){
                    money= Thousand.getNumberWanTwo(chlCarModel.getPurchasePrice());
                }
                ChlCarModelBo chlCarModelBo=new ChlCarModelBo();
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCalled())){
                    Called=chlCarModel.getCalled();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getChlCarModelSeries().getVehicleSystemName())){
                    serName=chlCarModel.getChlCarModelSeries().getVehicleSystemName();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getDisplacement())){
                    Displacement=chlCarModel.getDisplacement();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getDriveType())){
                    DriveType=chlCarModel.getDriveType();
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getConfigureLevel())){
                    ConfigureLevel=chlCarModel.getConfigureLevel();
                }
                chlCarModelBo.setId(chlCarModel.getId());
                chlCarModelBo.setAliasId(chlCarModel.getAliasId());
                chlCarModelBo.setCalled(Called);
                chlCarModelBo.setCarYear(chlCarModel.getCarYear());
                chlCarModelBo.setTiema(chlCarModel.getTiema());
                if(org.apache.commons.lang3.StringUtils.isBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()!=null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+money+"万元");
                    }else{
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+money+"万元");
                    }
                }else if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()==null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel);
                    }else{
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+ConfigureLevel);
                    }
                }else if(org.apache.commons.lang3.StringUtils.isNotBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()!=null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+money+"万元");
                    }else{
                        chlCarModelBo.setModelName(chlCarModel.getCarYear()+"款 "+serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel+" "+money+"万元");
                    }
                }else if(org.apache.commons.lang3.StringUtils.isBlank(chlCarModel.getCarYear())&&chlCarModel.getPurchasePrice()==null){
                    if(org.apache.commons.lang3.StringUtils.isBlank(ConfigureLevel)){
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType);
                    }else{
                        chlCarModelBo.setModelName(serName+" "+Displacement+" "+DriveType+" "+ConfigureLevel);
                    }
                }
                list1.add(chlCarModelBo);
            }
            System.out.println("==========从数据表中获得数据=========");
            // 写入缓存
            operations.set(key, list1, 365, TimeUnit.DAYS);
            return ResultUtil.success(list1);
        }

    }
}
