package com.tieshan.api.vo.chebaofeiVo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:55
 */
@Data
public class CarScrapInquiryPricePageVO {
    private String scrapType;
    private String carModel;
    private String keywords;
    private String drivingMileage;
    private String partsName;
    private String contactNumber;
    private Integer status;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
