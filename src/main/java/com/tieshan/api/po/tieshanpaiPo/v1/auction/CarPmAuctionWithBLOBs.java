package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;

public class CarPmAuctionWithBLOBs extends CarPmAuction implements Serializable {
    private String bidNotice;

    private String specialNotice;

    private static final long serialVersionUID = 1L;

    public String getBidNotice() {
        return bidNotice;
    }

    public void setBidNotice(String bidNotice) {
        this.bidNotice = bidNotice == null ? null : bidNotice.trim();
    }

    public String getSpecialNotice() {
        return specialNotice;
    }

    public void setSpecialNotice(String specialNotice) {
        this.specialNotice = specialNotice == null ? null : specialNotice.trim();
    }
}