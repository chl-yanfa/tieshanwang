package com.tieshan.api.bo.homePageBo;

import lombok.Data;

import java.util.Date;

@Data
public class PaimaiBO {
    private String id;
    private String pmhId;                //拍卖会ID
    private Integer auctionType;        //拍品类型(0:全车配件,1:高价值配件,2:大宗物资)
    private String paimaiName;            //拍卖会名称
    private Date paimaiStartTime;        //拍卖开始时间
    private Date paimaiFinishTime;        //拍卖结束时间
    private Integer paimaiState;        //拍卖状态：0-待发布；1-进行中；2-已结束
    private Date systemTime;
}
