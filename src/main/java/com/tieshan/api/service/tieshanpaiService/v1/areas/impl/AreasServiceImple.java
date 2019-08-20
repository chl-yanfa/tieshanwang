package com.tieshan.api.service.tieshanpaiService.v1.areas.impl;

import com.tieshan.api.mapper.tieshanpaiMapper.v1.areas.AreasMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.areas.Areas;
import com.tieshan.api.service.tieshanpaiService.v1.areas.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 9:36
 */
@Service
public class AreasServiceImple implements AreasService {

    @Autowired
    AreasMapper areasMapper;

    @Override
    public List<Areas> getAreas() {
        return areasMapper.getAreas();
    }
}
