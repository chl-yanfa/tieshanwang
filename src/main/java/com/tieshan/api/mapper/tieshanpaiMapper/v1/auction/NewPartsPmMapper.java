package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPm;

public interface NewPartsPmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewPartsPm record);

    int insertSelective(NewPartsPm record);

    NewPartsPm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewPartsPm record);

    int updateByPrimaryKey(NewPartsPm record);
}