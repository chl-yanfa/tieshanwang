package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarPmCustomerMargin implements Serializable {
    private String id;

    private BigDecimal walletPledge;

    private BigDecimal walletPledgeFreeze;

    private BigDecimal transferOwnershipPledge;

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

    public BigDecimal getWalletPledge() {
        return walletPledge;
    }

    public void setWalletPledge(BigDecimal walletPledge) {
        this.walletPledge = walletPledge;
    }

    public BigDecimal getWalletPledgeFreeze() {
        return walletPledgeFreeze;
    }

    public void setWalletPledgeFreeze(BigDecimal walletPledgeFreeze) {
        this.walletPledgeFreeze = walletPledgeFreeze;
    }

    public BigDecimal getTransferOwnershipPledge() {
        return transferOwnershipPledge;
    }

    public void setTransferOwnershipPledge(BigDecimal transferOwnershipPledge) {
        this.transferOwnershipPledge = transferOwnershipPledge;
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