package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;

public interface TieshangjHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjHistory record);

    int insertSelective(TieshangjHistory record);

    TieshangjHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjHistory record);

    int updateByPrimaryKey(TieshangjHistory record);
}