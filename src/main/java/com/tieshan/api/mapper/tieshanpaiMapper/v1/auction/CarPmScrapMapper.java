package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmScrap;

public interface CarPmScrapMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmScrap record);

    int insertSelective(CarPmScrap record);

    CarPmScrap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmScrap record);

    int updateByPrimaryKey(CarPmScrap record);
}