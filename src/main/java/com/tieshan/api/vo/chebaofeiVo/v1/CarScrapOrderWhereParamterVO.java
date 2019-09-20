package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:04
 */
@Data
public class CarScrapOrderWhereParamterVO {
    private String orderStatus;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "车牌号")
    private String carNumber;
    @ApiModelProperty(value = "车架号")
    private String carFrameNumber;
    @ApiModelProperty(value = "车型")
    private String carModelNumberName;
    @ApiModelProperty(value = "联系人")
    private String takeCarContacts;
    @ApiModelProperty(value = "联系电话")
    private String takeCarContactNumber;
    @ApiModelProperty(value = "订单委托人")
    private String clientId;
    @ApiModelProperty(value = "订单代办人")
    private String agentUserid;
}
