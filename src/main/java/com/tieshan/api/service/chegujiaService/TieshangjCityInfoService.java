package com.tieshan.api.service.chegujiaService;

import com.tieshan.api.po.chegujiaPo.TieshangjCityInfo;

import java.util.List;

public interface TieshangjCityInfoService {
    //根据省份id查看城市
    List<TieshangjCityInfo> selectProvid(String Pid);
}
