package com.tieshan.api.util.jyInterfaceUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jySelectVin {
    @Autowired
    private JyModelService jyModelService;
    //解析json
    public  void vinjson(String json,String vin){
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
                    System.out.println("该车型存在，为车型添加vin:"+vin+"*精友id*"+vehicleId);
                    ChlCarModel chlCarModel1=new ChlCarModel();
                    chlCarModel1.setAliasId(vehicleId);
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
    public static String  jyselectVins(String vin){
            //不存在，调用第三方接口
            String host = "http://www.easyepc123.com";
            String path = "/api/";
            String apiCode = "111002";
            String url = host + path + apiCode;
            //请求头信息
            Map<String, String> head = new HashMap<String, String>();
            head.put("username", "18911625855");
            head.put("password", "5a324e308588b12abbb28c2702248958a808c033");
            //请求参数
            Map<String, String> body = new HashMap<String, String>();
            /*body.put("vinCode", "LHGCP260498017030");*/
            body.put("vinCode", vin);
            try {
                String returnData = getData(url, head, body);
                System.out.println(returnData);
                return returnData;
            } catch (Exception e) {
                System.err.println("接口"+apiCode+"调用出现异常,信息为："+e.getMessage());
                return "接口"+apiCode+"调用出现异常,信息为："+e.getMessage();
            }

    }

    /**
     * 获取数据入口
     *
     * @param requestUrl 请求地址
     * @param  head 请求头信息
     * @param  body 请求参数
     * @return
     */
    public static String getData(String requestUrl, Map<String, String> head, Map<String, String> body) {
        String requestParams = getRequestParams(head, body);
        String data = "";
        if (!isEmpty(requestParams)) {
            System.out.println("请求URL---requestUrl:" + requestUrl);
            System.out.println("请求参数---requestParams:" + requestParams);
            data = sendPostRequest(requestUrl, requestParams);
        }
        return data;
    }

    /**
     * 请求参数分装
     *
     * @param  head 请求头信息
     * @param  body 请求参数
     * @return
     */
    public static String getRequestParams(Map<String, String> head, Map<String, String> body) {
        JSONObject _head = new JSONObject();
        JSONObject _body = new JSONObject();
        _head.put("username", head.get("username"));//账号
        _head.put("password", head.get("password"));//密码

        for (String key : body.keySet()) {
            _body.put(key, body.get(key));
        }

        _head.put("data", _body);
        return _head.toString();
    }

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0 || s.trim().length() == 0;
    }

    /**
     * HTTP_POST 请求
     *
     * @param requestUrl 请求地址
     * @param jsonStr    请求参数JSON字符创
     * @return
     */
    public static String sendPostRequest(String requestUrl, String jsonStr) {
        String result = "";
        if (isEmpty(requestUrl)) {
            System.out.println("参数requestUrl(请求地址)为空!");
            return "请求地址为空!";
        }
        if (isEmpty(jsonStr)) {
            System.out.println("参数jsonStr(请求参数)为空!");
            return "请求参数为空!";
        }
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");//提交模式
            //是否允许输入输出
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //是否允许缓存
            conn.setUseCaches(false);
            //设置超时时间（毫秒）
            conn.setConnectTimeout(30000);
            //设置请求头信息
            conn.setRequestProperty("Content-Type", "application/json");
            //连接地址
            conn.connect();
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            //发送参数
            writer.write(jsonStr);
            //清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
            writer.flush();
            //关闭输出流
            writer.close();
            //读取返回结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //读取返回结果
            String lines = reader.readLine();
            //关闭流
            reader.close();
            JSONObject jsonObject = JSONObject.parseObject(lines);
            result = jsonObject.toString();
        } catch (MalformedURLException e) {
            System.out.println("请求失败,信息为：" + e.getMessage());
        } catch (IOException e) {
            System.out.println("请求失败,信息为：" + e.getMessage());
        }
        return result;
    }
}
