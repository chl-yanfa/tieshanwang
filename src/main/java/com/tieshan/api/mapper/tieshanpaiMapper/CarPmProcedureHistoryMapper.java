package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmProcedureHistory;

public interface CarPmProcedureHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedureHistory record);

    int insertSelective(CarPmProcedureHistory record);

    CarPmProcedureHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedureHistory record);

    int updateByPrimaryKey(CarPmProcedureHistory record);
}