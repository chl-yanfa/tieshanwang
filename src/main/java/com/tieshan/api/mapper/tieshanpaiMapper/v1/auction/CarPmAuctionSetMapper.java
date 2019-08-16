package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAuctionSet;

public interface CarPmAuctionSetMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionSet record);

    int insertSelective(CarPmAuctionSet record);

    CarPmAuctionSet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionSet record);

    int updateByPrimaryKey(CarPmAuctionSet record);
}