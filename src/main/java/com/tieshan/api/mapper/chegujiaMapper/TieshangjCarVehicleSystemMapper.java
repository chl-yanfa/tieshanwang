package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarVehicleSystem;

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