package com.tieshan.api.service.chegujiaService;

import com.tieshan.api.po.chegujiaPo.TieshangjCarPiece;

import java.util.List;

public interface TieshangjCarPieceService {
    //查询所有一级
    List<TieshangjCarPiece> selectYi(String levels);
}
