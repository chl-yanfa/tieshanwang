package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAuctionSet;

public interface CarPmAuctionSetMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAuctionSet record);

    int insertSelective(CarPmAuctionSet record);

    CarPmAuctionSet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAuctionSet record);

    int updateByPrimaryKey(CarPmAuctionSet record);
}