package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarVehicleSystemMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarVehicleSystem;
import com.tieshan.api.service.chegujiaService.TieshangjCarVehicleSystemService;
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
