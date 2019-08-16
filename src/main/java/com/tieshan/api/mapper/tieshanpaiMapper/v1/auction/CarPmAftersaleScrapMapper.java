package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleScrap;

public interface CarPmAftersaleScrapMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleScrap record);

    int insertSelective(CarPmAftersaleScrap record);

    CarPmAftersaleScrap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleScrap record);

    int updateByPrimaryKey(CarPmAftersaleScrap record);
}