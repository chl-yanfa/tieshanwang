package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPmAuctionMapper{

    List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction);

    Integer findAuctionTotal(CarPmAuctionVo auction);

    CarPmAuctionVo getAuctionInfo(String id);

    List<Paimai> getPaimaiListByPage(PaimaiVo paimai);

    int getPaimaiListTotal(PaimaiVo paimai);

    List<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy);
}