package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarPmAuctionSet implements Serializable {
    private String id;

    private String auctionId; //拍品id

    private String orderNo;  //订单号

    private BigDecimal startingPrice; //起拍价

    private BigDecimal reservePrice; //保留价

    private BigDecimal auctionCashDeposit; //参拍保证金

    private BigDecimal commission; //佣金

    private BigDecimal otherPrice; //其他费用

    private String remark; //备注

    private String orderState; //订单状态 0-未上拍;10-待竞拍;20-竞拍中;30-待处理;31-已成交;40-流拍;50-待付款;60-待提货;70-待过户;80-交易完成;90-已下架 -8：已复拍;-9：已撤拍;-10:已退货

    private String pmhId;  //拍卖会ID

    private Integer pmOrder; //拍卖会序号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date auctionStartTime; //拍卖开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date auctionEndTime;  //拍卖结束时间

    private Integer intervalTime; //间隔时间（S）

    private Integer singleTime;  //单品拍卖时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date dealTime;  //成交时间

    private String dealType; //成交类型   0. 竞价

    private String dealMid;  //成交人memberCode

    private String dealMember;  //成交人memberCode

    private BigDecimal jointPrice;  //合手价

    private BigDecimal highestPrice; //最终车款

    private Boolean isHistory;

    private Boolean isDelete; //是否删除(0:有效，1:删除)

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}