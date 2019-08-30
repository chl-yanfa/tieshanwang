package com.tieshan.api.service.homePageService.v1;

import com.tieshan.api.po.homePagePo.bo.v1.TbArticle;

import java.util.List;
import java.util.Map;

public interface TbArticleService {
    List<TbArticle> selectHomePage(Map map);
    TbArticle selectByPrimaryKey(Integer id);
}
