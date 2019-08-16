package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAuctionSetAudit;

public interface CarPmAuctionSetAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionSetAudit record);

    int insertSelective(CarPmAuctionSetAudit record);

    CarPmAuctionSetAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionSetAudit record);

    int updateByPrimaryKey(CarPmAuctionSetAudit record);
}