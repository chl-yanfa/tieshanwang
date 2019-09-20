package com.tieshan.api.service.homePageService.v1.impl;
import com.tieshan.api.mapper.homePageMapper.v1.PaimaiMapper;
import com.tieshan.api.bo.homePageBo.PaimaiBO;
import com.tieshan.api.service.homePageService.v1.PaimaiService;
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
