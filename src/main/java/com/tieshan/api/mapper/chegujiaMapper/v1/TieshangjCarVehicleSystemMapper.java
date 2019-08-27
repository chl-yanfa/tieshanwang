package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;

import java.util.List;

public interface TieshangjCarVehicleSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarVehicleSystem record);

    int insertSelective(TieshangjCarVehicleSystem record);

    TieshangjCarVehicleSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarVehicleSystem record);

    int updateByPrimaryKey(TieshangjCarVehicleSystem record);
    //根据品牌id查询车系
    List<TieshangjCarVehicleSystem> selectBrandId(Integer brandId);
}