package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarBrandMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarBrand;
import com.tieshan.api.service.chegujiaService.TieshangjCarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCarBrandServiceImpl implements TieshangjCarBrandService {
    @Autowired
    private TieshangjCarBrandMapper tieshangjCarBrandMapper;


    @Override
    public List<TieshangjCarBrand> selectCBId(Integer ALId) {
        return tieshangjCarBrandMapper.selectCBId(ALId);
    }
}
