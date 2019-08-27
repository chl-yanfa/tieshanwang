package com.tieshan.api.service.homePageService.impl;

import com.tieshan.api.mapper.homePageMapper.CarScrapOrderDealMapper;
import com.tieshan.api.po.homePagePo.bo.CarScrapOrderDealBO;
import com.tieshan.api.service.homePageService.CarScrapOrderDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarScrapOrderDealServiceImpl implements CarScrapOrderDealService {
    @Autowired
    private CarScrapOrderDealMapper carScrapOrderDealMapper;
    @Override
    public List<CarScrapOrderDealBO> queryList() {
        return carScrapOrderDealMapper.queryList();
    }

    @Override
    public List<CarScrapOrderDealBO> queryListName(String modelName) {
        return carScrapOrderDealMapper.queryListName(modelName);
    }


}
