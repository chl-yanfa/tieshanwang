package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarAutoLogosMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjCarAutoLogos;
import com.tieshan.api.service.chegujiaService.TieshangjCarAutoLogosService;
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
