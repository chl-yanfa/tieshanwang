package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleAdjustPrice;

public interface CarPmAftersaleAdjustPriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleAdjustPrice record);

    int insertSelective(CarPmAftersaleAdjustPrice record);

    CarPmAftersaleAdjustPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleAdjustPrice record);

    int updateByPrimaryKey(CarPmAftersaleAdjustPrice record);
}