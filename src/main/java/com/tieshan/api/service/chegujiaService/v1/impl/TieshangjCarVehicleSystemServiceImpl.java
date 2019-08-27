package com.tieshan.api.service.chegujiaService.v1.impl;


import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarVehicleSystemMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarVehicleSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCarVehicleSystemServiceImpl implements TieshangjCarVehicleSystemService {
    @Autowired
    private TieshangjCarVehicleSystemMapper tieshangjCarVehicleSystemMapper;


    @Override
    public List<TieshangjCarVehicleSystem> selectBrandId(Integer brandId) {
        return tieshangjCarVehicleSystemMapper.selectBrandId(brandId);
    }
}
