package com.tieshan.api.service.homePageService.impl;
import com.tieshan.api.mapper.homePageMapper.PaimaiMapper;
import com.tieshan.api.po.homePagePo.bo.PaimaiBO;
import com.tieshan.api.service.homePageService.PaimaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaimaiServiceImpl implements PaimaiService {
    @Autowired
    private PaimaiMapper paimaiMapper;
    @Override
    public List<PaimaiBO> queryList() {
        return paimaiMapper.queryList();
    }
}
