package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmAftersaleAdjustPrice implements Serializable {
    private String id;

    private String auctionId;

    private String auctionSetId;

    private String carPriceType;

    private String carPriceValue;

    private String carPriceAfter;

    private String commissionType;

    private String commissionValue;

    private String commissionAfter;

    private String remark;

    private Integer auditState;

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

    public String getCarPriceType() {
        return carPriceType;
    }

    public void setCarPriceType(String carPriceType) {
        this.carPriceType = carPriceType == null ? null : carPriceType.trim();
    }

    public String getCarPriceValue() {
        return carPriceValue;
    }

    public void setCarPriceValue(String carPriceValue) {
        this.carPriceValue = carPriceValue == null ? null : carPriceValue.trim();
    }

    public String getCarPriceAfter() {
        return carPriceAfter;
    }

    public void setCarPriceAfter(String carPriceAfter) {
        this.carPriceAfter = carPriceAfter == null ? null : carPriceAfter.trim();
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType == null ? null : commissionType.trim();
    }

    public String getCommissionValue() {
        return commissionValue;
    }

    public void setCommissionValue(String commissionValue) {
        this.commissionValue = commissionValue == null ? null : commissionValue.trim();
    }

    public String getCommissionAfter() {
        return commissionAfter;
    }

    public void setCommissionAfter(String commissionAfter) {
        this.commissionAfter = commissionAfter == null ? null : commissionAfter.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
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