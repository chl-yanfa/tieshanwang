package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "订单号,系统生产订单号")
    //@NotEmpty(message="用户名不能为空")
    //@Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String orderNo;

    @ApiModelProperty(value = "报案号")
    private String reportNo;

    @ApiModelProperty(value = "订单产生时间,系统当前时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;

    @ApiModelProperty(value = "报案时间")
    private Date reportTime;

    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    @ApiModelProperty(value = "车架号")
    private String carFrameNumber;

    @ApiModelProperty(value = "车辆型号(数据来源车型号数据字典)")
    private String carModelNumber;

    @ApiModelProperty(value = "车辆年限")
    private String carAge;

    @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;

    @ApiModelProperty(value = "车辆归属(1:个人,2:客户)")
    private String carAscription="1";

    @ApiModelProperty(value = "车主姓名")
    private String carOwner;

    //@ApiModelProperty(value = "下单所在区域")
    private Integer orderAreasId;

    @ApiModelProperty(value = "能否行驶(1:否,2:是 3:严重事故)")
    private String isdrive;

    @ApiModelProperty(value = "订单状态（1.未接单(提交订单)、2.接单派单、3.业务员接收车辆、4.入场、5.报废(出库)、6.邮寄手续证明(入场后订单结束前填写)、7.财务结算、8.订单结束、9、订单异常）")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单派单业务员id")
    //@JsonIgnore
    private String agentUserid;

    @ApiModelProperty(value = "车辆证明日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String carScrapDate;

    @ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
    private String orderType;

    @ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

    @ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;

    @ApiModelProperty(value = "取车时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date takeCarTime;

    @ApiModelProperty(value = "取车地址")
    private String takeCarAddress;

    @ApiModelProperty(value = "取车地址经纬度",hidden = true)
    private String coordinate;


    @ApiModelProperty(value = "快递公司")
    private String expressCompany;

    @ApiModelProperty(value = "快递单号")
    private String expressNumber;

    @ApiModelProperty(value = "快递邮递人明细(收件人姓名)")
    private String mailingAddressName;

    @ApiModelProperty(value = "快递邮寄电话(收件人电话)")
    private String mailingAddressTelephone;

    @ApiModelProperty(value = "快递邮递省份主键")
    private Integer province;

    @ApiModelProperty(value = "快递邮寄市区主键")
    private Integer city;

    @ApiModelProperty(value = "快递邮递县/地区之间")
    private Integer county;

    @ApiModelProperty(value = "快递详细地址(收件人详细地址)")
    private String detailedAddress;

    @ApiModelProperty(value = "分总报价金额")
    private BigDecimal subQuote;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "二次报价金额")
    private BigDecimal sinceQuote;

    //@ApiModelProperty(value = "委托方(当前登录用户id)")

    private String clientId;

    //"申请订单客户类型（1：各人 2：大客户）")
    @JsonIgnore
    private String clientType;

    @ApiModelProperty(value = "收款人姓名")
    private String payeeName;

    @ApiModelProperty(value = "银行账户")
    private String bankAccount;

    @ApiModelProperty(value = "所属银行")
    private String bank;

    @ApiModelProperty(value = "开户行")
    private String openingBank;

    @ApiModelProperty(value = "取消原因")
    private String cancelMemo;

    //@ApiModelProperty(value = "客户账户是否删除，默认是：false 有效账户")
    @JsonIgnore
    private Boolean isremove=false;

    //@ApiModelProperty(value = "数据来源（1.web 2.小程序,3：其他）")
    @JsonIgnore
    private String sourceType;
    private String auditRemark;

    @ApiModelProperty(value = "数据操作人")
    private String operator;

    //业务员现场调整价格原因
    private String adjustWhy;

    //派单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operatortime;

    //解体厂ID
    private Integer factoryId;

    //判断用户端是否点击了同意
    private Integer isAgree;

    //判断用户端是否点击了去取车
    private Integer isTake;

    //派单人姓名
    private String pdName;

    //派单人手机号
    private String pdPhone;
}
