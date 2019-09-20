package com.tieshan.api.mapper.homePageMapper.v1;
import com.tieshan.api.po.homePagePo.v1.CarPmAuctionOrderDealSerach;

import java.util.List;

public interface CarPmAuctionOrderDealSerachMapper {
    List<CarPmAuctionOrderDealSerach> queryListName(String name);
}
