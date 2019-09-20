package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "上次审核id")
    private Integer lasttimeId;

    @ApiModelProperty(value = "订单状态")
    private Integer stauts;

    @ApiModelProperty(value = "审核备注")
    private String remark;

    @ApiModelProperty(value = "审核人")
    private String auditor;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;

    @ApiModelProperty(value = "业务类型")
    private String businessType;
}
