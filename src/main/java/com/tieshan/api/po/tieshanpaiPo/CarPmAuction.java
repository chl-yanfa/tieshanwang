package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmAuction implements Serializable {
    private String id;

    private Integer auctionType;

    private String auctionNo;

    private String fullName;

    private String vin;

    private String vehicleBrand;

    private String vehicleType;

    private String vehicleSystem;

    private String licenseNumber;

    private String lotAreas;

    private Integer lotAreasId;

    private Integer partsCount;

    private String partsWeight;

    private Date productionDate;

    private String isHasKey;

    private String description;

    private String buyRequirement;

    private String lookContacts;

    private String lookContactNumber;

    private String lookAddress;

    private String lookCoordinate;

    private Integer auctionState;

    private Integer auditState;

    private Integer setState;

    private Integer auctionAuditState;

    private Integer registState;

    private Integer procedureState;

    private Integer stockState;

    private Integer aftersaleState;

    private Integer abortiveState;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Date ts;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(Integer auctionType) {
        this.auctionType = auctionType;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public void setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo == null ? null : auctionNo.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand == null ? null : vehicleBrand.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getVehicleSystem() {
        return vehicleSystem;
    }

    public void setVehicleSystem(String vehicleSystem) {
        this.vehicleSystem = vehicleSystem == null ? null : vehicleSystem.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    public String getLotAreas() {
        return lotAreas;
    }

    public void setLotAreas(String lotAreas) {
        this.lotAreas = lotAreas == null ? null : lotAreas.trim();
    }

    public Integer getLotAreasId() {
        return lotAreasId;
    }

    public void setLotAreasId(Integer lotAreasId) {
        this.lotAreasId = lotAreasId;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }

    public String getPartsWeight() {
        return partsWeight;
    }

    public void setPartsWeight(String partsWeight) {
        this.partsWeight = partsWeight == null ? null : partsWeight.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getIsHasKey() {
        return isHasKey;
    }

    public void setIsHasKey(String isHasKey) {
        this.isHasKey = isHasKey == null ? null : isHasKey.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getBuyRequirement() {
        return buyRequirement;
    }

    public void setBuyRequirement(String buyRequirement) {
        this.buyRequirement = buyRequirement == null ? null : buyRequirement.trim();
    }

    public String getLookContacts() {
        return lookContacts;
    }

    public void setLookContacts(String lookContacts) {
        this.lookContacts = lookContacts == null ? null : lookContacts.trim();
    }

    public String getLookContactNumber() {
        return lookContactNumber;
    }

    public void setLookContactNumber(String lookContactNumber) {
        this.lookContactNumber = lookContactNumber == null ? null : lookContactNumber.trim();
    }

    public String getLookAddress() {
        return lookAddress;
    }

    public void setLookAddress(String lookAddress) {
        this.lookAddress = lookAddress == null ? null : lookAddress.trim();
    }

    public String getLookCoordinate() {
        return lookCoordinate;
    }

    public void setLookCoordinate(String lookCoordinate) {
        this.lookCoordinate = lookCoordinate == null ? null : lookCoordinate.trim();
    }

    public Integer getAuctionState() {
        return auctionState;
    }

    public void setAuctionState(Integer auctionState) {
        this.auctionState = auctionState;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Integer getSetState() {
        return setState;
    }

    public void setSetState(Integer setState) {
        this.setState = setState;
    }

    public Integer getAuctionAuditState() {
        return auctionAuditState;
    }

    public void setAuctionAuditState(Integer auctionAuditState) {
        this.auctionAuditState = auctionAuditState;
    }

    public Integer getRegistState() {
        return registState;
    }

    public void setRegistState(Integer registState) {
        this.registState = registState;
    }

    public Integer getProcedureState() {
        return procedureState;
    }

    public void setProcedureState(Integer procedureState) {
        this.procedureState = procedureState;
    }

    public Integer getStockState() {
        return stockState;
    }

    public void setStockState(Integer stockState) {
        this.stockState = stockState;
    }

    public Integer getAftersaleState() {
        return aftersaleState;
    }

    public void setAftersaleState(Integer aftersaleState) {
        this.aftersaleState = aftersaleState;
    }

    public Integer getAbortiveState() {
        return abortiveState;
    }

    public void setAbortiveState(Integer abortiveState) {
        this.abortiveState = abortiveState;
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

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}