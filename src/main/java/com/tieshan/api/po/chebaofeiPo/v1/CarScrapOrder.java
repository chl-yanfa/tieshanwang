package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:08
 */
@Data
@Table(name="car_scrap_order")
public class CarScrapOrder extends BasePojo {

    @Id
    private String id;

    private String orderNo;     //订单号,系统生产订单号

    private String reportNo;       //报案号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;         //订单产生时间,系统当前时间

    private Date reportTime;        //报案时间

    private String carNumber;       //车牌号

    private String carFrameNumber;      //车架号

    private String carModelNumber;      //车辆型号(数据来源车型号数据字典)

    private String carAge;          //车辆年限

    private String drivingMileage;  //行驶里程

    private String carAscription="1";   //车辆归属(1:个人,2:客户)

    private String carOwner;  //车主姓名

    private Integer orderAreasId;  //下单所在区域Id

    private String isdrive;  //能否行驶(1:否,2:是 3:严重事故)

    private Integer orderStatus; //订单状态（1.未接单(提交订单)、2.接单派单、3.业务员接收车辆、4.入场、5.报废(出库)、6.邮寄手续证明(入场后订单结束前填写)、7.财务结算、8.订单结束、9、订单异常）

    private String agentUserid;  //订单派单业务员id

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String carScrapDate;   //车辆证明日期

    private String orderType;   //订单类型（1:整车，2:旧件）

    private String takeCarContacts; //取车人联系人

    private String takeCarContactNumber;    //取车联系电话

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date takeCarTime;  //取车时间

    private String takeCarAddress;  //取车地址

    private String coordinate;  //取车地址经纬度

    private String expressCompany;      //快递公司

    private String expressNumber;   //快递单号

    private String mailingAddressName;      //快递邮递人明细(收件人姓名)

    private String mailingAddressTelephone;     //快递邮寄电话(收件人电话)

    private Integer province;       //快递邮递省份主键

    private Integer city;       //快递邮寄市区主键

    private Integer county;     //快递邮递县/地区之间

    private String detailedAddress;     //快递详细地址(收件人详细地址)

    private BigDecimal subQuote;        //分总报价金额

    private BigDecimal orderAmount;    //订单金额

    private BigDecimal sinceQuote;  //二次报价金额

    private String clientId;       //委托方(当前登录用户id)

    @JsonIgnore
    private String clientType;      //申请订单客户类型（1：各人 2：大客户）

    private String payeeName;       //收款人姓名

    private String bankAccount;    //银行账户

    private String bank;        //所属银行

    private String openingBank;     //开户行

    private String cancelMemo;      //取消原因

    @JsonIgnore
    private Boolean isremove=false;  //客户账户是否删除，默认是：false 有效账户

    @JsonIgnore
    private String sourceType;  //数据来源（1.web 2.小程序,3：其他）

    private String auditRemark;

    private String operator;     //数据操作人

    private String adjustWhy;   //业务员现场调整价格原因

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operatortime;          //派单时间

    private Integer factoryId;      //解体厂ID

    private Integer isAgree;    //判断用户端是否点击了同意

    private Integer isTake;     //判断用户端是否点击了去取车

    private String pdName;      //派单人姓名

    private String pdPhone;         //派单人手机号

    private BigDecimal referPrice;  //估价参考价

    private String auctionId;
}
