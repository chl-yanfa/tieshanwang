package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleDefer;

public interface CarPmAftersaleDeferMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleDefer record);

    int insertSelective(CarPmAftersaleDefer record);

    CarPmAftersaleDefer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleDefer record);

    int updateByPrimaryKey(CarPmAftersaleDefer record);
}