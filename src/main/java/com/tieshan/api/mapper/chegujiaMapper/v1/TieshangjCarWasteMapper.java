package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;

import java.util.List;

public interface TieshangjCarWasteMapper {


    int insertSelective(TieshangjCarWaste record);

    TieshangjCarWaste selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarWaste record);

    List<TieshangjCarWaste> selectAll();


}