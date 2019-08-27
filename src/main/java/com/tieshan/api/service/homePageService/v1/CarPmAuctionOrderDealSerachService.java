package com.tieshan.api.service.homePageService.v1;

import com.tieshan.api.po.homePagePo.bo.v1.CarPmAuctionOrderDealSerach;

import java.util.List;

public interface CarPmAuctionOrderDealSerachService {
    List<CarPmAuctionOrderDealSerach> queryListName(String name);
}
