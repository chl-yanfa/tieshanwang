package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarPmFinancePay implements Serializable {
    private String id;

    private String auctionId;

    private String auctionSetId;

    private String type;

    private String mid;

    private String payHandle;

    private String payBank;

    private String payOpeningBank;

    private String payAccount;

    private BigDecimal payMoney;

    private String payContactPhone;

    private BigDecimal highestPrice;

    private BigDecimal commission;

    private BigDecimal otherPrice;

    private Integer payVoucherId;

    private String remark;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getPayHandle() {
        return payHandle;
    }

    public void setPayHandle(String payHandle) {
        this.payHandle = payHandle == null ? null : payHandle.trim();
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank == null ? null : payBank.trim();
    }

    public String getPayOpeningBank() {
        return payOpeningBank;
    }

    public void setPayOpeningBank(String payOpeningBank) {
        this.payOpeningBank = payOpeningBank == null ? null : payOpeningBank.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayContactPhone() {
        return payContactPhone;
    }

    public void setPayContactPhone(String payContactPhone) {
        this.payContactPhone = payContactPhone == null ? null : payContactPhone.trim();
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Integer getPayVoucherId() {
        return payVoucherId;
    }

    public void setPayVoucherId(Integer payVoucherId) {
        this.payVoucherId = payVoucherId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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