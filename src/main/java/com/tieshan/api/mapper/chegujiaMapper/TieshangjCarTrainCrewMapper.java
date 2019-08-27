package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarTrainCrew;

public interface TieshangjCarTrainCrewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarTrainCrew record);

    int insertSelective(TieshangjCarTrainCrew record);

    TieshangjCarTrainCrew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarTrainCrew record);

    int updateByPrimaryKey(TieshangjCarTrainCrew record);
}