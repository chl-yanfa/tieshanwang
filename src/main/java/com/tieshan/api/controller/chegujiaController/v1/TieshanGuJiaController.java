package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;
import com.tieshan.api.service.chegujiaService.v1.*;
import com.tieshan.api.service.shortMessageApiService.v1.TbVerificationCodeService;
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
    @RequestMapping(value = "gujia",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult gujia(HttpServletRequest request){
        String carModelTiema=request.getParameter("carModelTiema");//获得车型铁码
        String pid=request.getParameter("pid");//获得省份id
        //第一步*****************计算拆车间之和
        String chaiFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"demolition_money");//查询车型拆车件发动机总成价格是否为空
        String chaiBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"demolition_money");//查询车型拆车件变速箱价格是否为空
        System.out.println("chaiFDJmoney:"+chaiFDJmoney);
        System.out.println("chaiBSXmoney:"+chaiBSXmoney);
        String sumMoneyChai="";
        String sumMoneyJiu="";
        if((StringUtils.isBlank(chaiFDJmoney)&&StringUtils.isNotBlank(chaiBSXmoney))){
            System.out.println("拆车件发动机总成价格为空，拆车件变速箱价格不为空");
            //1.if拆车件发动机总成价格为空，拆车件变速箱价格不为空
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&StringUtils.isNotBlank(chaiFDJmoney))){
            //2.if拆车件变速箱价格为空，拆车件发动机总长价格不为空
            System.out.println("拆车件变速箱价格为空，拆车件发动机总长价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyOne("18","3","16",carModelTiema,"demolition_money");
        }else if((StringUtils.isBlank(chaiBSXmoney)&&(StringUtils.isBlank(chaiFDJmoney)))){
            //3.if拆车件发动机总成价格为空，拆车件变速箱价格为空
            System.out.println("拆车件发动机总成价格为空，拆车件变速箱价格为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyTwo("2","18",carModelTiema,"demolition_money");
        }else if((StringUtils.isNotBlank(chaiBSXmoney)&&StringUtils.isNotBlank(chaiBSXmoney))){
            //4.if拆车件变速箱价格不为空，拆车件发动机总成价格不为空
            System.out.println("拆车件变速箱价格不为空，拆车件发动机总成价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyThree("3","16","19","24",carModelTiema,"demolition_money");
        }
        //第二步****************计算旧车件之和
        String jiuFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"old_money");;//查询车型旧车件发动机总成价格是否为空
        String jiuBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"old_money");//查询车型旧车件变速箱价格是否为空
        if(((StringUtils.isBlank(jiuFDJmoney)&&StringUtils.isNotBlank(jiuBSXmoney)))){
            System.out.println("旧车件发动机总成价格为空，旧车件变速箱价格不为空");
            //1.if旧车件发动机总成价格为空，旧车件变速箱价格不为空
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isNotBlank(jiuFDJmoney))){
            //2.if旧车件变速箱价格为空，旧车件发动机总长价格不为空
            System.out.println("旧车件变速箱价格为空，旧车件发动机总长价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyOne("18","3","16",carModelTiema,"old_money");
        }else if((StringUtils.isBlank(jiuBSXmoney)&&StringUtils.isBlank(jiuFDJmoney))){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("旧车件发动机总成价格为空，旧车件变速箱价格为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyTwo("2","18",carModelTiema,"old_money");
        }else if((StringUtils.isNotBlank(jiuBSXmoney)&&StringUtils.isNotBlank(jiuFDJmoney))){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("旧车件变速箱价格不为空，旧车件发动机总成价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyThree("3","16","19","24",carModelTiema,"old_money");
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
        System.out.println("区域系数："+Profit);
        System.out.println("人工调整数："+arnums);
        //计算公式：（（拆车件之和+废料拆+旧车件之和+废料旧）/2）*利润系数 土 区域调整数
        BigDecimal sum=((sumMoneyChais.add(chaifeiMoney).add(sumMoneyJius).add(oldfeiMoney)).divide(num,2,BigDecimal.ROUND_HALF_UP)).multiply(Profit).add(arnums);
        /*BigDecimal sum=((((sumMoneyChais.add(sumMoneyJius)).divide(num,2,BigDecimal.ROUND_HALF_UP)).add(moneyWastes)).multiply(Profit)).add(arnums);*/
        sum=sum.setScale(2, BigDecimal.ROUND_HALF_UP);
        return ResultUtil.success(sum);

    }
}
