package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmWarehousePlacingAudit;

public interface CarPmWarehousePlacingAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmWarehousePlacingAudit record);

    int insertSelective(CarPmWarehousePlacingAudit record);

    CarPmWarehousePlacingAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmWarehousePlacingAudit record);

    int updateByPrimaryKey(CarPmWarehousePlacingAudit record);
}