package com.tieshan.api.mapper.homePageMapper;

import com.tieshan.api.po.homePagePo.bo.CarScrapOrderDealBO;

import java.util.List;

public interface CarScrapOrderDealMapper {
     List<CarScrapOrderDealBO> queryList();
     List<CarScrapOrderDealBO> queryListName(String modelName);
}
