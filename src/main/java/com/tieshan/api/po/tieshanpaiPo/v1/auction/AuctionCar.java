package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 13:55
 */
public class AuctionCar {
    private String auctionId;			//拍品id
    private String auctionSetId;		//参拍id
    private String auctionNo;			//拍品编号
    private String fullName;			//拍品名称
    private String fullType;            //拍品类型
    private String singleTime;          //要添加的秒数
    private String lotAreas;
    private String vehicleBrand;		//品牌
    private String vehicleType;			//车型
    private String vehicleSystem;		//车系
    private String licenseNumber;		//车牌号
    private String pmhId;				//拍卖会ID
    private Integer pmOrder;			//拍卖序号
    private String orderStateS;			//拍品状态
    private String orderState;			//拍品状态
    private String dealMid;				//买受人memberCode
    private String dealMember;			//买受人
    private BigDecimal startingPrice=BigDecimal.ZERO;		//起拍价
    private BigDecimal curPrice=BigDecimal.ZERO;			//当前价
    private BigDecimal reservePrice=BigDecimal.ZERO;		//保留价
    private BigDecimal auctionCashDeposit=BigDecimal.ZERO;	//参拍保证金
    private String imgPath;				//列表头像
    private Integer auctionTypeFlag;	//拍品类型
    private String vin;					//车架号
    private String parkAddress;			//停放地址
    private String phone;				//手机号
    private String idCard;			//身份证号码
    private BigDecimal jointPrice=BigDecimal.ZERO;				//合手价
    private BigDecimal highestPrice=BigDecimal.ZERO;		//最终成交价
    private BigDecimal otherPrice=BigDecimal.ZERO;			//最终其他费用
    private BigDecimal commission=BigDecimal.ZERO;	//最终佣金
    private BigDecimal totalPrice=BigDecimal.ZERO;			//总计
    private String timeCount;   //单个拍品开始时间
    private String timeEndCount; //单个拍品结束时间
    private String auctionStartTime;  //拍卖会开始时间
    private String oneSecond; //距离单个拍品开始的秒数
    public String getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }
    public String getAuctionSetId() {
        return auctionSetId;
    }
    public void setAuctionSetId(String auctionSetId) {
        this.auctionSetId = auctionSetId;
    }
    public String getAuctionNo() {
        return auctionNo;
    }
    public void setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getLotAreas() {
        return lotAreas;
    }
    public void setLotAreas(String lotAreas) {
        this.lotAreas = lotAreas;
    }
    public String getVehicleBrand() {
        return vehicleBrand;
    }
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleSystem() {
        return vehicleSystem;
    }
    public void setVehicleSystem(String vehicleSystem) {
        this.vehicleSystem = vehicleSystem;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public String getPmhId() {
        return pmhId;
    }
    public void setPmhId(String pmhId) {
        this.pmhId = pmhId;
    }
    public Integer getPmOrder() {
        return pmOrder;
    }
    public void setPmOrder(Integer pmOrder) {
        this.pmOrder = pmOrder;
    }
    public String getOrderStateS() {
        return orderStateS;
    }
    public void setOrderStateS(String orderStateS) {
        this.orderStateS = orderStateS;
    }
    public String getOrderState() {
        return orderState;
    }
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
    public String getDealMid() {
        return dealMid;
    }
    public void setDealMid(String dealMid) {
        this.dealMid = dealMid;
    }
    public String getDealMember() {
        return dealMember;
    }
    public void setDealMember(String dealMember) {
        this.dealMember = dealMember;
    }
    public BigDecimal getStartingPrice() {
        return startingPrice;
    }
    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }
    public BigDecimal getCurPrice() {
        return curPrice;
    }
    public void setCurPrice(BigDecimal curPrice) {
        this.curPrice = curPrice;
    }
    public BigDecimal getReservePrice() {
        return reservePrice;
    }
    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }
    public BigDecimal getAuctionCashDeposit() {
        return auctionCashDeposit;
    }
    public void setAuctionCashDeposit(BigDecimal auctionCashDeposit) {
        this.auctionCashDeposit = auctionCashDeposit;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public Integer getAuctionTypeFlag() {
        return auctionTypeFlag;
    }
    public void setAuctionTypeFlag(Integer auctionTypeFlag) {
        this.auctionTypeFlag = auctionTypeFlag;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getParkAddress() {
        return parkAddress;
    }
    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public BigDecimal getJointPrice() {
        return jointPrice;
    }
    public void setJointPrice(BigDecimal jointPrice) {
        this.jointPrice = jointPrice;
    }
    public BigDecimal getHighestPrice() {
        return highestPrice;
    }
    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }
    public BigDecimal getOtherPrice() {
        return otherPrice;
    }
    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }
    public BigDecimal getCommission() {
        return commission;
    }
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getFullType() {
        return fullType;
    }
    public void setFullType(String fullType) {
        this.fullType = fullType;
    }
    public String getTimeCount() {
        return timeCount;
    }
    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }
    public String getSingleTime() {
        return singleTime;
    }
    public void setSingleTime(String singleTime) {
        this.singleTime = singleTime;
    }
    public String getAuctionStartTime() {
        return auctionStartTime;
    }
    public void setAuctionStartTime(String auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }
    public String getTimeEndCount() {
        return timeEndCount;
    }
    public void setTimeEndCount(String timeEndCount) {
        this.timeEndCount = timeEndCount;
    }
    public String getOneSecond() {
        return oneSecond;
    }
    public void setOneSecond(String oneSecond) {
        this.oneSecond = oneSecond;
    }

    @Override
    public String toString() {
        return "AuctionCar{" +
                "auctionId='" + auctionId + '\'' +
                ", auctionSetId='" + auctionSetId + '\'' +
                ", auctionNo='" + auctionNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullType='" + fullType + '\'' +
                ", singleTime='" + singleTime + '\'' +
                ", lotAreas='" + lotAreas + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleSystem='" + vehicleSystem + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", pmhId='" + pmhId + '\'' +
                ", pmOrder=" + pmOrder +
                ", orderStateS='" + orderStateS + '\'' +
                ", orderState='" + orderState + '\'' +
                ", dealMid='" + dealMid + '\'' +
                ", dealMember='" + dealMember + '\'' +
                ", startingPrice=" + startingPrice +
                ", curPrice=" + curPrice +
                ", reservePrice=" + reservePrice +
                ", auctionCashDeposit=" + auctionCashDeposit +
                ", imgPath='" + imgPath + '\'' +
                ", auctionTypeFlag=" + auctionTypeFlag +
                ", vin='" + vin + '\'' +
                ", parkAddress='" + parkAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", jointPrice=" + jointPrice +
                ", highestPrice=" + highestPrice +
                ", otherPrice=" + otherPrice +
                ", commission=" + commission +
                ", totalPrice=" + totalPrice +
                ", timeCount='" + timeCount + '\'' +
                ", timeEndCount='" + timeEndCount + '\'' +
                ", auctionStartTime='" + auctionStartTime + '\'' +
                ", oneSecond='" + oneSecond + '\'' +
                '}';
    }
}
