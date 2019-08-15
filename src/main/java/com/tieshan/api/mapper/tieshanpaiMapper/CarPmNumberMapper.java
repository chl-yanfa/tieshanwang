package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmNumber;

public interface CarPmNumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmNumber record);

    int insertSelective(CarPmNumber record);

    CarPmNumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmNumber record);

    int updateByPrimaryKey(CarPmNumber record);
}