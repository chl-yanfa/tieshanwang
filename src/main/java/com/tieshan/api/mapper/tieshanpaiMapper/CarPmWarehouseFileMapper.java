package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmWarehouseFile;

public interface CarPmWarehouseFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmWarehouseFile record);

    int insertSelective(CarPmWarehouseFile record);

    CarPmWarehouseFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmWarehouseFile record);

    int updateByPrimaryKey(CarPmWarehouseFile record);
}