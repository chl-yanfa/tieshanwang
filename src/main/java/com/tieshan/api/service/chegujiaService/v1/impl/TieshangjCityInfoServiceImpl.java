package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCityInfoMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCityInfo;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TieshangjCityInfoServiceImpl implements TieshangjCityInfoService {
    @Autowired
    private TieshangjCityInfoMapper tieshangjCityInfoMapper;
    @Override
    public List<TieshangjCityInfo> selectProvid(String Pid) {
        return tieshangjCityInfoMapper.selectProvid(Pid);
    }
}
