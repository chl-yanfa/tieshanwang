package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarPmWarehouse implements Serializable {
    private String id;

    private String auctionId;

    private String carCard;

    private String ccProvince;

    private String ccProvinceId;

    private String ccCity;

    private String ccCityId;

    private String ccArea;

    private String ccAreaId;

    private String carCardAddress;

    private String key;

    private String spareKey;

    private String kProvince;

    private String kProvinceId;

    private String kCity;

    private String kCityId;

    private String kArea;

    private String kAreaId;

    private String keyAddress;

    private String keyRemark;

    private String sProvince;

    private String sProvinceId;

    private String sCity;

    private String sCityId;

    private String sArea;

    private String sAreaId;

    private String storeAddress;

    private String storeSpace;

    private Date storeTime;

    private BigDecimal trailerCost;

    private String trailerCostPay;

    private Integer voucherId;

    private String trailerPhone;

    private String originProvince;

    private String originProvinceId;

    private String originCity;

    private String originCityId;

    private String originAddress;

    private String distance;

    private String destinationProvince;

    private String destinationProvinceId;

    private String destinationCity;

    private String destinationCityId;

    private String destinationAddress;

    private String carStatus;

    private String gearboxType;

    private String carMileage;

    private Integer vinIsDamage;

    private String engine;

    private String gearbox;

    private String waterbox;

    private String condenser;

    private String battery;

    private String airconditionPump;

    private String motor;

    private String powerSteeringPump;

    private String dynamo;

    private String absPump;

    private String threeWayCatalyticConverter;

    private String exhaustPipe;

    private String compressor;

    private String rightFrontHeadlight;

    private String rightMirror;

    private String rightFrontDoor;

    private String rightRearDoor;

    private String rightRearTailLight;

    private String leftFrontHeadlight;

    private String leftMirror;

    private String leftFrontDoor;

    private String leftRearDoor;

    private String leftRearTailLight;

    private String trunk;

    private String spareTire;

    private String vehicleTools;

    private String triangleIndicator;

    private String trim;

    private String dashboard;

    private String seat;

    private String dvdCd;

    private String voicebox;

    private String engineComputer;

    private String gearboxComputer;

    private String drivingComputer;

    private String burglarComputer;

    private String gasbagComputer;

    private String entertainmentComputer;

    private String troubleDescription;

    private String maintenanceManual;

    private String operatingManual;

    private Integer tyreNum;

    private String dismantling;

    private String dismantlingPart;

    private String twoAccidents;

    private String twoAccidentsRemark;

    private String refit;

    private String refitPart;

    private String checkPart;

    private String noCheckPark;

    private String receivingPart;

    private String remark;

    private String salesman;

    private Integer auditState;

    private Integer isWarehouse;

    private Integer isPrint;

    private Date outStockTime;

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

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId == null ? null : auctionId.trim();
    }

    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard == null ? null : carCard.trim();
    }

    public String getCcProvince() {
        return ccProvince;
    }

    public void setCcProvince(String ccProvince) {
        this.ccProvince = ccProvince == null ? null : ccProvince.trim();
    }

    public String getCcProvinceId() {
        return ccProvinceId;
    }

    public void setCcProvinceId(String ccProvinceId) {
        this.ccProvinceId = ccProvinceId == null ? null : ccProvinceId.trim();
    }

    public String getCcCity() {
        return ccCity;
    }

    public void setCcCity(String ccCity) {
        this.ccCity = ccCity == null ? null : ccCity.trim();
    }

    public String getCcCityId() {
        return ccCityId;
    }

    public void setCcCityId(String ccCityId) {
        this.ccCityId = ccCityId == null ? null : ccCityId.trim();
    }

    public String getCcArea() {
        return ccArea;
    }

    public void setCcArea(String ccArea) {
        this.ccArea = ccArea == null ? null : ccArea.trim();
    }

    public String getCcAreaId() {
        return ccAreaId;
    }

    public void setCcAreaId(String ccAreaId) {
        this.ccAreaId = ccAreaId == null ? null : ccAreaId.trim();
    }

    public String getCarCardAddress() {
        return carCardAddress;
    }

    public void setCarCardAddress(String carCardAddress) {
        this.carCardAddress = carCardAddress == null ? null : carCardAddress.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getSpareKey() {
        return spareKey;
    }

    public void setSpareKey(String spareKey) {
        this.spareKey = spareKey == null ? null : spareKey.trim();
    }

    public String getkProvince() {
        return kProvince;
    }

    public void setkProvince(String kProvince) {
        this.kProvince = kProvince == null ? null : kProvince.trim();
    }

    public String getkProvinceId() {
        return kProvinceId;
    }

    public void setkProvinceId(String kProvinceId) {
        this.kProvinceId = kProvinceId == null ? null : kProvinceId.trim();
    }

    public String getkCity() {
        return kCity;
    }

    public void setkCity(String kCity) {
        this.kCity = kCity == null ? null : kCity.trim();
    }

    public String getkCityId() {
        return kCityId;
    }

    public void setkCityId(String kCityId) {
        this.kCityId = kCityId == null ? null : kCityId.trim();
    }

    public String getkArea() {
        return kArea;
    }

    public void setkArea(String kArea) {
        this.kArea = kArea == null ? null : kArea.trim();
    }

    public String getkAreaId() {
        return kAreaId;
    }

    public void setkAreaId(String kAreaId) {
        this.kAreaId = kAreaId == null ? null : kAreaId.trim();
    }

    public String getKeyAddress() {
        return keyAddress;
    }

    public void setKeyAddress(String keyAddress) {
        this.keyAddress = keyAddress == null ? null : keyAddress.trim();
    }

    public String getKeyRemark() {
        return keyRemark;
    }

    public void setKeyRemark(String keyRemark) {
        this.keyRemark = keyRemark == null ? null : keyRemark.trim();
    }

    public String getsProvince() {
        return sProvince;
    }

    public void setsProvince(String sProvince) {
        this.sProvince = sProvince == null ? null : sProvince.trim();
    }

    public String getsProvinceId() {
        return sProvinceId;
    }

    public void setsProvinceId(String sProvinceId) {
        this.sProvinceId = sProvinceId == null ? null : sProvinceId.trim();
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity == null ? null : sCity.trim();
    }

    public String getsCityId() {
        return sCityId;
    }

    public void setsCityId(String sCityId) {
        this.sCityId = sCityId == null ? null : sCityId.trim();
    }

    public String getsArea() {
        return sArea;
    }

    public void setsArea(String sArea) {
        this.sArea = sArea == null ? null : sArea.trim();
    }

    public String getsAreaId() {
        return sAreaId;
    }

    public void setsAreaId(String sAreaId) {
        this.sAreaId = sAreaId == null ? null : sAreaId.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public String getStoreSpace() {
        return storeSpace;
    }

    public void setStoreSpace(String storeSpace) {
        this.storeSpace = storeSpace == null ? null : storeSpace.trim();
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public BigDecimal getTrailerCost() {
        return trailerCost;
    }

    public void setTrailerCost(BigDecimal trailerCost) {
        this.trailerCost = trailerCost;
    }

    public String getTrailerCostPay() {
        return trailerCostPay;
    }

    public void setTrailerCostPay(String trailerCostPay) {
        this.trailerCostPay = trailerCostPay == null ? null : trailerCostPay.trim();
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getTrailerPhone() {
        return trailerPhone;
    }

    public void setTrailerPhone(String trailerPhone) {
        this.trailerPhone = trailerPhone == null ? null : trailerPhone.trim();
    }

    public String getOriginProvince() {
        return originProvince;
    }

    public void setOriginProvince(String originProvince) {
        this.originProvince = originProvince == null ? null : originProvince.trim();
    }

    public String getOriginProvinceId() {
        return originProvinceId;
    }

    public void setOriginProvinceId(String originProvinceId) {
        this.originProvinceId = originProvinceId == null ? null : originProvinceId.trim();
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity == null ? null : originCity.trim();
    }

    public String getOriginCityId() {
        return originCityId;
    }

    public void setOriginCityId(String originCityId) {
        this.originCityId = originCityId == null ? null : originCityId.trim();
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress == null ? null : originAddress.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getDestinationProvince() {
        return destinationProvince;
    }

    public void setDestinationProvince(String destinationProvince) {
        this.destinationProvince = destinationProvince == null ? null : destinationProvince.trim();
    }

    public String getDestinationProvinceId() {
        return destinationProvinceId;
    }

    public void setDestinationProvinceId(String destinationProvinceId) {
        this.destinationProvinceId = destinationProvinceId == null ? null : destinationProvinceId.trim();
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity == null ? null : destinationCity.trim();
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId == null ? null : destinationCityId.trim();
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress == null ? null : destinationAddress.trim();
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus == null ? null : carStatus.trim();
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType == null ? null : gearboxType.trim();
    }

    public String getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(String carMileage) {
        this.carMileage = carMileage == null ? null : carMileage.trim();
    }

    public Integer getVinIsDamage() {
        return vinIsDamage;
    }

    public void setVinIsDamage(Integer vinIsDamage) {
        this.vinIsDamage = vinIsDamage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox == null ? null : gearbox.trim();
    }

    public String getWaterbox() {
        return waterbox;
    }

    public void setWaterbox(String waterbox) {
        this.waterbox = waterbox == null ? null : waterbox.trim();
    }

    public String getCondenser() {
        return condenser;
    }

    public void setCondenser(String condenser) {
        this.condenser = condenser == null ? null : condenser.trim();
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery == null ? null : battery.trim();
    }

    public String getAirconditionPump() {
        return airconditionPump;
    }

    public void setAirconditionPump(String airconditionPump) {
        this.airconditionPump = airconditionPump == null ? null : airconditionPump.trim();
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor == null ? null : motor.trim();
    }

    public String getPowerSteeringPump() {
        return powerSteeringPump;
    }

    public void setPowerSteeringPump(String powerSteeringPump) {
        this.powerSteeringPump = powerSteeringPump == null ? null : powerSteeringPump.trim();
    }

    public String getDynamo() {
        return dynamo;
    }

    public void setDynamo(String dynamo) {
        this.dynamo = dynamo == null ? null : dynamo.trim();
    }

    public String getAbsPump() {
        return absPump;
    }

    public void setAbsPump(String absPump) {
        this.absPump = absPump == null ? null : absPump.trim();
    }

    public String getThreeWayCatalyticConverter() {
        return threeWayCatalyticConverter;
    }

    public void setThreeWayCatalyticConverter(String threeWayCatalyticConverter) {
        this.threeWayCatalyticConverter = threeWayCatalyticConverter == null ? null : threeWayCatalyticConverter.trim();
    }

    public String getExhaustPipe() {
        return exhaustPipe;
    }

    public void setExhaustPipe(String exhaustPipe) {
        this.exhaustPipe = exhaustPipe == null ? null : exhaustPipe.trim();
    }

    public String getCompressor() {
        return compressor;
    }

    public void setCompressor(String compressor) {
        this.compressor = compressor == null ? null : compressor.trim();
    }

    public String getRightFrontHeadlight() {
        return rightFrontHeadlight;
    }

    public void setRightFrontHeadlight(String rightFrontHeadlight) {
        this.rightFrontHeadlight = rightFrontHeadlight == null ? null : rightFrontHeadlight.trim();
    }

    public String getRightMirror() {
        return rightMirror;
    }

    public void setRightMirror(String rightMirror) {
        this.rightMirror = rightMirror == null ? null : rightMirror.trim();
    }

    public String getRightFrontDoor() {
        return rightFrontDoor;
    }

    public void setRightFrontDoor(String rightFrontDoor) {
        this.rightFrontDoor = rightFrontDoor == null ? null : rightFrontDoor.trim();
    }

    public String getRightRearDoor() {
        return rightRearDoor;
    }

    public void setRightRearDoor(String rightRearDoor) {
        this.rightRearDoor = rightRearDoor == null ? null : rightRearDoor.trim();
    }

    public String getRightRearTailLight() {
        return rightRearTailLight;
    }

    public void setRightRearTailLight(String rightRearTailLight) {
        this.rightRearTailLight = rightRearTailLight == null ? null : rightRearTailLight.trim();
    }

    public String getLeftFrontHeadlight() {
        return leftFrontHeadlight;
    }

    public void setLeftFrontHeadlight(String leftFrontHeadlight) {
        this.leftFrontHeadlight = leftFrontHeadlight == null ? null : leftFrontHeadlight.trim();
    }

    public String getLeftMirror() {
        return leftMirror;
    }

    public void setLeftMirror(String leftMirror) {
        this.leftMirror = leftMirror == null ? null : leftMirror.trim();
    }

    public String getLeftFrontDoor() {
        return leftFrontDoor;
    }

    public void setLeftFrontDoor(String leftFrontDoor) {
        this.leftFrontDoor = leftFrontDoor == null ? null : leftFrontDoor.trim();
    }

    public String getLeftRearDoor() {
        return leftRearDoor;
    }

    public void setLeftRearDoor(String leftRearDoor) {
        this.leftRearDoor = leftRearDoor == null ? null : leftRearDoor.trim();
    }

    public String getLeftRearTailLight() {
        return leftRearTailLight;
    }

    public void setLeftRearTailLight(String leftRearTailLight) {
        this.leftRearTailLight = leftRearTailLight == null ? null : leftRearTailLight.trim();
    }

    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk == null ? null : trunk.trim();
    }

    public String getSpareTire() {
        return spareTire;
    }

    public void setSpareTire(String spareTire) {
        this.spareTire = spareTire == null ? null : spareTire.trim();
    }

    public String getVehicleTools() {
        return vehicleTools;
    }

    public void setVehicleTools(String vehicleTools) {
        this.vehicleTools = vehicleTools == null ? null : vehicleTools.trim();
    }

    public String getTriangleIndicator() {
        return triangleIndicator;
    }

    public void setTriangleIndicator(String triangleIndicator) {
        this.triangleIndicator = triangleIndicator == null ? null : triangleIndicator.trim();
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim == null ? null : trim.trim();
    }

    public String getDashboard() {
        return dashboard;
    }

    public void setDashboard(String dashboard) {
        this.dashboard = dashboard == null ? null : dashboard.trim();
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat == null ? null : seat.trim();
    }

    public String getDvdCd() {
        return dvdCd;
    }

    public void setDvdCd(String dvdCd) {
        this.dvdCd = dvdCd == null ? null : dvdCd.trim();
    }

    public String getVoicebox() {
        return voicebox;
    }

    public void setVoicebox(String voicebox) {
        this.voicebox = voicebox == null ? null : voicebox.trim();
    }

    public String getEngineComputer() {
        return engineComputer;
    }

    public void setEngineComputer(String engineComputer) {
        this.engineComputer = engineComputer == null ? null : engineComputer.trim();
    }

    public String getGearboxComputer() {
        return gearboxComputer;
    }

    public void setGearboxComputer(String gearboxComputer) {
        this.gearboxComputer = gearboxComputer == null ? null : gearboxComputer.trim();
    }

    public String getDrivingComputer() {
        return drivingComputer;
    }

    public void setDrivingComputer(String drivingComputer) {
        this.drivingComputer = drivingComputer == null ? null : drivingComputer.trim();
    }

    public String getBurglarComputer() {
        return burglarComputer;
    }

    public void setBurglarComputer(String burglarComputer) {
        this.burglarComputer = burglarComputer == null ? null : burglarComputer.trim();
    }

    public String getGasbagComputer() {
        return gasbagComputer;
    }

    public void setGasbagComputer(String gasbagComputer) {
        this.gasbagComputer = gasbagComputer == null ? null : gasbagComputer.trim();
    }

    public String getEntertainmentComputer() {
        return entertainmentComputer;
    }

    public void setEntertainmentComputer(String entertainmentComputer) {
        this.entertainmentComputer = entertainmentComputer == null ? null : entertainmentComputer.trim();
    }

    public String getTroubleDescription() {
        return troubleDescription;
    }

    public void setTroubleDescription(String troubleDescription) {
        this.troubleDescription = troubleDescription == null ? null : troubleDescription.trim();
    }

    public String getMaintenanceManual() {
        return maintenanceManual;
    }

    public void setMaintenanceManual(String maintenanceManual) {
        this.maintenanceManual = maintenanceManual == null ? null : maintenanceManual.trim();
    }

    public String getOperatingManual() {
        return operatingManual;
    }

    public void setOperatingManual(String operatingManual) {
        this.operatingManual = operatingManual == null ? null : operatingManual.trim();
    }

    public Integer getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(Integer tyreNum) {
        this.tyreNum = tyreNum;
    }

    public String getDismantling() {
        return dismantling;
    }

    public void setDismantling(String dismantling) {
        this.dismantling = dismantling == null ? null : dismantling.trim();
    }

    public String getDismantlingPart() {
        return dismantlingPart;
    }

    public void setDismantlingPart(String dismantlingPart) {
        this.dismantlingPart = dismantlingPart == null ? null : dismantlingPart.trim();
    }

    public String getTwoAccidents() {
        return twoAccidents;
    }

    public void setTwoAccidents(String twoAccidents) {
        this.twoAccidents = twoAccidents == null ? null : twoAccidents.trim();
    }

    public String getTwoAccidentsRemark() {
        return twoAccidentsRemark;
    }

    public void setTwoAccidentsRemark(String twoAccidentsRemark) {
        this.twoAccidentsRemark = twoAccidentsRemark == null ? null : twoAccidentsRemark.trim();
    }

    public String getRefit() {
        return refit;
    }

    public void setRefit(String refit) {
        this.refit = refit == null ? null : refit.trim();
    }

    public String getRefitPart() {
        return refitPart;
    }

    public void setRefitPart(String refitPart) {
        this.refitPart = refitPart == null ? null : refitPart.trim();
    }

    public String getCheckPart() {
        return checkPart;
    }

    public void setCheckPart(String checkPart) {
        this.checkPart = checkPart == null ? null : checkPart.trim();
    }

    public String getNoCheckPark() {
        return noCheckPark;
    }

    public void setNoCheckPark(String noCheckPark) {
        this.noCheckPark = noCheckPark == null ? null : noCheckPark.trim();
    }

    public String getReceivingPart() {
        return receivingPart;
    }

    public void setReceivingPart(String receivingPart) {
        this.receivingPart = receivingPart == null ? null : receivingPart.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Integer getIsWarehouse() {
        return isWarehouse;
    }

    public void setIsWarehouse(Integer isWarehouse) {
        this.isWarehouse = isWarehouse;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public Date getOutStockTime() {
        return outStockTime;
    }

    public void setOutStockTime(Date outStockTime) {
        this.outStockTime = outStockTime;
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