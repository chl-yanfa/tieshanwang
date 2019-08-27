package com.tieshan.api.po.homePagePo.bo;

import java.io.Serializable;
import java.util.Date;

public class CarPmAuctionOrderDealSerach implements Serializable {
    private String id;

    private String name;

    private String imgpath;

    private String type;

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

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}