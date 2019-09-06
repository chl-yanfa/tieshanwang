package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;
import com.tieshan.api.service.chegujiaService.v1.*;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/carmodelAdmin/")
public class TieshangjCarModelAdminController {
    @Autowired
    private TieshangjCarModelService tieshangjCarModelService;
    @Autowired
    private TieshangjCarPiecesService tieshangjCarPiecesService;
    @Autowired
    private TieshangjCarWasteService tieshangjCarWasteService;
    @Autowired
    private TieshangjCarProfitService tieshangjCarProfitService;
    @Autowired
    private TieshangjCarRegionalArtificialService tieshangjCarRegionalArtificialService;
    @RequestMapping(value = "selectCarModelHou",method = RequestMethod.GET)
    @ResponseBody
    public Object selectCarModelHou(HttpServletRequest request, Map map){
        String carModelName=request.getParameter("carModelName");//车型名称
        String brandId=request.getParameter("brandId");//车标id
        String page=request.getParameter("page");//第几页数
        String pagesize=request.getParameter("pagesize");//每页显示数量
        map.put("carModelName",carModelName);
        map.put("brandId",brandId);
        map.put("page",(Integer.parseInt(page)-1)*Integer.parseInt(pagesize));
        map.put("pagesize",Integer.parseInt(pagesize));
        List<TieshangjCarModel> list=tieshangjCarModelService.selectAll(map);
        Integer num=tieshangjCarModelService.selectAllCount(map);
        Map map1=new HashMap();
        map1.put("total",num);
        map1.put("rows",list);
        return map1;
    }
    @RequestMapping(value = "selectCarModelbyId",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarModelbyId(HttpServletRequest request){
        String carModelId=request.getParameter("carModelId");//车型id
        TieshangjCarModel tieshangjCarModel=tieshangjCarModelService.selectByPrimaryKey(Integer.parseInt(carModelId));
        return ResultUtil.success(tieshangjCarModel);
    }
    @RequestMapping(value = "selectGj",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectGj(HttpServletRequest request){
        String carModelTiema=request.getParameter("tiema");
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
        BigDecimal feioldmoney1 = new BigDecimal(tieshangjCarWaste1.getOldMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi1 = new BigDecimal(tieshangjCarWaste1.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney1 = new BigDecimal(tieshangjCarWaste1.getDemolitionMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi1 = new BigDecimal(tieshangjCarWaste1.getDemolitionXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        TieshangjCarWaste tieshangjCarWaste2=tieshangjCarWasteService.selectByPrimaryKey(2);
        BigDecimal feioldmoney2 = new BigDecimal(tieshangjCarWaste2.getOldMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi2 = new BigDecimal(tieshangjCarWaste2.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney2 = new BigDecimal(tieshangjCarWaste2.getDemolitionMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi2 = new BigDecimal(tieshangjCarWaste2.getDemolitionXi()).setScale(3, BigDecimal.ROUND_HALF_UP);

        TieshangjCarWaste tieshangjCarWaste3=tieshangjCarWasteService.selectByPrimaryKey(3);
        BigDecimal feioldmoney3 = new BigDecimal(tieshangjCarWaste3.getOldMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi3 = new BigDecimal(tieshangjCarWaste3.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney3 = new BigDecimal(tieshangjCarWaste3.getDemolitionMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi3 = new BigDecimal(tieshangjCarWaste3.getDemolitionXi()).setScale(3, BigDecimal.ROUND_HALF_UP);

        TieshangjCarWaste tieshangjCarWaste4=tieshangjCarWasteService.selectByPrimaryKey(4);
        BigDecimal feioldmoney4 = new BigDecimal(tieshangjCarWaste4.getOldMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feioldxi4 = new BigDecimal(tieshangjCarWaste4.getOldXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitimoney4 = new BigDecimal(tieshangjCarWaste4.getDemolitionMoney()).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal feidemolitixi4 = new BigDecimal(tieshangjCarWaste4.getDemolitionXi()).setScale(3, BigDecimal.ROUND_HALF_UP);
        //废料旧相加
        BigDecimal feijiu=feioldmoney1.multiply(feioldxi1).add(feioldmoney2.multiply(feioldxi2)).add(feioldmoney3.multiply(feioldxi3));
        System.out.println(feijiu);
        //废料拆相加
        BigDecimal feichai=feidemolitimoney1.multiply(feidemolitixi1).add(feidemolitimoney2.multiply(feidemolitixi2)).add(feidemolitimoney3.multiply(feidemolitixi3));

        //根据铁码查看车型重量
        String carweight= tieshangjCarModelService.selectByPrimarytiema(carModelTiema);
        if(StringUtils.isBlank("carweight")||carweight==null){
            carweight="1";
        }
        BigDecimal zbzl = new BigDecimal(carweight).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal oldfeiMoney=zbzl.multiply(feijiu).add(feioldmoney4.multiply(feioldxi4)).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal chaifeiMoney=zbzl.multiply(feichai).add(feidemolitimoney4.multiply(feidemolitixi4)).setScale(2, BigDecimal.ROUND_HALF_UP);
        //第四步****************计算利润系数
        String tieshangjCarProfit=tieshangjCarProfitService.selectLiRun(carModelTiema);
        System.out.println("lirunxishu:"+tieshangjCarProfit);
        if(tieshangjCarProfit==null||tieshangjCarProfit.equals("")){
            tieshangjCarProfit="1";
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

        System.out.println("拆车件之和："+sumMoneyChais);
        System.out.println("旧车件之和："+sumMoneyJius);
        System.out.println("废料拆："+chaifeiMoney);
        System.out.println("废料旧："+oldfeiMoney);
        System.out.println("系数："+Profit);
        Map map=new HashMap();
        map.put("sumMoneyChais",sumMoneyChais);
        map.put("sumMoneyJius",sumMoneyJius);
        map.put("chaifeiMoney",chaifeiMoney);
        map.put("oldfeiMoney",oldfeiMoney);
        map.put("Profit",Profit);
        return ResultUtil.success(map);
    }
}
