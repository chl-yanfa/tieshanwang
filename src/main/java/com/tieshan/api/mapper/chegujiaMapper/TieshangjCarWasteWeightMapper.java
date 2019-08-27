package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarWasteWeight;

public interface TieshangjCarWasteWeightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarWasteWeight record);

    int insertSelective(TieshangjCarWasteWeight record);

    TieshangjCarWasteWeight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarWasteWeight record);

    int updateByPrimaryKey(TieshangjCarWasteWeight record);
}