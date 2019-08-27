package com.tieshan.api.service.chegujiaService.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;

import java.util.List;

public interface TieshangjCarVehicleSystemService {
    //根据品牌id查询车系
    List<TieshangjCarVehicleSystem> selectBrandId(Integer brandId);
}
