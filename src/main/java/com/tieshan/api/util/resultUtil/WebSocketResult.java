package com.tieshan.api.util.resultUtil;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/26 18:32
 */
@Data
public class WebSocketResult {

    private String auction;

    private String totalPrice;

    private String realPrice;

    private String startTimeCount;

    private String endTimeCount;

    private String orderState;

    private String orderStateS;

    private String cid;

    private String uid;


    @Override
    public String toString() {
        return "WebSocketResult{" +
                "auction='" + auction + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", realPrice='" + realPrice + '\'' +
                ", startTimeCount='" + startTimeCount + '\'' +
                ", endTimeCount='" + endTimeCount + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderStateS='" + orderStateS + '\'' +
                ", cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
