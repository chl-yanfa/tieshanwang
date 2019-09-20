package com.tieshan.api.service.homePageService.v1;

import com.tieshan.api.po.homePagePo.bo.v1.TbCarousel;

import java.util.List;
import java.util.Map;

public interface TbCarouselService {
    List<TbCarousel> select(Map map);
}
