package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderAutopartsVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:33
 */
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


    public String getPmhId() {
        return pmhId;
    }
    public void setPmhId(String pmhId) {
        this.pmhId = pmhId;
    }
    public String getPmhEndTime() {
        return pmhEndTime;
    }
    public void setPmhEndTime(String pmhEndTime) {
        this.pmhEndTime = pmhEndTime;
    }
    public String getPpId() {
        return ppId;
    }
    public void setPpId(String ppId) {
        this.ppId = ppId;
    }
    public String getPpEndTime() {
        return ppEndTime;
    }
    public void setPpEndTime(String ppEndTime) {
        this.ppEndTime = ppEndTime;
    }
    public Integer getThisPrice() {
        return thisPrice;
    }
    public void setThisPrice(Integer thisPrice) {
        this.thisPrice = thisPrice;
    }
    public Integer getRetainPrice() {
        return retainPrice;
    }
    public void setRetainPrice(Integer retainPrice) {
        this.retainPrice = retainPrice;
    }

    @Override
    public String toString() {
        return "CarPmResultVo{" +
                "pmhId='" + pmhId + '\'' +
                ", pmhEndTime='" + pmhEndTime + '\'' +
                ", ppId='" + ppId + '\'' +
                ", ppEndTime='" + ppEndTime + '\'' +
                ", thisPrice=" + thisPrice +
                ", retainPrice=" + retainPrice +
                '}';
    }
}
