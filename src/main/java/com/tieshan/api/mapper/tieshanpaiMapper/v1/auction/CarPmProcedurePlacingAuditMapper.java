package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmProcedurePlacingAudit;

public interface CarPmProcedurePlacingAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmProcedurePlacingAudit record);

    int insertSelective(CarPmProcedurePlacingAudit record);

    CarPmProcedurePlacingAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmProcedurePlacingAudit record);

    int updateByPrimaryKey(CarPmProcedurePlacingAudit record);
}