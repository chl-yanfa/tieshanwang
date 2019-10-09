package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:09
 */
@Data
@Table(name="car_scrap_order_audit")
public class CarScrapOrderAudit extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderId;  //订单id

    private Integer lasttimeId;  //上次审核id

    private Integer stauts;  //订单状态

    private String remark;  //审核备注

    private String auditor;  //审核人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;  //审核时间

    private String businessType; //业务类型

    @JsonIgnore
    private Date createtime;

    @JsonIgnore
    private Date operatortime;

    @JsonIgnore
    private String creater;

    @JsonIgnore
    private String operator;

    public CarScrapOrderAudit(){

    }
    public CarScrapOrderAudit(String orderId, Integer lasttimeId, String businessType, Integer stauts,
                              String remark, String auditor, Date auditTime, String creater, String operator, Date createtime,
                              Date operatortime) {
        this.orderId = orderId;
        this.lasttimeId = lasttimeId;
        this.businessType = businessType;
        this.stauts = stauts;
        this.remark = remark;
        this.auditor = auditor;
        this.auditTime = auditTime;
        this.creater = creater;
        this.operator = operator;
        this.createtime = createtime;
        this.operatortime = operatortime;
    }
}
