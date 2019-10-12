package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderAutopartsVO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:33
 */
@Data
public class CarPmAuctionVo {

    private String id;

    private Integer auctionType;        //拍品类型(0:全车配件,1:auction高价值配件,2:大宗物资)

    private String auctionTypeS;    //拍品类型文字描述(全车配件、高价值配件)

    private String vin;             //车架号

    private String vehicleType;     //车型

    private String lotAreas;            //所在地区

    private Integer lotAreasId;            //所在地区Id

    private Integer isDrive;           //能否行驶 0.不可以 1.可以

    private BigDecimal reservePrice;   //预期保留价

    private BigDecimal auctionCashDeposit;  //参拍保证金


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date getCardTime;            //上牌时间

    private String description;           //描述

    private String dealMid;             //商户id

    private String orderId;             //订单ID

    private String orderNo;             //订单编号

    private Date dealTime;              //成交时间

    private Date payTime;               //付款时间

    private Date takeCarTime;           //提货时间

    private String auctionNo;            //拍品编号

    private String fullName;            //拍品名称

    private String licenseNumber;        //车牌号

    private List<Integer> lotAreasArr;

    private List<Integer> auctionTypeArr;

    private Date productionDate;        //出厂日期

    private String isHasKey;            //是否有钥匙 0-没有,1-有

    private String buyRequirement;        //购买要求

    private String lookContacts;        //看货联系人

    private String lookContactNumber;    //看货联系人手机号

    private String lookAddress;            //看货地址

    private String lookCoordinate;        //看货地址经纬度

    private String bidNotice;            //竞价须知

    private String specialNotice;        //特别提示

    private Integer isDelete;            //是否删除(0:有效,1:删除)

    private Date createTime;            //创建时间

    private String createUser;

    private BigDecimal startingPrice=BigDecimal.ZERO;     //起拍价

    private String orderState;           //订单状态id

    private String orderStateS;          //订单状态名称

    private BigDecimal commission=BigDecimal.ZERO;        //佣金

    private BigDecimal otherPrice=BigDecimal.ZERO;        //其他费用

    private List<CarPmAuctionFileVo> auctionFileList;    //图片集合_所有图片

    private List<CarPmAuctionFileVo> carFileList;    //图片集合_车辆图片_拍品使用

    private List<CarPmAuctionFileVo> docFileList;  //图片集合_手续照片_拍品使用

    private String imgPath;                //列表头像

    private Integer pageNum;                //页数

    private Integer rows;                 //每页显示行数

    private Date auctionStartTime;            //拍卖开始时间

    private Date auctionEndTime;              //拍卖结束时间

    private int type;

    private Integer lotPartsCount;   //新增拍品数量

    private String partsWeight;   //重量

    private Integer delaySecond = 0;			//系统延时秒数

    private BigDecimal highestPrice=BigDecimal.ZERO;			//当前出价最高价

    private BigDecimal totalPrice=BigDecimal.ZERO;				//当前合手价

    private BigDecimal realPrice=BigDecimal.ZERO;           //实际付款金额

    private List<CarScrapOrderAutopartsVO> autopartsList;    //配件列表

    private Date sysDate;

    private String carNumber;                 //车牌号

    private Integer partsCount;              //配件数量

    private BigDecimal orderAmount=BigDecimal.ZERO;          //订单金额

    private Date recoveryTime;               //回收时间

    private Date settlementTime;             //结算时间

    private String startDate;  //拍品开始时间_字符串

    private String endDate; //拍品结束时间_字符串

    private String pmhId;

    private String pmhEndTime;

    private String ppId;

    private String ppEndTime;

    private Integer auctionState; //拍品状态(0:保存,10:未上拍,2:进入拍卖会,3:待发布,4:拍卖中,5:成交,6:售后,7:完结,-10:已退货)

    private Integer registState;		//登记状态(0:未登记,1:已登记,2:已驳回)

    private String  fileIds;

    private String docFiles;

    private String scrapOrderId;

    private List<String> autopartsIdList;

    private List<String> txtImg;   //图片路径集合_车辆图片

    private List<String> docImg;  //图片路径集合_手续图片

    private Integer uploadType; //上传类型 0:用户 1：公司内部人员
}
