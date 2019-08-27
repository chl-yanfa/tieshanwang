package com.tieshan.api.service.chegujiaService.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;

import java.util.List;

public interface TieshangjCarPieceService {
    //查询所有一级
    List<TieshangjCarPiece> selectYi(String levels);
}
