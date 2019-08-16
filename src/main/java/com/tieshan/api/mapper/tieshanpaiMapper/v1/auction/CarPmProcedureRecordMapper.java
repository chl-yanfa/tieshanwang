package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmProcedureRecord;

public interface CarPmProcedureRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedureRecord record);

    int insertSelective(CarPmProcedureRecord record);

    CarPmProcedureRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedureRecord record);

    int updateByPrimaryKey(CarPmProcedureRecord record);
}