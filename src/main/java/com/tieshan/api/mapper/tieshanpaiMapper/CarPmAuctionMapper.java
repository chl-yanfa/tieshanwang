package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAuction;
import com.tieshan.api.po.tieshanpaiPo.CarPmAuctionWithBLOBs;

public interface CarPmAuctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionWithBLOBs record);

    int insertSelective(CarPmAuctionWithBLOBs record);

    CarPmAuctionWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CarPmAuctionWithBLOBs record);

    int updateByPrimaryKey(CarPmAuction record);
}