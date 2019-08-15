package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmProcedure;

public interface CarPmProcedureMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedure record);

    int insertSelective(CarPmProcedure record);

    CarPmProcedure selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedure record);

    int updateByPrimaryKey(CarPmProcedure record);
}