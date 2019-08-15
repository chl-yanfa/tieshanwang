package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmScrap;

public interface CarPmScrapMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmScrap record);

    int insertSelective(CarPmScrap record);

    CarPmScrap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmScrap record);

    int updateByPrimaryKey(CarPmScrap record);
}