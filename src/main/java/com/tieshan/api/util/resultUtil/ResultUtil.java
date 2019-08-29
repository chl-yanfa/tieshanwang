package com.tieshan.api.util.resultUtil;

public class ResultUtil {


    public static ApiResult success(Object resultmsg){
        ApiResult msg=new ApiResult();
        msg.setCode(200);
        msg.setMsg("success");
        msg.setData(resultmsg);
        return msg;
    }

    public static ApiResult error(Integer code,String resultmsg){
        ApiResult msg=new ApiResult();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }

}
