package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.ExceljyidMapper;
import com.tieshan.api.po.chegujiaPo.v1.Exceljyid;
import com.tieshan.api.service.chegujiaService.v1.ExceljyidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceljyidServiceImpl implements ExceljyidService {
    @Autowired
    private ExceljyidMapper exceljyidMapper;
    @Override
    public Exceljyid selectByJyid(String jyid) {
        return exceljyidMapper.selectByJyid(jyid);
    }
}
