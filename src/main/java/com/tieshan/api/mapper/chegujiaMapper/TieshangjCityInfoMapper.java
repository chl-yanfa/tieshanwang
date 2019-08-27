package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCityInfo;

import java.util.List;

public interface TieshangjCityInfoMapper {
    int insert(TieshangjCityInfo record);

    int insertSelective(TieshangjCityInfo record);
    //根据省份id查看城市
    List<TieshangjCityInfo> selectProvid(String Pid);
}