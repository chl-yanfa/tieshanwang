package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarRegionalArtificialMapper;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarRegionalArtificialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TieshangjCarRegionalArtificialServiceImpl implements TieshangjCarRegionalArtificialService {
    @Autowired
    private TieshangjCarRegionalArtificialMapper tieshangjCarRegionalArtificialMapper;
    @Override
    public String selectArtifi(String tiema, String pid) {
        return tieshangjCarRegionalArtificialMapper.selectArtifi(tiema,pid);
    }
}
