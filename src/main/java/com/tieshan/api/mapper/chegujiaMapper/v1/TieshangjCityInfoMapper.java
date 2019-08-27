package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCityInfo;

import java.util.List;

public interface TieshangjCityInfoMapper {
    int insert(TieshangjCityInfo record);

    int insertSelective(TieshangjCityInfo record);
    //根据省份id查看城市
    List<TieshangjCityInfo> selectProvid(String Pid);
}