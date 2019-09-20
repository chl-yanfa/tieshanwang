package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:25
 */
@Data
public class OrderAduitBO extends CarScrapOrder {
    private Integer partsCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date receiveOrderTime;

    private String recipient;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date settlementTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
}
