package com.tieshan.api.service.chegujiaService;

import com.tieshan.api.po.chegujiaPo.TieshangjCarVehicleSystem;

import java.util.List;

public interface TieshangjCarVehicleSystemService {
    //根据品牌id查询车系
    List<TieshangjCarVehicleSystem> selectBrandId(Integer brandId);
}
