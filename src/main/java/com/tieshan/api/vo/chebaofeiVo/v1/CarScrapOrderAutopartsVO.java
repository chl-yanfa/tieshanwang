/**
 * 
 */
package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:40
 */
@Data
public class CarScrapOrderAutopartsVO {
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

	private String qrPic;

	@ApiModelProperty(value = "无法接收原因")
	private Integer unableReceiveReason;

	@ApiModelProperty(value = "配件金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "数据操作人记录")
	private String operator;
	private String creater;

	//"申请订单客户类型（1：各人 2：大客户）")
	@ApiModelProperty(hidden = true)
	private String clientType;

	private List<CarScrapOrderPictureVO> pictures = new ArrayList<CarScrapOrderPictureVO>();

}
