package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;

public class TieshangjProvinceInfo implements Serializable {
    private String provincecode;

    private String namecn;

    private String countrycode;

    private Integer sort;

    private static final long serialVersionUID = 1L;

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    public String getNamecn() {
        return namecn;
    }

    public void setNamecn(String namecn) {
        this.namecn = namecn == null ? null : namecn.trim();
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}