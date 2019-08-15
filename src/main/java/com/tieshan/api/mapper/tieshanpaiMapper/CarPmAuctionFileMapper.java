package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAuctionFile;

public interface CarPmAuctionFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmAuctionFile record);

    int insertSelective(CarPmAuctionFile record);

    CarPmAuctionFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmAuctionFile record);

    int updateByPrimaryKey(CarPmAuctionFile record);
}