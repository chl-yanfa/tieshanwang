package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersale;

public interface CarPmAftersaleMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersale record);

    int insertSelective(CarPmAftersale record);

    CarPmAftersale selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersale record);

    int updateByPrimaryKey(CarPmAftersale record);
}