package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleDefer;

public interface CarPmAftersaleDeferMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleDefer record);

    int insertSelective(CarPmAftersaleDefer record);

    CarPmAftersaleDefer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleDefer record);

    int updateByPrimaryKey(CarPmAftersaleDefer record);
}