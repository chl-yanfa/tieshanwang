package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPmFile;

public interface NewPartsPmFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewPartsPmFile record);

    int insertSelective(NewPartsPmFile record);

    NewPartsPmFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewPartsPmFile record);

    int updateByPrimaryKey(NewPartsPmFile record);
}