package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarAutoLogosMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarAutoLogos;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarAutoLogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCarAutoLogosServiceImpl implements TieshangjCarAutoLogosService {
    @Autowired
    private TieshangjCarAutoLogosMapper tieshangjCarAutoLogosMapper;
    @Override
    public List<TieshangjCarAutoLogos> selectAll() {
        return tieshangjCarAutoLogosMapper.selectAll();
    }
}
