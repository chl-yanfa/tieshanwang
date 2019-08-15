package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmCustomerMarginWater;

public interface CarPmCustomerMarginWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmCustomerMarginWater record);

    int insertSelective(CarPmCustomerMarginWater record);

    CarPmCustomerMarginWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmCustomerMarginWater record);

    int updateByPrimaryKey(CarPmCustomerMarginWater record);
}