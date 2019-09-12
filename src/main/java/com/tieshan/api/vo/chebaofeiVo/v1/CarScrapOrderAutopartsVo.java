/**
 * 
 */
package com.tieshan.api.vo.chebaofeiVo.v1;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:40
 */
@Data
public class CarScrapOrderAutopartsVo {
	private String id;

	private String orderId;

	private String orderNo;

	private Integer partsType;

	private String partsName;

	private String partsNum;

	private String carModelNumber;

	private String carFrameNumber;

	private String carNumber;

	private String headImgPath;

}
