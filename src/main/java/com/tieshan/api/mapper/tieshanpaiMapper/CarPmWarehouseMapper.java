package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmWarehouse;

public interface CarPmWarehouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmWarehouse record);

    int insertSelective(CarPmWarehouse record);

    CarPmWarehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmWarehouse record);

    int updateByPrimaryKey(CarPmWarehouse record);
}