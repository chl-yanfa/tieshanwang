package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmWarehouse;

public interface CarPmWarehouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmWarehouse record);

    int insertSelective(CarPmWarehouse record);

    CarPmWarehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmWarehouse record);

    int updateByPrimaryKey(CarPmWarehouse record);
}