package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/6 10:08
 */
@Data
public class DealVO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String auctionId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal commission;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal otherPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal highestPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer auctionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dealName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dealerId;
}
