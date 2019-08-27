package com.tieshan.api.po.chegujiaPo.v1.bo;

import java.io.Serializable;

public class EncapsulationsBO implements Serializable {
    private String id;
    private String name ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
