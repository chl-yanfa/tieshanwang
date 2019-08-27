package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;

public interface TieshangjCarWasteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarWaste record);

    int insertSelective(TieshangjCarWaste record);

    TieshangjCarWaste selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarWaste record);

    int updateByPrimaryKey(TieshangjCarWaste record);
}