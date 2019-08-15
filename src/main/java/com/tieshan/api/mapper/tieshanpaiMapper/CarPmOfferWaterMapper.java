package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmOfferWater;

public interface CarPmOfferWaterMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmOfferWater record);

    int insertSelective(CarPmOfferWater record);

    CarPmOfferWater selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmOfferWater record);

    int updateByPrimaryKey(CarPmOfferWater record);
}