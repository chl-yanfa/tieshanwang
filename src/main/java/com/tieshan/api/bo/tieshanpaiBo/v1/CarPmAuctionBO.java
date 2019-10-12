package com.tieshan.api.bo.tieshanpaiBo.v1;

import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionFileVo;
import lombok.Data;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0 返回拍品json数据类
 * @date 2019/10/12 10:15
 */
@Data
public class CarPmAuctionBO {

    private String id; //拍品id

    private String lotAreas; //拍品所属地区

    private Integer lotAreaId; //拍品所属地区id

    private String auctionType; //拍品类型 0.全车配件 1.高价值配件 2.大宗物资

    private String auctionName; //拍品名称

    private String auctionAuditState; //拍品审核状态 0.待审核 1.已审核 -1.未通过审核

    private String vin; //vin码

    private String description; //拍品描述

    private String imgPath; //拍品列表显示缩略图

    private List<CarPmAuctionFileVo> auctionFileList;    //图片集合_拍品详情图片轮播图集合
}
