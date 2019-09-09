package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarTrainCrewMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarTrainCrew;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarTrainCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TieshangjCarTrainCrewServiceImpl implements TieshangjCarTrainCrewService {
    @Autowired
    private TieshangjCarTrainCrewMapper tieshangjCarTrainCrewMapper;
    @Override
    public List<TieshangjCarTrainCrew> selectAll(Map map) {
        return tieshangjCarTrainCrewMapper.selectAll(map);
    }

    @Override
    public Integer selectAllCount(Map map) {
        return tieshangjCarTrainCrewMapper.selectAllCount(map);
    }

    @Override
    public List<TieshangjCarTrainCrew> selectAll2(Map map) {
        return tieshangjCarTrainCrewMapper.selectAll2(map);
    }
}
