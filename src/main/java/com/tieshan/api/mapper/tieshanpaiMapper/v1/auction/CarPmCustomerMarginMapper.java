package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmCustomerMargin;

public interface CarPmCustomerMarginMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmCustomerMargin record);

    int insertSelective(CarPmCustomerMargin record);

    CarPmCustomerMargin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmCustomerMargin record);

    int updateByPrimaryKey(CarPmCustomerMargin record);
}