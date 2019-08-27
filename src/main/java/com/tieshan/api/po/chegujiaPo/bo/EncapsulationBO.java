package com.tieshan.api.po.chegujiaPo.bo;

import com.tieshan.api.po.chegujiaPo.TieshangjCarPieces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EncapsulationBO implements Serializable {
    private String type;

    private List<EncapsulationsBO> children = new ArrayList<EncapsulationsBO>();
    private List<TieshangjCarPieces> children2 = new ArrayList<TieshangjCarPieces>();
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EncapsulationsBO> getChildren() {
        return children;
    }

    public void setChildren(List<EncapsulationsBO> children) {
        this.children = children;
    }

    public List<TieshangjCarPieces> getChildren2() {
        return children2;
    }

    public void setChildren2(List<TieshangjCarPieces> children2) {
        this.children2 = children2;
    }
}
