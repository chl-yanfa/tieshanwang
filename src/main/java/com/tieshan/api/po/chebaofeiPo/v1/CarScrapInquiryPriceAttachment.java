package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:53
 */
@Data
@Table(name="car_scrap_inquiry_price_attachment")
public class CarScrapInquiryPriceAttachment extends BasePojo{
    @Id
    private Integer id;

    @ApiModelProperty(value = "附件存储id")
    private Integer attachmentId;

    @ApiModelProperty(value = "关联id")
    private String inquiryPriceId;

    @ApiModelProperty(value = "是否删除")
    private Integer isremove;
}
