package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:18
 */
@Data
public class CarScrapOrderSettlement extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ApiModelProperty(value = "结算流水")
    private Integer settlementFlow;

    @ApiModelProperty(value = "结算类型（1:整车 2:配件）")
    private String settlementType;

    @ApiModelProperty(value = "结算对象id")
    private String settlementObjectId;

    @ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

    @ApiModelProperty(value = "结算备注")
    private String settlementRemarks;

    @ApiModelProperty(value = "结算操作员")
    private String settlementer;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结算时间")
    private Date settlementTime;
}
