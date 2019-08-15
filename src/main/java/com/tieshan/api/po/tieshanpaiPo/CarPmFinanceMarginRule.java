package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarPmFinanceMarginRule implements Serializable {
    private String id;

    private String auctionType;

    private String marginType;

    private BigDecimal dealStartPrice;

    private BigDecimal dealEndPrice;

    private String curPriceType;

    private BigDecimal curPrice;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private Date ts;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType == null ? null : auctionType.trim();
    }

    public String getMarginType() {
        return marginType;
    }

    public void setMarginType(String marginType) {
        this.marginType = marginType == null ? null : marginType.trim();
    }

    public BigDecimal getDealStartPrice() {
        return dealStartPrice;
    }

    public void setDealStartPrice(BigDecimal dealStartPrice) {
        this.dealStartPrice = dealStartPrice;
    }

    public BigDecimal getDealEndPrice() {
        return dealEndPrice;
    }

    public void setDealEndPrice(BigDecimal dealEndPrice) {
        this.dealEndPrice = dealEndPrice;
    }

    public String getCurPriceType() {
        return curPriceType;
    }

    public void setCurPriceType(String curPriceType) {
        this.curPriceType = curPriceType == null ? null : curPriceType.trim();
    }

    public BigDecimal getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(BigDecimal curPrice) {
        this.curPrice = curPrice;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}