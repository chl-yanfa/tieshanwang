package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:26
 */
@Data
public class CarScrapOrderMyTradeInfoBO {
    private String id;
    private String orderType;
    private String orderTypeS;
    private BigDecimal orderAmount;
    private String carNumber;
    private Integer partsNum;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderTime;
}
