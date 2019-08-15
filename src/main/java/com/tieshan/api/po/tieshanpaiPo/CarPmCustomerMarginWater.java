package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmCustomerMarginWater implements Serializable {
    private String id;

    private String mid;

    private String operatorCash;

    private String memo;

    private String orderId;

    private String orderNo;

    private String auctionNo;

    private Integer operatorType;

    private String chargeOrder;

    private String chargeSource;

    private Integer payVoucherId;

    private Integer isRefund;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

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

    public String getOperatorCash() {
        return operatorCash;
    }

    public void setOperatorCash(String operatorCash) {
        this.operatorCash = operatorCash == null ? null : operatorCash.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getChargeOrder() {
        return chargeOrder;
    }

    public void setChargeOrder(String chargeOrder) {
        this.chargeOrder = chargeOrder == null ? null : chargeOrder.trim();
    }

    public String getChargeSource() {
        return chargeSource;
    }

    public void setChargeSource(String chargeSource) {
        this.chargeSource = chargeSource == null ? null : chargeSource.trim();
    }

    public Integer getPayVoucherId() {
        return payVoucherId;
    }

    public void setPayVoucherId(Integer payVoucherId) {
        this.payVoucherId = payVoucherId;
    }

    public Integer getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}