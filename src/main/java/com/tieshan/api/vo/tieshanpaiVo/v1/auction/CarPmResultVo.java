package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderAutopartsVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:33
 */
@Data
public class CarPmResultVo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pmhId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pmhEndTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ppId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ppEndTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //当前价
    private Integer thisPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //保留价
    private Integer retainPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ppNo;
}
