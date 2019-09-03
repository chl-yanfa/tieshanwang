package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;
import java.util.Date;

public class TieshangjCarModel implements Serializable {
    private Integer id;

    private String carName;

    private Integer carCrewId;

    private String ironCode;

    private String money;

    private String displacement;

    private String bodyStructure;

    private String typeTransmission;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String zbzl;

    private String jyid;

    private String jyjson;

    private String mergecode;

    private TieshangjCarAutoLogos tieshangjCarAutoLogos;

    private TieshangjCarVehicleSystem tieshangjCarVehicleSystem;

    private TieshangjCarBrand tieshangjCarBrand;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public Integer getCarCrewId() {
        return carCrewId;
    }

    public void setCarCrewId(Integer carCrewId) {
        this.carCrewId = carCrewId;
    }

    public String getIronCode() {
        return ironCode;
    }

    public void setIronCode(String ironCode) {
        this.ironCode = ironCode == null ? null : ironCode.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement == null ? null : displacement.trim();
    }

    public String getBodyStructure() {
        return bodyStructure;
    }

    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure == null ? null : bodyStructure.trim();
    }

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission == null ? null : typeTransmission.trim();
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

    public String getZbzl() {
        return zbzl;
    }

    public void setZbzl(String zbzl) {
        this.zbzl = zbzl;
    }

    public String getJyid() {
        return jyid;
    }

    public void setJyid(String jyid) {
        this.jyid = jyid;
    }

    public TieshangjCarAutoLogos getTieshangjCarAutoLogos() {
        return tieshangjCarAutoLogos;
    }

    public void setTieshangjCarAutoLogos(TieshangjCarAutoLogos tieshangjCarAutoLogos) {
        this.tieshangjCarAutoLogos = tieshangjCarAutoLogos;
    }

    public TieshangjCarVehicleSystem getTieshangjCarVehicleSystem() {
        return tieshangjCarVehicleSystem;
    }

    public void setTieshangjCarVehicleSystem(TieshangjCarVehicleSystem tieshangjCarVehicleSystem) {
        this.tieshangjCarVehicleSystem = tieshangjCarVehicleSystem;
    }

    public TieshangjCarBrand getTieshangjCarBrand() {
        return tieshangjCarBrand;
    }

    public void setTieshangjCarBrand(TieshangjCarBrand tieshangjCarBrand) {
        this.tieshangjCarBrand = tieshangjCarBrand;
    }

    public String getJyjson() {
        return jyjson;
    }

    public void setJyjson(String jyjson) {
        this.jyjson = jyjson;
    }

    public String getMergecode() {
        return mergecode;
    }

    public void setMergecode(String mergecode) {
        this.mergecode = mergecode;
    }
}