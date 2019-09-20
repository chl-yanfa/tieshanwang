package com.tieshan.api.service.homePageService.v1.impl;

import com.tieshan.api.mapper.homePageMapper.v1.TbCarouselMapper;
import com.tieshan.api.po.homePagePo.v1.TbCarousel;
import com.tieshan.api.service.homePageService.v1.TbCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TbCarouselServiceImpl implements TbCarouselService {
    @Autowired
    private TbCarouselMapper tbCarouselMapper;

    @Override
    public List<TbCarousel> select(Map map) {
        return tbCarouselMapper.select(map);
    }
}
