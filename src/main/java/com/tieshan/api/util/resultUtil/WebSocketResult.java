package com.tieshan.api.util.resultUtil;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/26 18:32
 */
public class WebSocketResult {

    private String auction;

    private String totalPrice;

    private String startTimeCount;

    private String endTimeCount;

    private String orderState;

    private String orderStateS;

    private String cid;

    public String getAuction() {
        return auction;
    }

    public void setAuction(String auction) {
        this.auction = auction;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStartTimeCount() {
        return startTimeCount;
    }

    public void setStartTimeCount(String startTimeCount) {
        this.startTimeCount = startTimeCount;
    }

    public String getEndTimeCount() {
        return endTimeCount;
    }

    public void setEndTimeCount(String endTimeCount) {
        this.endTimeCount = endTimeCount;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderStateS() {
        return orderStateS;
    }

    public void setOrderStateS(String orderStateS) {
        this.orderStateS = orderStateS;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "WebSocketResult{" +
                "auction='" + auction + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", startTimeCount='" + startTimeCount + '\'' +
                ", endTimeCount='" + endTimeCount + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderStateS='" + orderStateS + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
