package com.tieshan.api.service.tieshanpaiService.v1.transaction;

import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.tieshanpaiPo.v1.transaction.TraHighestBid;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.BidVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 19:03
 */
public interface BidService {

    ResultVO<String> bid(BidVo bidDto);

    ResultVO<String> bidCheck(BidVo bidDto, OrderInfoVo order);

    ResultVO<String> toBid(BidVo bidDto, OrderInfoVo order);

    String biePrice(BidVo bidDto, OrderInfoVo order);

    void customerMarginUnlock(BidVo bidDto, TraHighestBid highestBid);

    void cusCustomerMargin(BidVo bidDto);

    Integer getOrderEndTime(BidVo bidDto, String auctionModel, Integer surplusTime);

    void createTraOfferWater(BidVo bidDto);

    String setCometContent(BidVo bidDto, Integer endsecond, Integer platformCost);

}
