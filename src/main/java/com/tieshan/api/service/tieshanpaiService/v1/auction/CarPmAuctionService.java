package com.tieshan.api.service.tieshanpaiService.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmDeal;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmResultVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.StartVO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 11:39
 */
public interface CarPmAuctionService {

    List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction);

    Integer findAuctionTotal(CarPmAuctionVo auction);

    ResultVO<CarPmAuctionVo> getAuctionInfo(String id);

    ResultVO<Paimai> getPaimaiList(PaimaiVo paimai);

    ResultVO<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy);

    Map<String,List<CarPmResultVo>> getEndResult();

    Map<String,List<StartVO>> getStartTimeList();

    ResultVO<CarPmDeal> getPmOrderByMemberId(Integer page,Integer rows,String mid);
}
