package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 10:57
 */
@Data
public class CarScrapOrderAutopartsDetailBO extends CarScrapOrderAutopartsBO {
    //订单编号
    private String orderNo;

    @ApiModelProperty(value = "报案号")
    private String reportNo;

    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    @ApiModelProperty(value = "车架号")
    private String carFrameNumber;

    private String carModelNumberName;

    private String custormName;
    //业务员
    private String saleName;

    @ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

    @ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;

    @ApiModelProperty(value = "取车时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date takeCarTime;

    @ApiModelProperty(value = "取车地址")
    private String takeCarAddress;

    @ApiModelProperty(value = "配件类型名称")
    private String partsTypeName;

    @ApiModelProperty(value = "派单备注")
    private String   	dispatchRemark;

    @ApiModelProperty(value = "接收备注")
    private String  receiveRemark;

    //接受配件时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date acceptTime;

    @ApiModelProperty(value = "入库备注")
    private String   storageRemark;

    @ApiModelProperty(value = "入库时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date storageTime;

    @ApiModelProperty(value = "出库备注")
    private String outageRemark;

    //下单时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderTime;

    //配件出库时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date outageTime;

    //配件返款时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date repaymentTime;

    @ApiModelProperty(value = "收款人姓名")
    private String payeeName;

    @ApiModelProperty(value = "银行账户")
    private String bankAccount;

    @ApiModelProperty(value = "开户行")
    private String openingBank;

    @ApiModelProperty(value = "无法接收原因")
    private String unableReceiveReason_str;
}
