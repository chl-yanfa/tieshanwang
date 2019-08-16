package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleTransferTrack;

public interface CarPmAftersaleTransferTrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleTransferTrack record);

    int insertSelective(CarPmAftersaleTransferTrack record);

    CarPmAftersaleTransferTrack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleTransferTrack record);

    int updateByPrimaryKey(CarPmAftersaleTransferTrack record);
}