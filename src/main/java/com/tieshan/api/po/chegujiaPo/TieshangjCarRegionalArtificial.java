package com.tieshan.api.po.chegujiaPo;

import java.io.Serializable;
import java.util.Date;

public class TieshangjCarRegionalArtificial implements Serializable {
    private Integer id;

    private Integer carTid;

    private Integer provinceId;

    private Integer cityId;

    private String adjustmentNum;

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

    public Integer getCarTid() {
        return carTid;
    }

    public void setCarTid(Integer carTid) {
        this.carTid = carTid;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAdjustmentNum() {
        return adjustmentNum;
    }

    public void setAdjustmentNum(String adjustmentNum) {
        this.adjustmentNum = adjustmentNum == null ? null : adjustmentNum.trim();
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