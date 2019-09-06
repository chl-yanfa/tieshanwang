package com.tieshan.api.controller.chegujiaController.v1;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCityInfo;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;
import com.tieshan.api.service.chegujiaService.v1.*;
import com.tieshan.api.service.shortMessageApiService.v1.TbVerificationCodeService;
import com.tieshan.api.util.httpUtil.HttpClient;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/gu/")
public class TieshanGuJiaController {
    @Autowired
    private TieshangjCarPiecesService tieshangjCarPiecesService;
    @Autowired
    private TieshangjCarProfitService tieshangjCarProfitService;
    @Autowired
    private TieshangjCarRegionalArtificialService tieshangjCarRegionalArtificialService;
    @Autowired
    private TbVerificationCodeService tbVerificationCodeService;
    @Autowired
    private TieshangjCarWasteService tieshangjCarWasteService;
    @Autowired
    private TieshangjCarModelService tieshangjCarModelService;
    @Autowired
    private TieshangjHistoryService tieshangjHistoryService;
    @Autowired
    private TieshangjCityInfoService tieshangjCityInfoService;

    @Autowired
    private JyModelService jyModelService;
    private String ip="http://api2.chehulian.com:";
    /*private String ip="http://10.0.0.210:";*/
    private String port="18061";
    static Logger logger = Logger.getLogger(TieshanGuJiaController.class); //LogDemo为相关的类
    @RequestMapping(value = "gujia",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult gujia(HttpServletRequest request){
        String jyid=request.getParameter("jyid");//精友id
        String type=request.getParameter("type");
        String pid=request.getParameter("pid");//获得省份id
        String carNumberId=request.getParameter("carNumberId");//车型id
        String moderyers=request.getParameter("moderyers");//年款
        if(StringUtils.isNotBlank(moderyers)){
            if(moderyers.equals("2019")){
                moderyers="2018";
            }
        }
        String cityId=request.getParameter("cityId");//城市id
        String Mileage=request.getParameter("Mileage");//里程
        String carModelName=request.getParameter("carModelName");//车型名称
        String createBy=request.getParameter("createBy");//创建人
        String phone=request.getParameter("phone");//手机号
        String carModelTiema="";
        TieshangjCityInfo cityInfo=tieshangjCityInfoService.selectbyId(cityId);
        System.out.println("type:"+type);
        if(type.equals("1")){
            //APP
            //根据精友id查询对应铁码
             ChlCarModel chlCarModel =jyModelService.selectByPrimaryKey(Integer.parseInt(carNumberId));
            carModelTiema=tieshangjCarModelService.countByTieMa(chlCarModel.getTiema());
            //if铁码不为空
            if(StringUtils.isNotBlank(carModelTiema)){
                //判断该铁码车型是否需要调用一次估价（判断拆旧件表是否存在）
                System.out.println(carModelTiema);
                Integer count=tieshangjCarPiecesService.countSelectTiema(carModelTiema);
                if(count<=0){
                    //调用一次估价
                   Map map=oldGuJia(carNumberId,moderyers,cityId,Mileage,pid,carModelName,createBy,cityInfo.getCityNamecn(),jyid,phone);
                   if(map.get("code").equals("200")){
                       return ResultUtil.success(map.get("data"));
                   }else if((map.get("code").equals("201"))){
                       return ResultUtil.error(201,"该车型尚不能估值");
                   }else if((map.get("code").equals("500"))){
                       return ResultUtil.error(500,"系统内部错误");
                   }
                }
            }else{
                //调用一次估价
                Map map=oldGuJia(carNumberId,moderyers,cityId,Mileage,pid,carModelName,createBy,cityInfo.getCityNamecn(),jyid,phone);
                if(map.get("code").equals("200")){
                    return ResultUtil.success(map.get("data"));
                }else if((map.get("code").equals("201"))){
                    return ResultUtil.error(201,"该车型尚不能估值");
                }else if((map.get("code").equals("500"))){
                    return ResultUtil.error(500,"系统内部错误");
                }
            }
        }else if(type.equals("2")){
            //pc
             carModelTiema=request.getParameter("carModelTiema");//获得车型铁码mvn
        }

        //第一步*****************计算拆车间之和
        String chaiFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"demolition_money");//查询车型拆车件发动机总成价格是否为空
        String chaiBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"demolition_money");//查询车型拆车件变速箱价格是否为空
        String chaiBSXmoney2=tieshangjCarPiecesService.selectMoneyNullBorF("19",carModelTiema,"demolition_money");//查询车型拆车件变速箱价格是否为空
        System.out.println("chaiFDJmoney:"+chaiFDJmoney);
        System.out.println("chaiBSXmoney:"+chaiBSXmoney);
        System.out.println("chaiBSXmoney2:"+chaiBSXmoney2);
        String sumMoneyChai="";
        String sumMoneyJiu="";
        if(((StringUtils.isBlank(chaiFDJmoney)&&StringUtils.isNotBlank(chaiBSXmoney)&&StringUtils.isBlank(chaiBSXmoney2)))){
            System.out.println("拆车件发动机总成价格为空，拆车件(自动)变速箱价格不为空，拆车件(手动)变速箱价格为空，");
            //1.if旧车件发动机总成价格为空，旧车件变速箱价格不为空
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&StringUtils.isNotBlank(chaiFDJmoney)&&StringUtils.isBlank(chaiBSXmoney2))){
            //2.if旧车件变速箱价格为空，旧车件发动机总长价格不为空
            System.out.println("拆车件（自动）变速箱价格为空，拆车件(手动)变速箱价格为空，拆车件发动机总长价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyTwo("2","18","19","33",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&StringUtils.isBlank(chaiFDJmoney)&&StringUtils.isBlank(chaiBSXmoney2))){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("拆车件发动机总成价格为空，拆车件（自动）变速箱价格为空，拆车件(手动)变速箱价格为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyThree("2","18","19",carModelTiema,"demolition_money");
        }else if((StringUtils.isNotBlank(chaiBSXmoney)&&StringUtils.isNotBlank(chaiFDJmoney)&&StringUtils.isBlank(chaiBSXmoney2))){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("拆车件(自动)变速箱价格不为空，拆车件(手动)变速箱价格为空，拆车件发动机总成价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyFour("2","19","24","33",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&StringUtils.isBlank(chaiFDJmoney)&&StringUtils.isNotBlank(chaiBSXmoney2))){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("拆车件发动机总成价格为空，拆车件（自动）变速箱价格为空，拆车件(手动)变速箱价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyFive("2","20","24","18",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&StringUtils.isNotBlank(chaiFDJmoney)&&StringUtils.isNotBlank(chaiBSXmoney2))){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("拆车件(自动)变速箱价格为空，拆车件(手动)变速箱价格不为空，拆车件发动机总成价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneySix("2","20","24","18","33",carModelTiema,"demolition_money");
        }
        //第二步****************计算旧车件之和
        String jiuFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"old_money");;//查询车型旧车件发动机总成价格是否为空
        String jiuBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"old_money");//查询车型旧车件(自动)变速箱价格是否为空
        String jiuBSXmoney2=tieshangjCarPiecesService.selectMoneyNullBorF("19",carModelTiema,"old_money");//查询车型旧车件(手动)变速箱价格是否为空
        System.out.println("jiuFDJmoney:"+jiuFDJmoney);
        System.out.println("jiuBSXmoney:"+jiuBSXmoney);
        System.out.println("jiuBSXmoney2:"+jiuBSXmoney2);
        if(((StringUtils.isBlank(jiuFDJmoney)&&StringUtils.isNotBlank(jiuBSXmoney)&&StringUtils.isBlank(jiuBSXmoney2)))){
            System.out.println("旧车件发动机总成价格为空，旧车件(自动)变速箱价格不为空，旧车件(手动)变速箱价格为空，");
            //1.if旧车件发动机总成价格为空，旧车件变速箱价格不为空
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isNotBlank(jiuFDJmoney)&&StringUtils.isBlank(jiuBSXmoney2))){
            //2.if旧车件变速箱价格为空，旧车件发动机总长价格不为空
            System.out.println("旧车件（自动）变速箱价格为空，旧车件(手动)变速箱价格为空，旧车件发动机总长价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyTwo("2","18","19","33",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isBlank(jiuFDJmoney)&&StringUtils.isBlank(jiuBSXmoney2))){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("旧车件发动机总成价格为空，旧车件（自动）变速箱价格为空，旧车件(手动)变速箱价格为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyThree("2","18","19",carModelTiema,"old_money");
        }else if((StringUtils.isNotBlank(jiuBSXmoney)&&StringUtils.isNotBlank(jiuFDJmoney)&&StringUtils.isBlank(jiuBSXmoney2))){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("旧车件(自动)变速箱价格不为空，旧车件(手动)变速箱价格为空，旧车件发动机总成价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyFour("2","19","24","33",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isBlank(jiuFDJmoney)&&StringUtils.isNotBlank(jiuBSXmoney2))){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("旧车件发动机总成价格为空，旧车件（自动）变速箱价格为空，旧车件(手动)变速箱价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyFive("2","20","24","18",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isNotBlank(jiuFDJmoney)&&StringUtils.isNotBlank(jiuBSXmoney2))){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("旧车件(自动)变速箱价格为空，旧车件(手动)变速箱价格不为空，旧车件发动机总成价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneySix("2","20","24","18","33",carModelTiema,"old_money");
        }
        //第三步****************查询废料价格
        //1.查询废料价格
        TieshangjCarWaste tieshangjCarWaste1=tieshangjCarWasteService.selectByPrimaryKey(1);
        BigDecimal feioldmoney1 = new BigDecimal(tieshangjCarWaste1.getOldMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi1 = new BigDecimal(tieshangjCarWaste1.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney1 = new BigDecimal(tieshangjCarWaste1.getDemolitionMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi1 = new BigDecimal(tieshangjCarWaste1.getDemolitionXi()).setScale(2, BigDecimal.ROUND_HALF_UP);

        TieshangjCarWaste tieshangjCarWaste2=tieshangjCarWasteService.selectByPrimaryKey(2);
        BigDecimal feioldmoney2 = new BigDecimal(tieshangjCarWaste2.getOldMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi2 = new BigDecimal(tieshangjCarWaste2.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney2 = new BigDecimal(tieshangjCarWaste2.getDemolitionMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi2 = new BigDecimal(tieshangjCarWaste2.getDemolitionXi()).setScale(2, BigDecimal.ROUND_HALF_UP);

        TieshangjCarWaste tieshangjCarWaste3=tieshangjCarWasteService.selectByPrimaryKey(3);
        BigDecimal feioldmoney3 = new BigDecimal(tieshangjCarWaste3.getOldMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi3 = new BigDecimal(tieshangjCarWaste3.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney3 = new BigDecimal(tieshangjCarWaste3.getDemolitionMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi3 = new BigDecimal(tieshangjCarWaste3.getDemolitionXi()).setScale(2, BigDecimal.ROUND_HALF_UP);

        TieshangjCarWaste tieshangjCarWaste4=tieshangjCarWasteService.selectByPrimaryKey(4);
        BigDecimal feioldmoney4 = new BigDecimal(tieshangjCarWaste4.getOldMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi4 = new BigDecimal(tieshangjCarWaste4.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney4 = new BigDecimal(tieshangjCarWaste4.getDemolitionMoney()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi4 = new BigDecimal(tieshangjCarWaste4.getDemolitionXi()).setScale(2, BigDecimal.ROUND_HALF_UP);
        //废料旧相加
        BigDecimal feijiu=feioldmoney1.multiply(feioldxi1).add(feioldmoney2.multiply(feioldxi2)).add(feioldmoney3.multiply(feioldxi3));
        System.out.println(feijiu);
        //废料拆相加
        BigDecimal feichai=feidemolitimoney1.multiply(feidemolitixi1).add(feidemolitimoney2.multiply(feidemolitixi2)).add(feidemolitimoney3.multiply(feidemolitixi3)).add(feidemolitimoney4.multiply(feidemolitixi4));
        //根据铁码查看车型重量
        String carweight= tieshangjCarModelService.selectByPrimarytiema(carModelTiema);
        if(StringUtils.isBlank("carweight")||carweight==null){
            carweight="1";
        }
        BigDecimal zbzl = new BigDecimal(carweight).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal oldfeiMoney=zbzl.multiply(feijiu).add(feioldmoney4.multiply(feioldxi4));
        BigDecimal chaifeiMoney=zbzl.multiply(feichai);
        //第四步****************计算利润系数
        String tieshangjCarProfit=tieshangjCarProfitService.selectLiRun(carModelTiema);
        System.out.println("lirunxishu:"+tieshangjCarProfit);
        if(tieshangjCarProfit==null||tieshangjCarProfit.equals("")){
            tieshangjCarProfit="1";
        }
        //第五步****************区域人工调整数
        String arnum=tieshangjCarRegionalArtificialService.selectArtifi(carModelTiema,pid);
        if(arnum==null){
            arnum="0";
        }
        BigDecimal num = new BigDecimal("2");
        num=num.setScale(2, BigDecimal.ROUND_HALF_UP);
        if(StringUtils.isBlank(sumMoneyChai)){
            sumMoneyChai="0";
        }
        if(StringUtils.isBlank(sumMoneyJiu)){
            sumMoneyJiu="0";
        }
        BigDecimal sumMoneyChais = new BigDecimal(sumMoneyChai);
        sumMoneyChais=sumMoneyChais.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal sumMoneyJius = new BigDecimal(sumMoneyJiu);
        sumMoneyJius=sumMoneyJius.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal Profit = new BigDecimal(tieshangjCarProfit);
        Profit=Profit.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal arnums = new BigDecimal(arnum);
        arnums=arnums.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("拆车件之和："+sumMoneyChais);
        System.out.println("旧车件之和："+sumMoneyJius);
        System.out.println("废料拆："+chaifeiMoney);
        System.out.println("废料旧："+oldfeiMoney);
        System.out.println("系数："+Profit);
        System.out.println("区域人工调整数："+arnums);
        logger.info("拆车件之和："+sumMoneyChais);
        logger.info("旧车件之和："+sumMoneyJius);
        logger.info("废料拆："+chaifeiMoney);
        logger.info("废料旧："+oldfeiMoney);
        logger.info("系数："+Profit);
        logger.info("区域人工调整数："+arnums);
        //计算公式：（（拆车件之和+废料拆+旧车件之和+废料旧）/2）*利润系数 土 区域调整数
        BigDecimal sum=((sumMoneyChais.add(chaifeiMoney).add(sumMoneyJius).add(oldfeiMoney)).divide(num,2,BigDecimal.ROUND_HALF_UP)).multiply(Profit).add(arnums);
        /*BigDecimal sum=((((sumMoneyChais.add(sumMoneyJius)).divide(num,2,BigDecimal.ROUND_HALF_UP)).add(moneyWastes)).multiply(Profit)).add(arnums);*/
        sum=sum.setScale(2, BigDecimal.ROUND_HALF_UP);
        if(type.equals("1")){
            TieshangjHistory tieshangjHistory=new TieshangjHistory();
            tieshangjHistory.setCarModelName(carModelName);
            tieshangjHistory.setCreateTime(new Date());
            tieshangjHistory.setCreateBy(createBy);
            tieshangjHistory.setFactors(moderyers+"年 | "+Mileage+"万公里 | "+cityInfo.getCityNamecn());
            tieshangjHistory.setFruit(sum.toString());
            tieshangjHistory.setType("2");
            tieshangjHistory.setTu("http://pic1.win4000.com/wallpaper/4/57cd2eaeeff03_860_710.jpg");
            tieshangjHistory.setJyid(jyid);
            tieshangjHistory.setPhone(phone);
            tieshangjHistoryService.insertSelective(tieshangjHistory);
        }
        return ResultUtil.success(sum);

    }
    public Map oldGuJia(String carNumberId,String moderyers,String cityId,String Mileage,String pid,String carModelName,String createBy,String cityname,String jyid,String phone){
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String jieguo=HttpClient.sendGetRequest(ip+port+"/ctselect?carNumberId="+carNumberId+"&"+"moderyers="+moderyers,params,headers);
        JSONObject jobj = JSON.parseObject(jieguo);
        String code=jobj.get("code").toString();
        Map map=new HashMap();
        if(code.equals("200")){
            String cheng=jobj.getJSONObject("data").get("cheng").toString();
            String jieguo2=HttpClient.sendGetRequest(ip+port+"/selectCountModelRatio?id="+carNumberId,params,headers);
            JSONObject jobj2 = JSON.parseObject(jieguo2);
            String code2=jobj2.get("code").toString();
            String data=jobj2.get("data").toString();
            if(code2.equals("200")){
                if(data.equals("0")){
                    //该车型不能估值
                    map.put("code","201");
                    map.put("data","该车型尚不能估值");
                    return map;
                }else{
                    String jieguo3=HttpClient.sendGetRequest(ip+port+"/calculation2?carNumberId="+carNumberId+"&provinceId="+pid+"&cityId="+cityId+"&Mileage="+Mileage+"&time="+moderyers,params,headers);
                    JSONObject jobj3 = JSON.parseObject(jieguo3);
                    String code3=jobj3.get("code").toString();
                    System.out.println(jobj3);
                    if(code3.equals("200")){
                        String data3=jobj3.getJSONObject("data").get("bad").toString();
                        BigDecimal chengb = new BigDecimal(cheng).setScale(2, BigDecimal.ROUND_HALF_UP);
                        BigDecimal datab = new BigDecimal(data3).setScale(2, BigDecimal.ROUND_HALF_UP);
                        BigDecimal result=chengb.multiply(datab);
                        double results = result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        DecimalFormat df = new DecimalFormat("#0.00");
                        System.out.println("results:"+df.format(results));
                        TieshangjHistory tieshangjHistory=new TieshangjHistory();
                        tieshangjHistory.setCarModelName(carModelName);
                        tieshangjHistory.setCreateTime(new Date());
                        tieshangjHistory.setCreateBy(createBy);
                        tieshangjHistory.setFactors(moderyers+"年 | "+Mileage+"万公里 | "+cityname);
                        tieshangjHistory.setFruit(String.valueOf(df.format(results)));
                        tieshangjHistory.setType("1");
                        tieshangjHistory.setTu("http://hbimg.b0.upaiyun.com/dc8cdc8d3569e7710f24e7e6dbeecf61d1a7100c34869-sgKcVk_fw658");
                        tieshangjHistory.setJyid(jyid);
                        tieshangjHistory.setPhone(phone);
                        tieshangjHistoryService.insertSelective(tieshangjHistory);
                        map.put("code","200");
                        map.put("data",results);
                        return map;
                    }
                    System.out.println("结果："+jieguo3);
                }
            }
                     /*if(state.equals("1")){
                         String xi=jobj.getJSONObject("data").getJSONObject("chlCarmodelGroupFixedvalueCt").get("value").toString();
                         String jieguo2=HttpClient.sendGetRequest("http://10.0.0.210:18061/selectCountModelRatio?id="+carNumberId,params,headers);
                         JSONObject jobj2 = JSON.parseObject(jieguo2);
                         String code2=jobj2.get("code").toString();
                         String data=jobj2.get("data").toString();
                         if(code2.equals("200")){
                            if(data.equals("0")){
                                //该车型不能估值
                                return ResultUtil.error(201,"该车型尚不能估值");
                            }else{
                                String jieguo3=HttpClient.sendGetRequest("http://10.0.0.210:18061/calculation?carNumberId="+carNumberId+"&provinceId="+pid+"&cityId="+cityId+"&Mileage="+Mileage+"&time="+moderyers,params,headers);
                                JSONObject jobj3 = JSON.parseObject(jieguo3);
                                String code3=jobj3.get("code").toString();
                                if(code3.equals("200")){
                                    String data3=jobj3.getJSONObject("jobj3").get("bad").toString();
                                    return ResultUtil.success(data3);
                                }
                                System.out.println("结果："+jieguo3);
                            }
                         }
                     }else{
                         String cheng=jobj.getJSONObject("data").get("cheng").toString();
                         String jieguo2=HttpClient.sendGetRequest("http://10.0.0.210:18061/selectCountModelRatio?id="+carNumberId,params,headers);
                         JSONObject jobj2 = JSON.parseObject(jieguo2);
                         String code2=jobj2.get("code").toString();
                         String data=jobj2.get("data").toString();
                         if(code2.equals("200")){
                             if(data.equals("0")){
                                 //该车型不能估值
                                 return ResultUtil.error(201,"该车型尚不能估值");
                             }else{
                                 String jieguo3=HttpClient.sendGetRequest("http://10.0.0.210:18061/calculation?carNumberId="+carNumberId+"&provinceId="+pid+"&cityId="+cityId+"&Mileage="+Mileage+"&time="+moderyers,params,headers);
                                 JSONObject jobj3 = JSON.parseObject(jieguo3);
                                 String code3=jobj3.get("code").toString();
                                 if(code3.equals("200")){
                                     String data3=jobj3.getJSONObject("jobj3").get("bad").toString();
                                     return ResultUtil.success(data3);
                                 }
                                 System.out.println("结果："+jieguo3);
                             }
                         }
                     }*/
        }
        map.put("code","500");
        map.put("data","系统出现错误");
        return map;
    }
    //查询里程
    @RequestMapping(value = "selectLicheng",method = RequestMethod.GET)
    @ResponseBody
    public Object selectLicheng(HttpServletRequest request){
        MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String jieguo3=HttpClient.sendGetRequest("http://10.0.0.210:18061/selectAllMileage",params,headers);
        return jieguo3;
    }
}
