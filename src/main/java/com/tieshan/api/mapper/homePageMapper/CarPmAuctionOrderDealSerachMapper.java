package com.tieshan.api.mapper.homePageMapper;
import com.tieshan.api.po.homePagePo.bo.CarPmAuctionOrderDealSerach;
import java.util.List;

public interface CarPmAuctionOrderDealSerachMapper {
    List<CarPmAuctionOrderDealSerach> queryListName(String name);
}
