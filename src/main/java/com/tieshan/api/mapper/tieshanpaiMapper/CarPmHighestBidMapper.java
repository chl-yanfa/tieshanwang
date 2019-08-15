package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmHighestBid;

public interface CarPmHighestBidMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmHighestBid record);

    int insertSelective(CarPmHighestBid record);

    CarPmHighestBid selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmHighestBid record);

    int updateByPrimaryKey(CarPmHighestBid record);
}