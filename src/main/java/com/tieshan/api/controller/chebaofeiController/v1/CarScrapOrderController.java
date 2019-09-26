package com.tieshan.api.controller.chebaofeiController.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.*;
import com.tieshan.api.common.chebaofeiCommon.*;
import com.tieshan.api.mapper.chebaofeiMapper.v1.UserMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarPush;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.service.chebaofeiService.v1.CarPushService;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderService;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import com.tieshan.api.util.httpUtil.HttpClient;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.toolUtil.ClientUtil;
import com.tieshan.api.util.toolUtil.JYyPushUtil;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderConfirmAmountVO;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderExternalVO;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderKeywordVO;
import com.tieshan.api.vo.chebaofeiVo.v1.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.tcw.common.SendMailUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 17:52
 */
@RestController
@RequestMapping(value="/carscraporder-applet/order")
public class CarScrapOrderController {

    private static Logger log = Logger.getLogger(CarScrapOrderController.class);

    public static ResourceBundle CONFIG = ResourceBundle.getBundle("application");

    private static final String GUJIAURL = "http://127.0.0.1:8090/v1/gu/gujia";

    @Autowired
    CarScrapOrderService carScrapOrderService;

    @Autowired
    CarPushService carPushService;

    @Autowired
    JyModelService jyModelService;

    @Autowired
    UserMapper userMapper;

