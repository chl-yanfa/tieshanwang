package com.tieshan.api.po.chegujiaPo.v1;

import java.io.Serializable;

public class Exceljyid implements Serializable {
    private Integer id;

    private String jyid;

    private String tiema;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJyid() {
        return jyid;
    }

    public void setJyid(String jyid) {
        this.jyid = jyid == null ? null : jyid.trim();
    }

    public String getTiema() {
        return tiema;
    }

    public void setTiema(String tiema) {
        this.tiema = tiema == null ? null : tiema.trim();
    }
}