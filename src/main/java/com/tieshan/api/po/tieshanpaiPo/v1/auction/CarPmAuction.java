package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionFileVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CarPmAuction implements Serializable {

    private String id;

    private Integer auctionType; //拍品类型(0:全车配件,1:高价值配件,2:大宗物资)

    private String auctionNo; //拍品编号

    private String fullName; //拍品名称

    private String vin; //车架号

    private String vehicleBrand; //品牌

    private String vehicleType; //车型

    private String vehicleSystem; //车系

    private String licenseNumber; //车牌号

    private String lotAreas; //所在地区

    private Integer lotAreasId; //所在地区Id

    private Integer partsCount; //数量

    private String partsWeight; //重量

    private Date productionDate; //出厂日期

    private String isHasKey; //是否有钥匙 0-没有,1-有

    private String description; //描述

    private String buyRequirement; //购买要求

    private String lookContacts; //看货联系人

    private String lookContactNumber; //看货联系方式

    private String lookAddress; //看货地址

    private String lookCoordinate; //看货地址经纬度

    private Integer auctionState; //拍品状态(0:保存,1:未上拍,2:进入拍卖会,3:待发布,4:拍卖中,5:成交,6:售后,7:完结,-10:已退货)

    private Integer auditState; //参拍审核状态(0:未审核,1:审核通过,-1:审核驳回)

    private Integer setState; //参拍设置(0:待设置,1:已设置,2:待审核,3:已驳回)

    private Integer auctionAuditState; //拍品审核状态(0:未审核,1:审核通过,-1:审核驳回)

    private Integer registState; //登记状态(0:未登记,1:已登记,2:已驳回)

    private Integer procedureState; //手续状态(0:待提交,1:已提交,2:已出库,3:已驳回)

    private Integer stockState; //仓库状态(0:待入库,1:已入库,2:已出库,3:已驳回)

    private Integer aftersaleState; //售后状态(0:待付款,1:已付款,2:待提货,3:已提货,4:待过户,5:已过户,-1:延期未付款,-3:延期未提货,-5:延期未过户,-10:退货)

    private Integer abortiveState; //流拍状态(0:待处理,1:待审核,-1:驳回)

    private Boolean isDelete; //是否删除(0:有效,1:删除)

    private String createUser;

    private Date createTime; //创建时间

    private String updateUser;

    private Date updateTime; //更新时间

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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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