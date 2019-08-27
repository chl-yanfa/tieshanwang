package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarModelMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.TieshangjCarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TieshangjCarModelServiceImpl implements TieshangjCarModelService {
    @Autowired
    private TieshangjCarModelMapper tieshangjCarModelMapper;
    @Override
    public List<TieshangjCarModel> selectCheXiId(Integer chexiId) {
        return tieshangjCarModelMapper.selectCheXiId(chexiId);
    }

    @Override
    public List<TieshangjCarModel> selectAll(Map map) {
        return tieshangjCarModelMapper.selectAll(map);
    }

    @Override
    public Integer selectAllCount(Map map) {
        return tieshangjCarModelMapper.selectAllCount(map);
    }


}
