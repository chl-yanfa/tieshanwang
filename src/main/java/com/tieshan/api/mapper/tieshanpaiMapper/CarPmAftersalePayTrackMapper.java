package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersalePayTrack;

public interface CarPmAftersalePayTrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersalePayTrack record);

    int insertSelective(CarPmAftersalePayTrack record);

    CarPmAftersalePayTrack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersalePayTrack record);

    int updateByPrimaryKey(CarPmAftersalePayTrack record);
}