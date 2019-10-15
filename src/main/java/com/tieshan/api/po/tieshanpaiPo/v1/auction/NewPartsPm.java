package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class NewPartsPm implements Serializable {
    private Integer id;

    private String partsName;

    private Integer partsNum;

    private String partsWeight;

    private String partsDescribe;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private List<String> txtImg;   //图片路径集合_车辆图片

    private List<String> fileId;   //图片路径集合_车辆图片

    private String  fileIds;

    private String auctionId;


    private static final long serialVersionUID = 1L;


}