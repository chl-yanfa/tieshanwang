package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;

import java.util.List;

public interface TieshangjHistoryMapper {


    int insertSelective(TieshangjHistory record);

    TieshangjHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjHistory record);

    List<TieshangjHistory> selectAll();


}