package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmProcedureFile;

public interface CarPmProcedureFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmProcedureFile record);

    int insertSelective(CarPmProcedureFile record);

    CarPmProcedureFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmProcedureFile record);

    int updateByPrimaryKey(CarPmProcedureFile record);
}