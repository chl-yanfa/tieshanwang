package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarProfitMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarProfit;
import com.tieshan.api.service.chegujiaService.TieshangjCarProfitService;
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
