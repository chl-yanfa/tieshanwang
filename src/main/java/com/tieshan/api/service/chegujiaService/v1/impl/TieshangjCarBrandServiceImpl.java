package com.tieshan.api.service.chegujiaService.v1.impl;
import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarBrandMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarBrandService;
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
