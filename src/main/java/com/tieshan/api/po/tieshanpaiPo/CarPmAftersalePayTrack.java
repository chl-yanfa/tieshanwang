package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmAftersalePayTrack implements Serializable {
    private String id;

    private String auctionId;

    private String auctionSetId;

    private String trackMessage;

    private String operator;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

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

    public String getAuctionSetId() {
        return auctionSetId;
    }

    public void setAuctionSetId(String auctionSetId) {
        this.auctionSetId = auctionSetId == null ? null : auctionSetId.trim();
    }

    public String getTrackMessage() {
        return trackMessage;
    }

    public void setTrackMessage(String trackMessage) {
        this.trackMessage = trackMessage == null ? null : trackMessage.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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
}