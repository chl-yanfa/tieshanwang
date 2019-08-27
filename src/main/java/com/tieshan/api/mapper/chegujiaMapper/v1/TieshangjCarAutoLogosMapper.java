package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarAutoLogos;

import java.util.List;

public interface TieshangjCarAutoLogosMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TieshangjCarAutoLogos record);

    TieshangjCarAutoLogos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarAutoLogos record);
    //查询所有车标
    List<TieshangjCarAutoLogos> selectAll();
}