    /**
     * 订单分页查询
     * @param page
     * @param rows
     * @param paramter
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<PageResult<CarScrapOrderPageBO>> getOrderList(
            @RequestParam(value="page", defaultValue="1")Integer page,
            @RequestParam(value="rows", defaultValue="10")Integer rows,
            CarScrapOrderKeywordVO paramter) throws Exception{

        paramter.setClientId(ClientUtil.getUser().getId());
        PageResult<CarScrapOrderPageBO> pageResult = null;
        PageInfo<CarScrapOrderPageBO> pageInfo = null;
        if((paramter.getOrderStatus().equals("1")||paramter.getOrderStatus()=="1")){
            pageInfo =  carScrapOrderService.queryPageListByKeywordByChl(page, rows, paramter);
        }else{
            pageInfo =  carScrapOrderService.queryPageListByKeyword(page, rows, paramter);
        }
        if(pageInfo!=null){
            pageResult  = new PageResult<>();
            pageResult.setRows(pageInfo.getList());
            pageResult.setTotal(pageInfo.getTotal());
        }
        return new ResultBean<>(pageResult);
    }

    /**
     * 根据id获取订单审核进度详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getOrderAuditInfo/{id}",method = RequestMethod.GET)
    public ResultBean<OrderAduitBO> getOrderAuditInfo(@PathVariable("id")String id) throws Exception{
        return new ResultBean<>(carScrapOrderService.getOrderAuditInfo(id));
    }


    /**
     * 新增订单
     * @param carScrapOrderVO
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<Boolean> addOrder(@RequestBody CarScrapOrderExternalVO carScrapOrderVO) throws Exception{
        carScrapOrderVO.setCreater(ClientUtil.getUser().getId());
        carScrapOrderVO.setClientId(ClientUtil.getUser().getId());

        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String pid = carScrapOrderVO.getPid();
        String type = carScrapOrderVO.getType();
        String cityId = carScrapOrderVO.getCityId();

        String jyid = carScrapOrderVO.getJyid();
        String carNumberId = carScrapOrderVO.getCarNumberId();

        String moderyers = carScrapOrderVO.getCarAge();
        String Mileage = carScrapOrderVO.getDrivingMileage();

        String carModelName = carScrapOrderVO.getCarModelNumber();
        String createBy = "admin";
        String phone = carScrapOrderVO.getTakeCarContactNumber();

        try{
            String jieguo= HttpClient.sendGetRequest(GUJIAURL+"?pid="+pid
                            +"&"+"type="+type
                            +"&"+"jyid="+jyid
                            +"&"+"carNumberId="+carNumberId
                            +"&"+"moderyers="+moderyers
                            +"&"+"cityId="+cityId
                            +"&"+"Mileage="+Mileage
                            +"&"+"carModelName="+carModelName
                            +"&"+"createBy="+createBy
                            +"&"+"phone="+phone,
                    null,headers);
            System.out.println("结果"+jieguo);
            JSONObject jobj = JSON.parseObject(jieguo);
            String code=jobj.get("data").toString();
            if(code!=null){
                System.out.println("估价结果为:"+code);
                carScrapOrderVO.setReferPrice(new BigDecimal(code));
            }
        }catch (NullPointerException e){
            System.err.println("该车型暂且不能估值!");
        }

        //判断登录人是个人用户还是大客户
        carScrapOrderVO.setClientType(ClientUtil.getUser().getUserType());

        //save
        int result = carScrapOrderService.save(carScrapOrderVO);

        if(result==1){
            //订单新增完毕后通知所有的业务员
            UserVO userParam = new UserVO();
            List<UserBO> listData = userMapper.queryPageUser(userParam);
            List<CarPush> carPushlist = carPushService.getAllCarPush();
            CarPush carPush = carPushlist.get(0);
            System.out.println("执行业务员通知_运营端APP");
            for (int i=0;i<listData.size();i++){
                System.out.println("循环通知_运营端APP!");
                JYyPushUtil.sendToRegistrationId(listData.get(i).getId(),carPush.getNotificationTitle(),carPush.getMsgTitle(),carPush.getMsgContent(),"1");
            }
            return new ResultBean<>(true);
        }else{
            return new ResultBean<>(false);
        }
    }


    /**
     * 根据订单id删除订单
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResultBean<Boolean> deleteOrderById(@RequestParam(value = "id") String id) throws Exception{
        return new ResultBean<>(carScrapOrderService.deleteByPrimaryKey(id, ClientUtil.getUser().getId()) == 1);
    }


    /**
     * 根据订单id获取订单详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResultBean<CarScrapOrderBO> getOrderById(@PathVariable("id")String id) throws Exception{
        CarScrapOrderBO cbo = carScrapOrderService.queryBOById(id);
        if(cbo.getOrderStatus()==12 && cbo.getOrderAmount()!=null && cbo.getSinceQuote()!=null && (cbo.getOrderAmount().compareTo(cbo.getSinceQuote())==1) ){
            cbo.setOrderStatusCN("未审核");
        }else if(cbo.getOrderStatus()==13 && cbo.getOrderAmount()!=null && cbo.getSinceQuote()!=null
                && ((cbo.getOrderAmount().compareTo(cbo.getSinceQuote())==-1) || (cbo.getOrderAmount().compareTo(cbo.getSinceQuote())==0))){
            cbo.setOrderStatusCN("已审核");
        }else if(cbo.getOrderStatus()==12 && cbo.getSinceQuote()==null){
            cbo.setOrderStatusCN("总部待报价");
        }else if(cbo.getOrderStatus()==13 && cbo.getSinceQuote()==null){
            cbo.setOrderStatusCN("已报价");
        }
        switch (cbo.getOrderStatus()){
            case 1:
                cbo.setOrderStatusCN("待派单");
                break;
            case 2:
                cbo.setOrderStatusCN("待接收");
                break;
            case 3:
                cbo.setOrderStatusCN("待入场"); //已接收=待入场
                break;
            case 4:
                cbo.setOrderStatusCN("待报废");
                break;
            case 5:
                cbo.setOrderStatusCN("已完成");
                break;
            case 11:
                cbo.setOrderStatusCN("分部待报价");
                break;
            case 33:
                cbo.setOrderStatusCN("待接单");
                break;
            case 96:
                cbo.setOrderStatusCN("待审核");
                break;
        }
        return new ResultBean<>(cbo);
    }


    /**
     * 根据id更新订单信息（交接过来的代码此处只更新了操作人，这个操作表示看不懂~~~~）
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean<Boolean> updateOrder(@PathVariable("id")String id, HttpServletRequest request) throws Exception{

        CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
        carScrapOrder.setOperator(ClientUtil.getUser().getId());
        carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
        return new ResultBean<>(carScrapOrderService.update(carScrapOrder)==1);
    }


    /**
     * 根据订单id取消订单
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "cancelOrder", method = RequestMethod.PUT)
    public ResultBean<Boolean> cancelOrder(@RequestParam(name="id") String id, @RequestParam(name = "cancelMemo",required = false) String cancelMemo) throws Exception {
        return new ResultBean<>(carScrapOrderService.cancelOrder(id, cancelMemo, ClientUtil.getUser().getId()) == 1);
    }


    /**
     * 根据订单id确认报价
     * @param confirmAmountVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "confirmAmount", method = RequestMethod.PUT)
    public ResultBean<Boolean> confirmAmount(@RequestBody CarScrapOrderConfirmAmountVO confirmAmountVO) throws Exception {
        confirmAmountVO.setOperator(ClientUtil.getUser().getId());
        return new ResultBean<>(carScrapOrderService.confirmAmount(confirmAmountVO));
    }


    /**
     * 发送邮件
     * @param email
     * @return
     */
    @RequestMapping(value = "sendEmail", method = RequestMethod.POST)
    public ResultBean<String> sendEmail(@RequestParam(value="email") String email){
        ResultBean<String> res = new ResultBean<>();
        if(null != email || !"".equals(email)){
            sendMail(email);
            res.setCode(200);
            res.setMsg("邮件发送成功！");
        }else {
            res.setCode(500);
            res.setMsg("邮件发送失败！");
        }
        return res;
    }

    private void sendMail(final String email){
        try {
            Thread thread = new Thread() {
                @Override
                public void run() {
                // 给保险公司发送报价单邮件
                if (email != null) {
                    try {
                        SendMailUtils sendMailUtils = new SendMailUtils();
                        List<String> toList = new ArrayList<String>();
                        if (StringUtils.isNotEmpty(email)) {
                            toList = Arrays.asList(email.split(";"));
                        }
                        Object[] params = {"车互联"};
                        List<String> files = new ArrayList<String>();
                        String url = CONFIG.getString("filepath");
                        files.add(url +"sqcrs.docx");
                        String content = sendMailUtils.getTemplateContent("eTemplate",
                                params);
                        if(toList!=null&&toList.size()>0) {
                            sendMailUtils.sendMail("【机动车业务授权委托承诺书】", content, toList, null, null,
                                    files);
                            log.info("[Send  Success mail ]");
                        }else {
                            log.error("[Send  error mail Fail : No mail needs to be sent]");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                }
            };
            thread.start();
        } catch (Exception e) {
            log.error("[Send QuotationBill error mail Fail]");
        }
    }

    public static void interfaceUtil(String path,String data) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod("GET");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
