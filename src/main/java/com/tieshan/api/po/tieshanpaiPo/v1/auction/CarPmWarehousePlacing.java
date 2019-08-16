package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

public class CarPmWarehousePlacing implements Serializable {
    private String id;

    private String stockId;

    private String carPmModel;

    private String licenseNum;

    private String carPmPlacing;

    private Date carPmPlacingTime;

    private String keyPlacing;

    private Date keyPlacingTime;

    private String licensePlacing;

    private Date licensePlacingTime;

    private String amount;

    private String placingReason;

    private String proposer;

    private Integer auditState;

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

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getCarPmModel() {
        return carPmModel;
    }

    public void setCarPmModel(String carPmModel) {
        this.carPmModel = carPmModel == null ? null : carPmModel.trim();
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum == null ? null : licenseNum.trim();
    }

    public String getCarPmPlacing() {
        return carPmPlacing;
    }

    public void setCarPmPlacing(String carPmPlacing) {
        this.carPmPlacing = carPmPlacing == null ? null : carPmPlacing.trim();
    }

    public Date getCarPmPlacingTime() {
        return carPmPlacingTime;
    }

    public void setCarPmPlacingTime(Date carPmPlacingTime) {
        this.carPmPlacingTime = carPmPlacingTime;
    }

    public String getKeyPlacing() {
        return keyPlacing;
    }

    public void setKeyPlacing(String keyPlacing) {
        this.keyPlacing = keyPlacing == null ? null : keyPlacing.trim();
    }

    public Date getKeyPlacingTime() {
        return keyPlacingTime;
    }

    public void setKeyPlacingTime(Date keyPlacingTime) {
        this.keyPlacingTime = keyPlacingTime;
    }

    public String getLicensePlacing() {
        return licensePlacing;
    }

    public void setLicensePlacing(String licensePlacing) {
        this.licensePlacing = licensePlacing == null ? null : licensePlacing.trim();
    }

    public Date getLicensePlacingTime() {
        return licensePlacingTime;
    }

    public void setLicensePlacingTime(Date licensePlacingTime) {
        this.licensePlacingTime = licensePlacingTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getPlacingReason() {
        return placingReason;
    }

    public void setPlacingReason(String placingReason) {
        this.placingReason = placingReason == null ? null : placingReason.trim();
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer == null ? null : proposer.trim();
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