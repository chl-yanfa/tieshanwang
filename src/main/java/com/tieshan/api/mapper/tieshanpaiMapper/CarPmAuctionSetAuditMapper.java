package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAuctionSetAudit;

public interface CarPmAuctionSetAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionSetAudit record);

    int insertSelective(CarPmAuctionSetAudit record);

    CarPmAuctionSetAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionSetAudit record);

    int updateByPrimaryKey(CarPmAuctionSetAudit record);
}