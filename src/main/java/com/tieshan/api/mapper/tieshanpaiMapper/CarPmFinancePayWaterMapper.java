package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmFinancePayWater;

public interface CarPmFinancePayWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmFinancePayWater record);

    int insertSelective(CarPmFinancePayWater record);

    CarPmFinancePayWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmFinancePayWater record);

    int updateByPrimaryKey(CarPmFinancePayWater record);
}