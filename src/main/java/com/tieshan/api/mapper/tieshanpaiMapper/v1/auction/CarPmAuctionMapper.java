package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPmAuctionMapper{

    List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction);

    Integer findAuctionTotal(CarPmAuctionVo auction);

    CarPmAuctionVo getAuctionInfo(String id);
}