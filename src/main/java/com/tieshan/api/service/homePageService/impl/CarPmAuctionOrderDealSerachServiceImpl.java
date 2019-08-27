package com.tieshan.api.service.homePageService.impl;

import com.tieshan.api.mapper.homePageMapper.CarPmAuctionOrderDealSerachMapper;
import com.tieshan.api.po.homePagePo.bo.CarPmAuctionOrderDealSerach;
import com.tieshan.api.service.homePageService.CarPmAuctionOrderDealSerachService;
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
