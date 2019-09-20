package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 10:49
 *   类名称：CarScrapOrderAutopartsDel
 *   类描述：配件实体类(被删除的数据)
 */
@Data
@Table(name="car_scrap_order_autoparts_del")
public class CarScrapOrderAutopartsDel extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "配件类型")
    private Integer partsType;

    @ApiModelProperty(value = "配件名称")
    private String partsName;

    @ApiModelProperty(value = "配件编号")
    private String partsNum;

    @ApiModelProperty(value = "配件数量")
    private Integer partsCount;

    @ApiModelProperty(value = "纯拆")
    private String isDismantle;

    @ApiModelProperty(value = "碰撞")
    private String isCollision;

    @ApiModelProperty(value = "自然磨损")
    private String isWear;

    @ApiModelProperty(value = "水淹")
    private String isFlood;

    @ApiModelProperty(value = "配件备注")
    private String remark;

    @ApiModelProperty(value = "分总报价金额")
    private BigDecimal subQuote;

    @ApiModelProperty(value = "配件金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "配件状态")
    private Integer orderAutopartsStatus;

    @ApiModelProperty(value = "分拣状态")
    private Integer sortingState;

    @ApiModelProperty(value = "无法接收原因")
    private Integer unableReceiveReason;

    private String qrPic;

    private Boolean isValid=true;
}
