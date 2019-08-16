package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

public class CarPmPaimai implements Serializable {
    private String id;

    private String pmhId;

    private String paimaiName;

    private Date paimaiStartTime;

    private Date paimaiFinishTime;

    private Integer singleTime;

    private Integer intervalTime;

    private String remark;

    private Integer paimaiState;

    private Date publishTime;

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private Date ts;

    private Integer auctionType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPmhId() {
        return pmhId;
    }

    public void setPmhId(String pmhId) {
        this.pmhId = pmhId == null ? null : pmhId.trim();
    }

    public String getPaimaiName() {
        return paimaiName;
    }

    public void setPaimaiName(String paimaiName) {
        this.paimaiName = paimaiName == null ? null : paimaiName.trim();
    }

    public Date getPaimaiStartTime() {
        return paimaiStartTime;
    }

    public void setPaimaiStartTime(Date paimaiStartTime) {
        this.paimaiStartTime = paimaiStartTime;
    }

    public Date getPaimaiFinishTime() {
        return paimaiFinishTime;
    }

    public void setPaimaiFinishTime(Date paimaiFinishTime) {
        this.paimaiFinishTime = paimaiFinishTime;
    }

    public Integer getSingleTime() {
        return singleTime;
    }

    public void setSingleTime(Integer singleTime) {
        this.singleTime = singleTime;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPaimaiState() {
        return paimaiState;
    }

    public void setPaimaiState(Integer paimaiState) {
        this.paimaiState = paimaiState;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    public Integer getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(Integer auctionType) {
        this.auctionType = auctionType;
    }
}