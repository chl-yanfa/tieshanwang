package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarPmAftersale implements Serializable {
    private String id;

    private String auctionId;

    private String auctionSetId;

    private Date dealTime;

    private String dealHandler;

    private Date payTime;

    private Integer payState;

    private Date takeCarTime;

    private Integer takeCarState;

    private Integer deferState;

    private Integer adjustPriceState;

    private Integer backCarState;

    private Boolean isHistory;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private static final long serialVersionUID = 1L;
    
}