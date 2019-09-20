package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:28
 */
@Data
public class CarScrapOrderAutopartsQuoteVO {
    private String id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "报价金额")
    private BigDecimal amount;
}
