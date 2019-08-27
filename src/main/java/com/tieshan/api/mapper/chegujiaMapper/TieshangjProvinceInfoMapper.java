package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjProvinceInfo;

import java.util.List;

public interface TieshangjProvinceInfoMapper {
    int insert(TieshangjProvinceInfo record);

    int insertSelective(TieshangjProvinceInfo record);
    //查询所有省份
    List<TieshangjProvinceInfo> selectAll();
}