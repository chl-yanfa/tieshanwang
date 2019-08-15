package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleBackCar;

public interface CarPmAftersaleBackCarMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleBackCar record);

    int insertSelective(CarPmAftersaleBackCar record);

    CarPmAftersaleBackCar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleBackCar record);

    int updateByPrimaryKey(CarPmAftersaleBackCar record);
}