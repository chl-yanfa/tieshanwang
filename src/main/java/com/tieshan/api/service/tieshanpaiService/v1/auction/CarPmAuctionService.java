package com.tieshan.api.service.tieshanpaiService.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 11:39
 */
public interface CarPmAuctionService {

    List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction);

    Integer findAuctionTotal(CarPmAuctionVo auction);

    ResultVO<CarPmAuctionVo> getAuctionInfo(String id);
}
