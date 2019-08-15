package com.tieshan.api.po.tieshanpaiPo;

import java.io.Serializable;
import java.util.Date;

public class CarPmAuctionSetAudit implements Serializable {
    private String id;

    private String auctionTemplateId;

    private Integer templeteFlag;

    private Integer isPass;

    private String noPassReason;

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

    public String getAuctionTemplateId() {
        return auctionTemplateId;
    }

    public void setAuctionTemplateId(String auctionTemplateId) {
        this.auctionTemplateId = auctionTemplateId == null ? null : auctionTemplateId.trim();
    }

    public Integer getTempleteFlag() {
        return templeteFlag;
    }

    public void setTempleteFlag(Integer templeteFlag) {
        this.templeteFlag = templeteFlag;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public String getNoPassReason() {
        return noPassReason;
    }

    public void setNoPassReason(String noPassReason) {
        this.noPassReason = noPassReason == null ? null : noPassReason.trim();
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