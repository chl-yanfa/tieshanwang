package com.tieshan.api.service.homePageService.v1.impl;

import com.tieshan.api.mapper.homePageMapper.v1.CarScrapOrderDealMapper;
import com.tieshan.api.po.homePagePo.bo.v1.CarScrapOrderDealBO;
import com.tieshan.api.service.homePageService.v1.CarScrapOrderDealService;
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
