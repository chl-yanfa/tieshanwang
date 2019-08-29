package com.tieshan.api.service.homePageService.v1.impl;

import com.tieshan.api.mapper.homePageMapper.v1.TbArticleMapper;
import com.tieshan.api.po.homePagePo.bo.v1.TbArticle;
import com.tieshan.api.service.homePageService.v1.TbArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TbArticleServiceImpl implements TbArticleService {
    @Autowired
    private TbArticleMapper tbArticleMapper;


    @Override
    public List<TbArticle> selectHomePage(Map map) {
        return tbArticleMapper.selectHomePage(map);
    }
}
