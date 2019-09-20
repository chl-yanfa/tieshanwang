package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:29
 */
@Data
public class CarScrapOrderQuotePageBO {
    private String id;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "订单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;;

    @ApiModelProperty(value = "车架号")
    private String carFrameNumber;

    @ApiModelProperty(value = "报价类型")
    private String orderType;

    @ApiModelProperty(value = "报价类型:整车|配件")
    private String orderTypeS;

    @ApiModelProperty(value = "整车:车牌号|旧件:配件数量")
    private String carNumberOrPartsNum;

    @ApiModelProperty(value = "车型")
    private String carModelNumberName;

    @ApiModelProperty(value = "委托方")
    private String custormName;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

    @ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;

    private String  branchOffice;

    private String  headOffice;

    //列表显示图片
    private String listPicture;
}
