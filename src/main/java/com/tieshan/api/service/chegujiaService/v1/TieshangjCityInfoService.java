package com.tieshan.api.service.chegujiaService.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCityInfo;

import java.util.List;

public interface TieshangjCityInfoService {
    //根据省份id查看城市
    List<TieshangjCityInfo> selectProvid(String Pid);
}
