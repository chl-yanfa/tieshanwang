package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;

import java.util.List;

public interface TieshangjCarPieceMapper {


    int insertSelective(TieshangjCarPiece record);

    TieshangjCarPiece selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarPiece record);


    //查询所有一级
    List<TieshangjCarPiece> selectYi(String levels);
}