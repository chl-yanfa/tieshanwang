package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarPmAuctionSet implements Serializable {
    private String id;

    private String auctionId;

    private String orderNo;

    private BigDecimal startingPrice;

    private BigDecimal reservePrice;

    private BigDecimal auctionCashDeposit;

    private BigDecimal commission;

    private BigDecimal otherPrice;

    private String remark;

    private String orderState;

    private String pmhId;

    private Integer pmOrder;

    private Date auctionStartTime;

    private Date auctionEndTime;

    private Integer intervalTime;

    private Integer singleTime;

    private Date dealTime;

    private String dealType;

    private String dealMid;

    private String dealMember;

    private BigDecimal jointPrice;

    private BigDecimal highestPrice;

    private Boolean isHistory;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId == null ? null : auctionId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getAuctionCashDeposit() {
        return auctionCashDeposit;
    }

    public void setAuctionCashDeposit(BigDecimal auctionCashDeposit) {
        this.auctionCashDeposit = auctionCashDeposit;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getPmhId() {
        return pmhId;
    }

    public void setPmhId(String pmhId) {
        this.pmhId = pmhId == null ? null : pmhId.trim();
    }

    public Integer getPmOrder() {
        return pmOrder;
    }

    public void setPmOrder(Integer pmOrder) {
        this.pmOrder = pmOrder;
    }

    public Date getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(Date auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public Date getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Date auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }

    public Integer getSingleTime() {
        return singleTime;
    }

    public void setSingleTime(Integer singleTime) {
        this.singleTime = singleTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType == null ? null : dealType.trim();
    }

    public String getDealMid() {
        return dealMid;
    }

    public void setDealMid(String dealMid) {
        this.dealMid = dealMid == null ? null : dealMid.trim();
    }

    public String getDealMember() {
        return dealMember;
    }

    public void setDealMember(String dealMember) {
        this.dealMember = dealMember == null ? null : dealMember.trim();
    }

    public BigDecimal getJointPrice() {
        return jointPrice;
    }

    public void setJointPrice(BigDecimal jointPrice) {
        this.jointPrice = jointPrice;
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Boolean getIsHistory() {
        return isHistory;
    }

    public void setIsHistory(Boolean isHistory) {
        this.isHistory = isHistory;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}