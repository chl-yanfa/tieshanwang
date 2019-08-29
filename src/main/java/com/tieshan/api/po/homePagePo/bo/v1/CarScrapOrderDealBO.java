package com.tieshan.api.po.homePagePo.bo.v1;

import java.util.List;

public class CarScrapOrderDealBO {
    private String id;

    private String orderNo;

    private String orderType;

    private String oe;

    private String carBrand;

    private String carModelNumber;

    private String carFrameNumber;

    private String carNumber;


    private String partsName;


    private String partsStandardName;

    private String quality;


    private String condition;
    private String carOwner;


    private String address;

    private String drivingMileage;


    private String carAge;


    private String description;


    private String headImgUrl;


    private Integer isremove;

    private String liulan;

    private String zt;

    private List<CarScrapOrderDealAttachmentBO> attachmentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOe() {
        return oe;
    }

    public void setOe(String oe) {
        this.oe = oe;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModelNumber() {
        return carModelNumber;
    }

    public void setCarModelNumber(String carModelNumber) {
        this.carModelNumber = carModelNumber;
    }

    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getPartsStandardName() {
        return partsStandardName;
    }

    public void setPartsStandardName(String partsStandardName) {
        this.partsStandardName = partsStandardName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(String drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    public String getCarAge() {
        return carAge;
    }

    public void setCarAge(String carAge) {
        this.carAge = carAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getIsremove() {
        return isremove;
    }

    public void setIsremove(Integer isremove) {
        this.isremove = isremove;
    }

    public String getLiulan() {
        return liulan;
    }

    public void setLiulan(String liulan) {
        this.liulan = liulan;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public List<CarScrapOrderDealAttachmentBO> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<CarScrapOrderDealAttachmentBO> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
