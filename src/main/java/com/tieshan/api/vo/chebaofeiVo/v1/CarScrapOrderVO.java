package com.tieshan.api.vo.chebaofeiVo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:22
 */
@Data
public class CarScrapOrderVO {
    private String id;

    @ApiModelProperty(value = "报案号")
    private String reportNo;

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

    @ApiModelProperty(hidden = true)
    private Integer orderAreasId;

    @ApiModelProperty(hidden = true)
    private String clientId;

    //"申请订单客户类型（1：各人 2：大客户）")
    @ApiModelProperty(hidden = true)
    private String clientType;

    @ApiModelProperty(value = "能否行驶(0:否,1:是)")
    private String isdrive;

    @ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
    private String orderType;

    @ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

    @ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "取车时间")
    private Date takeCarTime;

    @ApiModelProperty(value = "取车地址")
    private String takeCarAddress;

    @ApiModelProperty(value = "取车地址经纬度",hidden = true)
    private String coordinate;


    @ApiModelProperty(value = "快递公司")
    private String expressCompany;

    @ApiModelProperty(value = "快递单号")
    private String expressNumber;

    @ApiModelProperty(value = "快递邮递人明细")
    private String mailingAddressName;

    @ApiModelProperty(value = "快递邮寄电话")
    private String mailingAddressTelephone;

    @ApiModelProperty(value = "快递邮递省份主键")
    private Integer province;

    @ApiModelProperty(value = "快递邮寄市区主键")
    private Integer city;

    @ApiModelProperty(value = "快递邮递县/地区之间")
    private Integer county;

    @ApiModelProperty(value = "快递详细地址")
    private String detailedAddress;



    @ApiModelProperty(value = "收款人姓名")
    private String payeeName;

    @ApiModelProperty(value = "	所属银行")
    private String bank;

    @ApiModelProperty(value = "银行账户")
    private String bankAccount;

    @ApiModelProperty(value = "开户行")
    private String openingBank;

    //@ApiModelProperty(value = "数据创建人(系统获取登录session填充)")
    @ApiModelProperty(hidden = true)
    private String creater;

    //@ApiModelProperty(value = "修改人(系统获取登录session填充)")
    @ApiModelProperty(hidden = true)
    private String operator;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    private String auditRemark;

    private String agentUserid;
    

    List<CarScrapOrderAutopartsVO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsVO>();
    //是否设置常用联系人
    private Boolean isSetUpContacts=false;

    //是否设置常用收款账户
    private Boolean isSetUpPayee=false;

    //是否设置常用收件人
    private Boolean isSetUpMailing=false;


    private List<CarScrapOrderPictureVO> pictures = new ArrayList<CarScrapOrderPictureVO>();
}
