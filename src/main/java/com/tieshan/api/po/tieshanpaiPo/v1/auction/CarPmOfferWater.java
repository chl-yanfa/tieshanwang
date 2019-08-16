package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

public class CarPmOfferWater implements Serializable {
    private String id;

    private String mid;

    private String orderId;

    private String orderNo;

    private String auctionNo;

    private Integer bidAmount;

    private Date bidTime;

    private Integer bidWay;

    private Integer margin;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private Date ts;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public void setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo == null ? null : auctionNo.trim();
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public Integer getBidWay() {
        return bidWay;
    }

    public void setBidWay(Integer bidWay) {
        this.bidWay = bidWay;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
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

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}