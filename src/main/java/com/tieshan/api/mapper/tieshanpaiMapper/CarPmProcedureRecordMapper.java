package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmProcedureRecord;

public interface CarPmProcedureRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedureRecord record);

    int insertSelective(CarPmProcedureRecord record);

    CarPmProcedureRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedureRecord record);

    int updateByPrimaryKey(CarPmProcedureRecord record);
}