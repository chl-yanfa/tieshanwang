package com.tieshan.api.util.jyInterfaceUtil;

import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;

import javax.servlet.http.HttpServletRequest;
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
