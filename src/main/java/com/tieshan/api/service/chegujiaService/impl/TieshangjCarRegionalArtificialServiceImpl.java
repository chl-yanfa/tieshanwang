package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjCarRegionalArtificialMapper;
import com.tieshan.api.service.chegujiaService.TieshangjCarRegionalArtificialService;
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
