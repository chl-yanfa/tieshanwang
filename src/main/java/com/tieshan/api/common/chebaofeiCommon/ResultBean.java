package com.tieshan.api.common.chebaofeiCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 11:17
 */
@Data
@ApiModel(value = "请求响应结果bean")
public class ResultBean<T> {
    //系统错误
    public static final int FAIL=500;

    //请求成功
    public static final int SUCCESS=200;

    //未找到
    public static final int NO_PERMISSION=404;

    //校验失败
    public static final int CHECK_FAIL=400;

    //数据重复校验
    public static final int DATA_REPEAT=401;

    //响应的消息
    @ApiModelProperty(value = "响应message")
    private String msg="success";

    //响应的业务状态码
    @ApiModelProperty(value = "响应业务编码")
    private int code = SUCCESS;

    //响应的数据
    @ApiModelProperty(value = "响应业务数据")
    private T data;

    public ResultBean(T data){
        this.data=data;
    }

    public ResultBean(){
    }

    public ResultBean(int code,T data,String msg){
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public ResultBean(Throwable e){
        this.msg=e.toString();
        this.code=FAIL;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
