package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:27
 */
@Data
public class CarScrapOrderQuoteVO {
    private String id;

    @ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
    private String orderType;

    @ApiModelProperty(value = "报价金额")
    private BigDecimal amount;

    @ApiModelProperty(hidden = true)
    private String operator;

    //业务员现场调整价格原因
    private String adjustWhy;

    List<CarScrapOrderAutopartsQuoteVO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsQuoteVO>();
}
