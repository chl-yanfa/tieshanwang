package com.tieshan.api.service.homePageService.v1.impl;
import com.tieshan.api.mapper.homePageMapper.v1.TbVersionMapper;
import com.tieshan.api.po.homePagePo.v1.TbVersion;
import com.tieshan.api.service.homePageService.v1.TbVersionService;
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
