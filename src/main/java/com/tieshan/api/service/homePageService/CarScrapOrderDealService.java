package com.tieshan.api.service.homePageService;

import com.tieshan.api.po.homePagePo.bo.CarScrapOrderDealBO;

import java.util.List;

public interface CarScrapOrderDealService {
    public List<CarScrapOrderDealBO> queryList();
    List<CarScrapOrderDealBO> queryListName(String modelName);
}
