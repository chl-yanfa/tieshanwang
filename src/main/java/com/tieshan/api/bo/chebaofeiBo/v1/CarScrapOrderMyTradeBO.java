package com.tieshan.api.bo.chebaofeiBo.v1;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 16:32
 */
@Data
public class CarScrapOrderMyTradeBO {
    private Integer partTotalCount;
    private BigDecimal partTotalAmount;
    private Integer scrapCarTotalCount;
    private BigDecimal scrapCarTotalAmount;
}
