package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmOfferWater;

public interface CarPmOfferWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmOfferWater record);

    int insertSelective(CarPmOfferWater record);

    CarPmOfferWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmOfferWater record);

    int updateByPrimaryKey(CarPmOfferWater record);
}