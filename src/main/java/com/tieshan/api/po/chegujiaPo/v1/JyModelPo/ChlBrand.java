package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import java.io.Serializable;
import java.util.Date;

public class ChlBrand implements Serializable {
    private Integer id;

    private String brname;

    private String brnameAlias;

    private String initials;

    private String brIntroduce;

    private Integer country;

    private Integer state;

    private Integer category;

    private String logo;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String brandCode;

    private Integer autoLogoszId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrname() {
        return brname;
    }

    public void setBrname(String brname) {
        this.brname = brname == null ? null : brname.trim();
    }

    public String getBrnameAlias() {
        return brnameAlias;
    }

    public void setBrnameAlias(String brnameAlias) {
        this.brnameAlias = brnameAlias == null ? null : brnameAlias.trim();
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials == null ? null : initials.trim();
    }

    public String getBrIntroduce() {
        return brIntroduce;
    }

    public void setBrIntroduce(String brIntroduce) {
        this.brIntroduce = brIntroduce == null ? null : brIntroduce.trim();
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
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

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    public Integer getAutoLogoszId() {
        return autoLogoszId;
    }

    public void setAutoLogoszId(Integer autoLogoszId) {
        this.autoLogoszId = autoLogoszId;
    }
}