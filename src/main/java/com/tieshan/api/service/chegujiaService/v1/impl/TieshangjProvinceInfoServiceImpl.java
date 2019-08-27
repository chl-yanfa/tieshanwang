package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjProvinceInfoMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjProvinceInfo;
import com.tieshan.api.service.chegujiaService.v1.TieshangjProvinceInfoService;
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
