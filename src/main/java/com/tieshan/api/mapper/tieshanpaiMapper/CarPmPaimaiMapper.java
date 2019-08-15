package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmPaimai;

public interface CarPmPaimaiMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmPaimai record);

    int insertSelective(CarPmPaimai record);

    CarPmPaimai selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmPaimai record);

    int updateByPrimaryKey(CarPmPaimai record);
}