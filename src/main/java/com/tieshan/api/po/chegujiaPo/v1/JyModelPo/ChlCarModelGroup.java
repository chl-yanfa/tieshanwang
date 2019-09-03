package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import java.io.Serializable;
import java.util.Date;

public class ChlCarModelGroup implements Serializable {
    private Integer id;

    private String trainCrewName;

    private Integer vehiceSystemId;

    private Date createdTime;

    private String createdBy;

    private String updatedBy;

    private Date updatedTime;

    private Integer state;

    private String trainCrewCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainCrewName() {
        return trainCrewName;
    }

    public void setTrainCrewName(String trainCrewName) {
        this.trainCrewName = trainCrewName == null ? null : trainCrewName.trim();
    }

    public Integer getVehiceSystemId() {
        return vehiceSystemId;
    }

    public void setVehiceSystemId(Integer vehiceSystemId) {
        this.vehiceSystemId = vehiceSystemId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTrainCrewCode() {
        return trainCrewCode;
    }

    public void setTrainCrewCode(String trainCrewCode) {
        this.trainCrewCode = trainCrewCode == null ? null : trainCrewCode.trim();
    }
}