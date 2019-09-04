package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;
import java.util.Date;

public class TieshangjHistory implements Serializable {
    private Integer id;

    private String createBy;

    private Date createTime;

    private String type;

    private String fruit;

    private String factors;

    private String carModelName;

    private String tu;

    private String jyid;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit == null ? null : fruit.trim();
    }

    public String getFactors() {
        return factors;
    }

    public void setFactors(String factors) {
        this.factors = factors == null ? null : factors.trim();
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName == null ? null : carModelName.trim();
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu == null ? null : tu.trim();
    }

    public String getJyid() {
        return jyid;
    }

    public void setJyid(String jyid) {
        this.jyid = jyid;
    }
}