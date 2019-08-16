package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmProcedureHistory;

public interface CarPmProcedureHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedureHistory record);

    int insertSelective(CarPmProcedureHistory record);

    CarPmProcedureHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedureHistory record);

    int updateByPrimaryKey(CarPmProcedureHistory record);
}