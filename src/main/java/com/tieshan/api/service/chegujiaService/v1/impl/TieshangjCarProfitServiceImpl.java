package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarProfitMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TieshangjCarProfitServiceImpl implements TieshangjCarProfitService {
    @Autowired
    private TieshangjCarProfitMapper tieshangjCarProfitMapper;
    @Override
    public TieshangjCarProfit selectLiRun(String tiema) {
        return tieshangjCarProfitMapper.selectLiRun(tiema);
    }
}
