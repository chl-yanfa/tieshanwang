package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleSecondAsk;

public interface CarPmAftersaleSecondAskMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleSecondAsk record);

    int insertSelective(CarPmAftersaleSecondAsk record);

    CarPmAftersaleSecondAsk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleSecondAsk record);

    int updateByPrimaryKey(CarPmAftersaleSecondAsk record);
}