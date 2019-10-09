package com.tieshan.api.po.chebaofeiPo.v1;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:15
 */
@Data
@Table(name="car_scrap_order_autoparts")
public class CarScrapOrderAutoparts extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String orderId;     //订单id

    private Integer partsType;      //配件类型

    private String partsName;       //配件名称

    private String partsNum;       //配件编号

    private Integer partsCount;     //配件数量

    private String isDismantle;     //纯拆

    private String isCollision;     //碰撞

    private String isWear;      //自然磨损

    private String isFlood;     //水淹

    private String remark;      //配件备注

    private BigDecimal subQuote;    //分总报价金额

    private BigDecimal amount;      //配件金额

    private Integer orderAutopartsStatus;   //配件状态

    private Integer sortingState;       //分拣状态

    private Integer unableReceiveReason;    //无法接收原因

    private String qrPic;

    private String auctionId;

    private Boolean isValid=true;
}
