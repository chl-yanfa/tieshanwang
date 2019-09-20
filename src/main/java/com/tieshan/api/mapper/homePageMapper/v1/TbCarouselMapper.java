package com.tieshan.api.mapper.homePageMapper.v1;

import com.tieshan.api.po.homePagePo.bo.v1.TbCarousel;

import java.util.List;
import java.util.Map;

public interface TbCarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCarousel record);

    int insertSelective(TbCarousel record);

    TbCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCarousel record);

    int updateByPrimaryKey(TbCarousel record);

    List<TbCarousel> select(Map map);
}