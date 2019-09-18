package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:37
 */
@Data
@Table(name="car_scrap_inquiry_price")
public class CarScrapInquiryPrice extends BasePojo {
    @Id
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

    @ApiModelProperty(value = "配件图片存储id")
    private Integer partsAttachmentId;

    @ApiModelProperty(value = "手机号码")
    private String contactNumber;

    @ApiModelProperty(value = "状态 0:未联系,1:已联系,2:忽略")
    private Integer status;
}
