package com.tieshan.api.service.chegujiaService.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjProvinceInfo;

import java.util.List;

public interface TieshangjProvinceInfoService {
    //查询所有省份
    List<TieshangjProvinceInfo> selectAll();
}
