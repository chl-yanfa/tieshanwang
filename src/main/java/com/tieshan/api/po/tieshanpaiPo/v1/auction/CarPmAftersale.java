package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId == null ? null : auctionId.trim();
    }

    public String getAuctionSetId() {
        return auctionSetId;
    }

    public void setAuctionSetId(String auctionSetId) {
        this.auctionSetId = auctionSetId == null ? null : auctionSetId.trim();
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealHandler() {
        return dealHandler;
    }

    public void setDealHandler(String dealHandler) {
        this.dealHandler = dealHandler == null ? null : dealHandler.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getTakeCarTime() {
        return takeCarTime;
    }

    public void setTakeCarTime(Date takeCarTime) {
        this.takeCarTime = takeCarTime;
    }

    public Integer getTakeCarState() {
        return takeCarState;
    }

    public void setTakeCarState(Integer takeCarState) {
        this.takeCarState = takeCarState;
    }

    public Integer getDeferState() {
        return deferState;
    }

    public void setDeferState(Integer deferState) {
        this.deferState = deferState;
    }

    public Integer getAdjustPriceState() {
        return adjustPriceState;
    }

    public void setAdjustPriceState(Integer adjustPriceState) {
        this.adjustPriceState = adjustPriceState;
    }

    public Integer getBackCarState() {
        return backCarState;
    }

    public void setBackCarState(Integer backCarState) {
        this.backCarState = backCarState;
    }

    public Boolean getIsHistory() {
        return isHistory;
    }

    public void setIsHistory(Boolean isHistory) {
        this.isHistory = isHistory;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}