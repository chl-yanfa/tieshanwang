package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleAdjustPrice;

public interface CarPmAftersaleAdjustPriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleAdjustPrice record);

    int insertSelective(CarPmAftersaleAdjustPrice record);

    CarPmAftersaleAdjustPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleAdjustPrice record);

    int updateByPrimaryKey(CarPmAftersaleAdjustPrice record);
}