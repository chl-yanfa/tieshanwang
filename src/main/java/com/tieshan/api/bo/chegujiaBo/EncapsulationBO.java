package com.tieshan.api.bo.chegujiaBo;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPieces;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
public class EncapsulationBO implements Serializable {
    private String type;

    private List<EncapsulationsBO> children = new ArrayList<EncapsulationsBO>();

    private List<TieshangjCarPieces> children2 = new ArrayList<TieshangjCarPieces>();
}
