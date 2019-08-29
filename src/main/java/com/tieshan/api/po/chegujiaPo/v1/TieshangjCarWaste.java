package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;
import java.util.Date;

public class TieshangjCarWaste implements Serializable {
    private Integer id;

    private String wName;

    private String demolitionMoney;

    private String demolitionXi;

    private String oldMoney;

    private String oldXi;

    private Integer carModelId;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName == null ? null : wName.trim();
    }

    public String getDemolitionMoney() {
        return demolitionMoney;
    }

    public void setDemolitionMoney(String demolitionMoney) {
        this.demolitionMoney = demolitionMoney == null ? null : demolitionMoney.trim();
    }

    public String getDemolitionXi() {
        return demolitionXi;
    }

    public void setDemolitionXi(String demolitionXi) {
        this.demolitionXi = demolitionXi == null ? null : demolitionXi.trim();
    }

    public String getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(String oldMoney) {
        this.oldMoney = oldMoney == null ? null : oldMoney.trim();
    }

    public String getOldXi() {
        return oldXi;
    }

    public void setOldXi(String oldXi) {
        this.oldXi = oldXi == null ? null : oldXi.trim();
    }

    public Integer getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}