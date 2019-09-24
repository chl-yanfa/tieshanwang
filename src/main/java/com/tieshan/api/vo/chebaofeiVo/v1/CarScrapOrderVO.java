package com.tieshan.api.vo.chebaofeiVo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    //报案号
    private String reportNo;

    //报案时间
    private Date reportTime;

    //车牌号
    private String carNumber;

    //车架号
    private String carFrameNumber;

    //车辆型号(数据来源车型号数据字典)
    private String carModelNumber;

    //车辆年限
    private String carAge;

    //行驶里程
    private String drivingMileage;

    //车辆归属(1:个人,2:客户)
    private String carAscription="1";

    //车主姓名
    private String carOwner;

    //订单区域id
    private Integer orderAreasId;

    //客户端登陆用户id
    private String clientId;

    //申请订单客户类型（1：个人 2：大客户）")
    private String clientType;

    //能否行驶(0:否,1:是)
    private String isdrive;

    //订单类型（1:整车，2:旧件）
    private String orderType;

    //取车人联系人
    private String takeCarContacts;

    //取车联系电话
    private String takeCarContactNumber;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    //取车时间
    private Date takeCarTime;

    //取车地址
    private String takeCarAddress;

    //取车地址经纬度
    private String coordinate;

    //快递公司
    private String expressCompany;

    //快递单号
    private String expressNumber;

    //快递邮递人明细
    private String mailingAddressName;

    //快递邮寄电话
    private String mailingAddressTelephone;

    //快递邮递省份主键
    private Integer province;

    //快递邮寄市区主键
    private Integer city;

    //快递邮递县/地区之间
    private Integer county;

    //快递详细地址
    private String detailedAddress;

    //收款人姓名
    private String payeeName;

    //所属银行
    private String bank;

    //银行账户
    private String bankAccount;

    //开户行
    private String openingBank;

    //数据创建人(系统获取登录session填充)
    private String creater;

    //修改人(系统获取登录session填充
    private String operator;

    //订单金额
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

    //估价参考价
    private BigDecimal referPrice;

    private List<CarScrapOrderPictureVO> pictures = new ArrayList<CarScrapOrderPictureVO>();
}
