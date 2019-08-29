package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

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

    private String pmhId;

    private String pmhEndTime;

    private String ppId;

    private String ppEndTime;


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

}
