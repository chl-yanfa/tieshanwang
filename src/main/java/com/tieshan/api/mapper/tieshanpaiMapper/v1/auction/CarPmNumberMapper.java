package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmNumber;

public interface CarPmNumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmNumber record);

    int insertSelective(CarPmNumber record);

    CarPmNumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmNumber record);

    int updateByPrimaryKey(CarPmNumber record);
}