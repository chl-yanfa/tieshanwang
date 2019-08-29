package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarWasteMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarWasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCarWasteServiceImpl implements TieshangjCarWasteService {
    @Autowired
    private TieshangjCarWasteMapper tieshangjCarWasteMapper;
    @Override
    public List<TieshangjCarWaste> selectAll() {
        return tieshangjCarWasteMapper.selectAll();
    }

    @Override
    public TieshangjCarWaste selectByPrimaryKey(Integer id) {
        return tieshangjCarWasteMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TieshangjCarWaste record) {
        return tieshangjCarWasteMapper.updateByPrimaryKeySelective(record);
    }
}
