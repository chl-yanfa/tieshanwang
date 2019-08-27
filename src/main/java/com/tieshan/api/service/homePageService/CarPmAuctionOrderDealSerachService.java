package com.tieshan.api.service.homePageService;

import com.tieshan.api.po.homePagePo.bo.CarPmAuctionOrderDealSerach;

import java.util.List;

public interface CarPmAuctionOrderDealSerachService {
    List<CarPmAuctionOrderDealSerach> queryListName(String name);
}
