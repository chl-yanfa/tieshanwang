package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:21
 */
@Data
public class CarScrapOrderAutopartsConfirmVO {
    private String id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "报价是否接受(0:接受,1:不接受)")
    private Integer amountIsaccept;
}
