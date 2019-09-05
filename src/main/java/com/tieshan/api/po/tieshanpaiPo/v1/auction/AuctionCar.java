package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 13:55
 */
@Data
public class AuctionCar {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String auctionId;			//拍品id

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String auctionSetId;		//参拍id

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String auctionNo;			//拍品编号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fullName;			//拍品名称

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fullType;            //拍品类型

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String singleTime;          //要添加的秒数

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lotAreas;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String vehicleBrand;		//品牌

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String vehicleType;			//车型

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String vehicleSystem;		//车系

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String licenseNumber;		//车牌号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pmhId;				//拍卖会ID

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pmOrder;			//拍卖序号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderStateS;			//拍品状态

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderState;			//拍品状态

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dealMid;				//买受人memberCode

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dealMember;			//买受人

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal startingPrice=BigDecimal.ZERO;		//起拍价

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal curPrice=BigDecimal.ZERO;			//当前价

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal reservePrice=BigDecimal.ZERO;		//保留价

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal auctionCashDeposit=BigDecimal.ZERO;	//参拍保证金

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imgPath;				//列表头像

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer auctionTypeFlag;	//拍品类型

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String vin;					//车架号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parkAddress;			//停放地址

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;				//手机号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idCard;			//身份证号码

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal jointPrice=BigDecimal.ZERO;				//合手价

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal highestPrice=BigDecimal.ZERO;		//最终成交价

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal otherPrice=BigDecimal.ZERO;			//最终其他费用

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal commission=BigDecimal.ZERO;	//最终佣金

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalPrice=BigDecimal.ZERO;			//总计

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timeCount;   //单个拍品开始时间

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timeEndCount; //单个拍品结束时间

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String auctionStartTime;  //拍卖会开始时间

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String oneSecond; //距离单个拍品开始的秒数

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
