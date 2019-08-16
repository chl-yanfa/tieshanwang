package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleBackCar;

public interface CarPmAftersaleBackCarMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleBackCar record);

    int insertSelective(CarPmAftersaleBackCar record);

    CarPmAftersaleBackCar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleBackCar record);

    int updateByPrimaryKey(CarPmAftersaleBackCar record);
}