package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import java.io.Serializable;

public class ChlAutoLogos implements Serializable {
    private Integer autoLogosId;

    private String autoLogosName;

    private String autoLogosAlias;

    private static final long serialVersionUID = 1L;

    public Integer getAutoLogosId() {
        return autoLogosId;
    }

    public void setAutoLogosId(Integer autoLogosId) {
        this.autoLogosId = autoLogosId;
    }

    public String getAutoLogosName() {
        return autoLogosName;
    }

    public void setAutoLogosName(String autoLogosName) {
        this.autoLogosName = autoLogosName == null ? null : autoLogosName.trim();
    }

    public String getAutoLogosAlias() {
        return autoLogosAlias;
    }

    public void setAutoLogosAlias(String autoLogosAlias) {
        this.autoLogosAlias = autoLogosAlias == null ? null : autoLogosAlias.trim();
    }
}