package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarPieceMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarPiece;
import com.tieshan.api.service.chegujiaService.TieshangjCarPieceService;
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
