package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmCustomerMarginWater;

public interface CarPmCustomerMarginWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmCustomerMarginWater record);

    int insertSelective(CarPmCustomerMarginWater record);

    CarPmCustomerMarginWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmCustomerMarginWater record);

    int updateByPrimaryKey(CarPmCustomerMarginWater record);
}