package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleSecondAsk;

public interface CarPmAftersaleSecondAskMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleSecondAsk record);

    int insertSelective(CarPmAftersaleSecondAsk record);

    CarPmAftersaleSecondAsk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleSecondAsk record);

    int updateByPrimaryKey(CarPmAftersaleSecondAsk record);
}