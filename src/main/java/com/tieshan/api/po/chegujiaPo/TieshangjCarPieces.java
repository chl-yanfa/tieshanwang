package com.tieshan.api.po.chegujiaPo;

import java.io.Serializable;
import java.util.Date;

public class TieshangjCarPieces implements Serializable {
    private Integer id;

    private Integer carPieceId;

    private String carModelTiema;

    private String oldMoney;

    private String demolitionMoney;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private TieshangjCarPiece tieshangjCarPiece;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarPieceId() {
        return carPieceId;
    }

    public void setCarPieceId(Integer carPieceId) {
        this.carPieceId = carPieceId;
    }

    public String getCarModelTiema() {
        return carModelTiema;
    }

    public void setCarModelTiema(String carModelTiema) {
        this.carModelTiema = carModelTiema == null ? null : carModelTiema.trim();
    }

    public String getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(String oldMoney) {
        this.oldMoney = oldMoney == null ? null : oldMoney.trim();
    }

    public String getDemolitionMoney() {
        return demolitionMoney;
    }

    public void setDemolitionMoney(String demolitionMoney) {
        this.demolitionMoney = demolitionMoney == null ? null : demolitionMoney.trim();
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

    public TieshangjCarPiece getTieshangjCarPiece() {
        return tieshangjCarPiece;
    }

    public void setTieshangjCarPiece(TieshangjCarPiece tieshangjCarPiece) {
        this.tieshangjCarPiece = tieshangjCarPiece;
    }
}