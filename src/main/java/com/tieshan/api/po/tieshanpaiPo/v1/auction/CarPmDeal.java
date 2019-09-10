package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/6 10:35
 */
@Data
public class CarPmDeal {
    private String id;
    private String orderNo;
    private String auctionId;
    private BigDecimal payPrice;
    private String auctionName;
    private String dealTime;
    private String dealerId;
    private Integer dealWay;
    private Integer auctionType;
    private String dealCn;
    private String imgPath;
}
