package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWasteWeight;

public interface TieshangjCarWasteWeightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarWasteWeight record);

    int insertSelective(TieshangjCarWasteWeight record);

    TieshangjCarWasteWeight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarWasteWeight record);

    int updateByPrimaryKey(TieshangjCarWasteWeight record);
}