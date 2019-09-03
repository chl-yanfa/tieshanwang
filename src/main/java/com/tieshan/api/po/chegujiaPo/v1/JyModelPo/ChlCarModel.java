package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ChlCarModel implements Serializable {
    private Integer id;

    private String vinCode;

    private String modelName;

    private Integer brandId;

    private Integer seriesId;

    private Integer subSeriesId;

    private String displacement;

    private String modelYear;

    private String driveType;

    private String engine;

    private String bodyStructure;

    private BigDecimal purchasePrice;

    private String rangeOfService;

    private String rangeOfPickup;

    private Integer status;

    private Date createdTime;

    private String createdBy;

    private String updatedBy;

    private Date updatedTime;

    private Integer deleteState;

    private String partNum;

    private String called;

    private String carAlias;

    private String carYear;

    private String dynamic;

    private String drives;

    private String seatNum;

    private String emissionStandard;

    private String configureLevel;

    private String cylinder;

    private String engineValveNum;

    private String transmission;

    private String wheelbase;

    private String cardoornum;

    private String supply;

    private String inlet;

    private String power;

    private String remarks;

    private Integer carTypeId;

    private String aliasId;

    private String tiema;

    private String json;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode == null ? null : vinCode.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getSubSeriesId() {
        return subSeriesId;
    }

    public void setSubSeriesId(Integer subSeriesId) {
        this.subSeriesId = subSeriesId;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement == null ? null : displacement.trim();
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear == null ? null : modelYear.trim();
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType == null ? null : driveType.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getBodyStructure() {
        return bodyStructure;
    }

    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure == null ? null : bodyStructure.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRangeOfService() {
        return rangeOfService;
    }

    public void setRangeOfService(String rangeOfService) {
        this.rangeOfService = rangeOfService == null ? null : rangeOfService.trim();
    }

    public String getRangeOfPickup() {
        return rangeOfPickup;
    }

    public void setRangeOfPickup(String rangeOfPickup) {
        this.rangeOfPickup = rangeOfPickup == null ? null : rangeOfPickup.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum == null ? null : partNum.trim();
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called == null ? null : called.trim();
    }

    public String getCarAlias() {
        return carAlias;
    }

    public void setCarAlias(String carAlias) {
        this.carAlias = carAlias == null ? null : carAlias.trim();
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear == null ? null : carYear.trim();
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic == null ? null : dynamic.trim();
    }

    public String getDrives() {
        return drives;
    }

    public void setDrives(String drives) {
        this.drives = drives == null ? null : drives.trim();
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum == null ? null : seatNum.trim();
    }

    public String getEmissionStandard() {
        return emissionStandard;
    }

    public void setEmissionStandard(String emissionStandard) {
        this.emissionStandard = emissionStandard == null ? null : emissionStandard.trim();
    }

    public String getConfigureLevel() {
        return configureLevel;
    }

    public void setConfigureLevel(String configureLevel) {
        this.configureLevel = configureLevel == null ? null : configureLevel.trim();
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder == null ? null : cylinder.trim();
    }

    public String getEngineValveNum() {
        return engineValveNum;
    }

    public void setEngineValveNum(String engineValveNum) {
        this.engineValveNum = engineValveNum == null ? null : engineValveNum.trim();
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission == null ? null : transmission.trim();
    }

    public String getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase == null ? null : wheelbase.trim();
    }

    public String getCardoornum() {
        return cardoornum;
    }

    public void setCardoornum(String cardoornum) {
        this.cardoornum = cardoornum == null ? null : cardoornum.trim();
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply == null ? null : supply.trim();
    }

    public String getInlet() {
        return inlet;
    }

    public void setInlet(String inlet) {
        this.inlet = inlet == null ? null : inlet.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }

    public String getAliasId() {
        return aliasId;
    }

    public void setAliasId(String aliasId) {
        this.aliasId = aliasId == null ? null : aliasId.trim();
    }

    public String getTiema() {
        return tiema;
    }

    public void setTiema(String tiema) {
        this.tiema = tiema == null ? null : tiema.trim();
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }
}