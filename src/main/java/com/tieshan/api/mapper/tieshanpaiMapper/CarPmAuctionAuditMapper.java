package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAuctionAudit;

public interface CarPmAuctionAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionAudit record);

    int insertSelective(CarPmAuctionAudit record);

    CarPmAuctionAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionAudit record);

    int updateByPrimaryKey(CarPmAuctionAudit record);
}