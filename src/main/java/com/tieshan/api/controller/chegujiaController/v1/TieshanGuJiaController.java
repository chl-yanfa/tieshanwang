package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPiecesService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarProfitService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarRegionalArtificialService;
import com.tieshan.api.service.shortMessageApiService.v1.TbVerificationCodeService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RestController
public class TieshanGuJiaController {
    @Autowired
    private TieshangjCarPiecesService tieshangjCarPiecesService;
    @Autowired
    private TieshangjCarProfitService tieshangjCarProfitService;
    @Autowired
    private TieshangjCarRegionalArtificialService tieshangjCarRegionalArtificialService;
    @Autowired
    private TbVerificationCodeService tbVerificationCodeService;
    @RequestMapping(value = "gujia",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult gujia(HttpServletRequest request){
        String phone=request.getParameter("phone");
        String carModelTiema=request.getParameter("carModelTiema");//获得车型铁码
        String pid=request.getParameter("pid");//获得省份id
        //是否需要验证码验证
        if(!phone.equals("200")){
            //验证码验证
            String yType=request.getParameter("yType");//验证码类型
            String yCode=request.getParameter("yCode");//验证码
            String validateCodeByDB=tbVerificationCodeService.getValidateCode(phone,yType);
            if(yCode.equals(validateCodeByDB)) {
               //正确，进行估价
                Object sum=gujias(carModelTiema,pid);
                return ResultUtil.success(sum);
            }else{
                //错误
                return ResultUtil.error(500,"验证码错误");
            }
        }else{
            //不需要验证码验证
            Object sum=gujias(carModelTiema,pid);
            return ResultUtil.success(sum);
        }

    }
    public Object gujias(String carModelTiema,String pid){
        //第一步*****************计算拆车间之和
        String chaiFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"demolition_money");//查询车型拆车件发动机总成价格是否为空
        String chaiBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"demolition_money");//查询车型拆车件变速箱价格是否为空
        System.out.println("chaiFDJmoney:"+chaiFDJmoney);
        System.out.println("chaiBSXmoney:"+chaiBSXmoney);
        String sumMoneyChai="";
        String sumMoneyJiu="";
        if(chaiFDJmoney.equals("null")&&!chaiBSXmoney.equals("null")){
            System.out.println("拆车件发动机总成价格为空，拆车件变速箱价格不为空");
            //1.if拆车件发动机总成价格为空，拆车件变速箱价格不为空
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"demolition_money");
        }else if(chaiBSXmoney.equals("null")&&!chaiFDJmoney.equals("null")){
            //2.if拆车件变速箱价格为空，拆车件发动机总长价格不为空
            System.out.println("拆车件变速箱价格为空，拆车件发动机总长价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyOne("18","3","16",carModelTiema,"demolition_money");
        }else if(chaiBSXmoney.equals("null")&&chaiFDJmoney.equals("null")){
            //3.if拆车件发动机总成价格为空，拆车件变速箱价格为空
            System.out.println("拆车件发动机总成价格为空，拆车件变速箱价格为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyTwo("2","18",carModelTiema,"demolition_money");
        }else if(!chaiBSXmoney.equals("null")&&!chaiFDJmoney.equals("null")){
            //4.if拆车件变速箱价格不为空，拆车件发动机总成价格不为空
            System.out.println("拆车件变速箱价格不为空，拆车件发动机总成价格不为空");
            sumMoneyChai=tieshangjCarPiecesService.selectSumMoneyThree("3","16","19","24",carModelTiema,"demolition_money");
        }
        //第二步****************计算旧车件之和
        String jiuFDJmoney=tieshangjCarPiecesService.selectMoneyNullBorF("2",carModelTiema,"old_money");;//查询车型旧车件发动机总成价格是否为空
        String jiuBSXmoney=tieshangjCarPiecesService.selectMoneyNullBorF("18",carModelTiema,"old_money");//查询车型旧车件变速箱价格是否为空
        if(jiuFDJmoney.equals("null")&&!jiuBSXmoney.equals("null")){
            System.out.println("旧车件发动机总成价格为空，旧车件变速箱价格不为空");
            //1.if旧车件发动机总成价格为空，旧车件变速箱价格不为空
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyOne("2","19","24",carModelTiema,"old_money");
        }else if(jiuBSXmoney.equals("null")&&!jiuFDJmoney.equals("null")){
            //2.if旧车件变速箱价格为空，旧车件发动机总长价格不为空
            System.out.println("旧车件变速箱价格为空，旧车件发动机总长价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyOne("18","3","16",carModelTiema,"old_money");
        }else if(jiuBSXmoney.equals("null")&&jiuFDJmoney.equals("null")){
            //3.if旧车件发动机总成价格为空，旧车件变速箱价格为空
            System.out.println("旧车件发动机总成价格为空，旧车件变速箱价格为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyTwo("2","18",carModelTiema,"old_money");
        }else if(!jiuBSXmoney.equals("null")&&!jiuFDJmoney.equals("null")){
            //4.if旧车件变速箱价格不为空，旧车件发动机总成价格不为空
            System.out.println("旧车件变速箱价格不为空，旧车件发动机总成价格不为空");
            sumMoneyJiu=tieshangjCarPiecesService.selectSumMoneyThree("3","16","19","24",carModelTiema,"old_money");
        }
        //第三步****************计算废料价格
        String moneyWaste=tieshangjCarPiecesService.selectMoneyWaste(carModelTiema);
        if(moneyWaste==null){
            moneyWaste="0";
        }
        //第四步****************计算利润系数
        TieshangjCarProfit tieshangjCarProfit=tieshangjCarProfitService.selectLiRun(carModelTiema);
        if(tieshangjCarProfit.getProfit()==null){
            tieshangjCarProfit.setProfit("0");
        }
        //第五步****************区域人工调整数
        String arnum=tieshangjCarRegionalArtificialService.selectArtifi(carModelTiema,pid);
        if(arnum==null){
            arnum="0";
        }
        BigDecimal num = new BigDecimal("2");
        num=num.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal sumMoneyChais = new BigDecimal(sumMoneyChai);
        sumMoneyChais=sumMoneyChais.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal sumMoneyJius = new BigDecimal(sumMoneyJiu);
        sumMoneyJius=sumMoneyJius.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal moneyWastes = new BigDecimal(moneyWaste);
        moneyWastes=moneyWastes.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal Profit = new BigDecimal(tieshangjCarProfit.getProfit());
        Profit=Profit.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal arnums = new BigDecimal(arnum);
        arnums=arnums.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("拆车件之和："+sumMoneyChais);
        System.out.println("旧车件之和："+sumMoneyJius);
        System.out.println("废料价之和："+moneyWastes);
        System.out.println("区域系数："+Profit);
        System.out.println("人工调整数："+arnums);
        //计算公式：（（拆车件之和+旧车件之和）/2+废料之和）*利润系数 土 区域调整数
        BigDecimal sum=((((sumMoneyChais.add(sumMoneyJius)).divide(num,2,BigDecimal.ROUND_HALF_UP)).add(moneyWastes)).multiply(Profit)).add(arnums);
        sum=sum.setScale(2, BigDecimal.ROUND_HALF_UP);
        return sum;
    }
}
