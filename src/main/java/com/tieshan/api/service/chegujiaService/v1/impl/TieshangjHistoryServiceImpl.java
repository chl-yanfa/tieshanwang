package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjHistoryMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;
import com.tieshan.api.service.chegujiaService.v1.TieshangjHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjHistoryServiceImpl implements TieshangjHistoryService {
    @Autowired
    private TieshangjHistoryMapper tieshangjHistoryMapper;
    @Override
    public int insertSelective(TieshangjHistory record) {
        return tieshangjHistoryMapper.insertSelective(record);
    }

    @Override
    public List<TieshangjHistory> selectAll() {
        return tieshangjHistoryMapper.selectAll();
    }
}
