package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmProcedurePlacingAudit;

public interface CarPmProcedurePlacingAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedurePlacingAudit record);

    int insertSelective(CarPmProcedurePlacingAudit record);

    CarPmProcedurePlacingAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedurePlacingAudit record);

    int updateByPrimaryKey(CarPmProcedurePlacingAudit record);
}