package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleFile;

public interface CarPmAftersaleFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmAftersaleFile record);

    int insertSelective(CarPmAftersaleFile record);

    CarPmAftersaleFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmAftersaleFile record);

    int updateByPrimaryKey(CarPmAftersaleFile record);
}