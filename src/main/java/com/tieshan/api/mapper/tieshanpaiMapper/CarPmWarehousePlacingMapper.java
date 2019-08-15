package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmWarehousePlacing;

public interface CarPmWarehousePlacingMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmWarehousePlacing record);

    int insertSelective(CarPmWarehousePlacing record);

    CarPmWarehousePlacing selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmWarehousePlacing record);

    int updateByPrimaryKey(CarPmWarehousePlacing record);
}