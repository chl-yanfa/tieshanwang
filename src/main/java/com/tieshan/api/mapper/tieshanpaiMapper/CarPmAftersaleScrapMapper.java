package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleScrap;

public interface CarPmAftersaleScrapMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleScrap record);

    int insertSelective(CarPmAftersaleScrap record);

    CarPmAftersaleScrap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleScrap record);

    int updateByPrimaryKey(CarPmAftersaleScrap record);
}