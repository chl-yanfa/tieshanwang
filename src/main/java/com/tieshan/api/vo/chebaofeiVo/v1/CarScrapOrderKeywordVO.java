package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:06
 */
@Data
public class CarScrapOrderKeywordVO {
    @ApiModelProperty(value = "查询关键字")
    private String keyWord;

    @ApiModelProperty(value = "查询订单状态")
    private String orderStatus;

    //@ApiModelProperty(value = "代办人主键")
    @ApiParam(hidden = true)
    private String userid;

    //@ApiModelProperty(value = "订单委托人")
    @ApiParam(hidden = true)
    private String clientId;


    @ApiModelProperty(value = "订单类型：1整车 2.旧件")
    private String orderType;

    @ApiParam(hidden = true)
    private String araesids;

    @ApiParam(hidden = true)
    private List<String> araesidList;

    @ApiParam(hidden = true)
    private List<String> orderStatusList;

    @ApiModelProperty(value = "分拣状态")
    private Integer sortingState;

    private Boolean isSorting;

    @ApiParam(hidden = true)
    private Date earlyWarningDate;

    @ApiModelProperty(value = "用于显示二次报价总部已审核的条件")
    private Integer isWhere;
}
