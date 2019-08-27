package com.tieshan.api.service.homePageService.impl;

import com.tieshan.api.mapper.homePageMapper.TbVersionMapper;
import com.tieshan.api.po.homePagePo.bo.TbVersion;
import com.tieshan.api.service.homePageService.TbVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbVersionServiceImpl implements TbVersionService {
    @Autowired
    private TbVersionMapper tbVersionMapperl;

    @Override
    public TbVersion selectByPrimaryKey(Integer oc) {
        return tbVersionMapperl.selectByPrimaryKey(oc);
    }
}
