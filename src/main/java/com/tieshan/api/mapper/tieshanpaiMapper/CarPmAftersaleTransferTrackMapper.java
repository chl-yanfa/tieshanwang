package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleTransferTrack;

public interface CarPmAftersaleTransferTrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleTransferTrack record);

    int insertSelective(CarPmAftersaleTransferTrack record);

    CarPmAftersaleTransferTrack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleTransferTrack record);

    int updateByPrimaryKey(CarPmAftersaleTransferTrack record);
}