package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/4 14:16
 */
public class StartVO {

    private String pmhId;

    private String auctionStartTime;

    private String auctionId;

    private String timeCount;

    private String fullName;

    private String pmOrder;

    private String singleTime;

    public String getPmhId() {
        return pmhId;
    }

    public void setPmhId(String pmhId) {
        this.pmhId = pmhId;
    }

    public String getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(String auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPmOrder() {
        return pmOrder;
    }

    public void setPmOrder(String pmOrder) {
        this.pmOrder = pmOrder;
    }

    public String getSingleTime() {
        return singleTime;
    }

    public void setSingleTime(String singleTime) {
        this.singleTime = singleTime;
    }
}
