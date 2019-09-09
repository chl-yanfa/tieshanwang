package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarTrainCrew;

import java.util.List;
import java.util.Map;

public interface TieshangjCarTrainCrewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarTrainCrew record);

    int insertSelective(TieshangjCarTrainCrew record);

    TieshangjCarTrainCrew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarTrainCrew record);

    int updateByPrimaryKey(TieshangjCarTrainCrew record);

    List<TieshangjCarTrainCrew> selectAll(Map map);

    Integer selectAllCount(Map map);

    List<TieshangjCarTrainCrew> selectAll2(Map map);
}