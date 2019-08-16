package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleTakeCarTrack;

public interface CarPmAftersaleTakeCarTrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleTakeCarTrack record);

    int insertSelective(CarPmAftersaleTakeCarTrack record);

    CarPmAftersaleTakeCarTrack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleTakeCarTrack record);

    int updateByPrimaryKey(CarPmAftersaleTakeCarTrack record);
}