package com.tieshan.api.service.homePageService.v1.impl;

import com.tieshan.api.mapper.homePageMapper.v1.CarPmAuctionOrderDealSerachMapper;
import com.tieshan.api.po.homePagePo.bo.v1.CarPmAuctionOrderDealSerach;
import com.tieshan.api.service.homePageService.v1.CarPmAuctionOrderDealSerachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPmAuctionOrderDealSerachServiceImpl implements CarPmAuctionOrderDealSerachService {
    @Autowired
    private CarPmAuctionOrderDealSerachMapper carPmAuctionOrderDealSerachMapper;

    @Override
    public List<CarPmAuctionOrderDealSerach> queryListName(String name) {
        return carPmAuctionOrderDealSerachMapper.queryListName(name);
    }
}
