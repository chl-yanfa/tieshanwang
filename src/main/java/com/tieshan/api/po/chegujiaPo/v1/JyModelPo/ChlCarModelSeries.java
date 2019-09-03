package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import java.io.Serializable;
import java.util.Date;

public class ChlCarModelSeries implements Serializable {
    private Integer id;

    private String vehicleSystemName;

    private Integer brandId;

    private Integer state;

    private Date createdTime;

    private String createdBy;

    private String updatedBy;

    private Date updatedTime;

    private String vehicleSystemCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleSystemName() {
        return vehicleSystemName;
    }

    public void setVehicleSystemName(String vehicleSystemName) {
        this.vehicleSystemName = vehicleSystemName == null ? null : vehicleSystemName.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
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

    public String getVehicleSystemCode() {
        return vehicleSystemCode;
    }

    public void setVehicleSystemCode(String vehicleSystemCode) {
        this.vehicleSystemCode = vehicleSystemCode == null ? null : vehicleSystemCode.trim();
    }
}