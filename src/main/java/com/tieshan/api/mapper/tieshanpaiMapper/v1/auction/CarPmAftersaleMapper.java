package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersale;

public interface CarPmAftersaleMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersale record);

    int insertSelective(CarPmAftersale record);

    CarPmAftersale selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersale record);

    int updateByPrimaryKey(CarPmAftersale record);
}