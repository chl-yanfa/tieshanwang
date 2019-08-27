package com.tieshan.api.util.shortMessage;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
public class SmsSender {
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAIqxxRY1gTaWiE";
    static final String accessKeySecret = "PDOnfIlQOQ21cOCXI7xPJJ2UIj6m8S";
    /*--------------------------公用模板-----------------------------*/
    //公用提示信息
    public static String PUBLICCODE="SMS_157070476";
    public static String formatmag="{ \"code\":\"%s\"}";

    public static String PUBLICEORDER="SMS_170115873";
    public static String formatmsg="{ \"order_no\":\"%s\"}";
    private static IAcsClient acsClient= null;

    static{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        acsClient = new DefaultAcsClient(profile);
    }

    public static SendSmsResponse sendSms(String mobile,String formatmag,String templeCope,String code){
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("车互联");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templeCope);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为//"{ \"code\":\"123\"}"
        request.setTemplateParam("{\"code\":\""+code+"\"}");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse=new SendSmsResponse();
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return sendSmsResponse;
    }

    //短信推送函数
    public static SendSmsResponse sendSmsByOrder(String mobile,String formatmsg,String templeCope,String order_no){
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("车互联");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templeCope);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为//"{ \"code\":\"123\"}"
        request.setTemplateParam("{\"order_no\":\""+order_no+"\"}");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse=new SendSmsResponse();
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                System.out.println("请求成功");
            }else{
                System.out.println("发送失败"+sendSmsResponse.getCode());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return sendSmsResponse;
    }
}
