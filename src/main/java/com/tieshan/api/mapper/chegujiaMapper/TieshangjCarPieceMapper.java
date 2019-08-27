package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarPiece;

import java.util.List;

public interface TieshangjCarPieceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarPiece record);

    int insertSelective(TieshangjCarPiece record);

    TieshangjCarPiece selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarPiece record);

    int updateByPrimaryKey(TieshangjCarPiece record);
    //查询所有一级
    List<TieshangjCarPiece> selectYi(String levels);
}