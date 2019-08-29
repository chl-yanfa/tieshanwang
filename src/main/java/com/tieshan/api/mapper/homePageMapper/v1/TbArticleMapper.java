package com.tieshan.api.mapper.homePageMapper.v1;

import com.tieshan.api.po.homePagePo.bo.v1.TbArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TbArticle record);

    TbArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbArticle record);

    List<TbArticle> selectHomePage(Map map);

}