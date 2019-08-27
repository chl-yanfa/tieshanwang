package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;

public class TieshangjCityInfo implements Serializable {
    private Integer citycode;

    private Integer sort;

    private Integer provincecode;

    private String cityNamecn;

    private static final long serialVersionUID = 1L;

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(Integer provincecode) {
        this.provincecode = provincecode;
    }

    public String getCityNamecn() {
        return cityNamecn;
    }

    public void setCityNamecn(String cityNamecn) {
        this.cityNamecn = cityNamecn == null ? null : cityNamecn.trim();
    }
}