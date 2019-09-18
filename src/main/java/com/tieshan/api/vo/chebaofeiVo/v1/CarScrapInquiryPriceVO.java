package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:30
 */
@Data
public class CarScrapInquiryPriceVO {

    private String id;

    @ApiModelProperty(value = "类型（1:整车，2:旧件）")
    private String scrapType;

    @ApiModelProperty(value = "车辆型号(数据来源车型号数据字典)")
    private String carModel;

    @ApiModelProperty(value = "车龄")
    private String carAge;

    @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;

    @ApiModelProperty(value = "配件名称")
    private String partsName;

    @ApiModelProperty(value = "手机号码")
    private String contactNumber;

    @ApiModelProperty(hidden = true)
    private String creater;

    @ApiModelProperty(hidden = true)
    private String operator;

    private List<Integer> partsAttachmentIdList;
}
