package com.tieshan.api.bo.homePageBo;

import lombok.Data;

import java.util.List;
@Data
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

}
