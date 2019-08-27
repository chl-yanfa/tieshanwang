package com.tieshan.api.service.chegujiaService.impl;

import com.tieshan.api.mapper.chegujiaMapper.TieshangjProvinceInfoMapper;
import com.tieshan.api.po.chegujiaPo.TieshangjProvinceInfo;
import com.tieshan.api.service.chegujiaService.TieshangjProvinceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjProvinceInfoServiceImpl implements TieshangjProvinceInfoService {
    @Autowired
    private TieshangjProvinceInfoMapper tieshangjProvinceInfoMapper;
    @Override
    public List<TieshangjProvinceInfo> selectAll() {
        return tieshangjProvinceInfoMapper.selectAll();
    }
}
