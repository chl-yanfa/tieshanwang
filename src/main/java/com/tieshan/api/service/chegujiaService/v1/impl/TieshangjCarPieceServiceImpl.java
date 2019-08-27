package com.tieshan.api.service.chegujiaService.v1.impl;
import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarPieceMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCarPieceServiceImpl implements TieshangjCarPieceService {
    @Autowired
    private TieshangjCarPieceMapper tieshangjCarPieceMapper;

    @Override
    public List<TieshangjCarPiece> selectYi(String levels) {
        return tieshangjCarPieceMapper.selectYi(levels);
    }
}
