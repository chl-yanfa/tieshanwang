package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmFinancePayWater;

public interface CarPmFinancePayWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmFinancePayWater record);

    int insertSelective(CarPmFinancePayWater record);

    CarPmFinancePayWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmFinancePayWater record);

    int updateByPrimaryKey(CarPmFinancePayWater record);
}