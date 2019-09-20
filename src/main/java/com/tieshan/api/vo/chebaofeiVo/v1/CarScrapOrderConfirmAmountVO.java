package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:20
 */
@Data
public class CarScrapOrderConfirmAmountVO {
    private String id;

    @ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
    private String orderType;

    @ApiModelProperty(value = "报价是否接受(0:接受,1:不接受)")
    private Integer amountIsaccept;

    @ApiModelProperty(hidden = true)
    private String operator;

    List<CarScrapOrderAutopartsConfirmVO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsConfirmVO>();
}
