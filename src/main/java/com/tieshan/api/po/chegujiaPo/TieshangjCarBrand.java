package com.tieshan.api.po.chegujiaPo;

import java.io.Serializable;
import java.util.Date;

public class TieshangjCarBrand implements Serializable {
    private Integer id;

    private String bName;

    private String bInitials;

    private Integer autoLogoszId;

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

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbInitials() {
        return bInitials;
    }

    public void setbInitials(String bInitials) {
        this.bInitials = bInitials == null ? null : bInitials.trim();
    }

    public Integer getAutoLogoszId() {
        return autoLogoszId;
    }

    public void setAutoLogoszId(Integer autoLogoszId) {
        this.autoLogoszId = autoLogoszId;
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