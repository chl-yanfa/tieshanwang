package com.tieshan.api.service.tieshanpaiService.v1.auction;

import com.tieshan.api.bo.tieshanpaiBo.v1.CarPmAuctionBO;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmDeal;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.util.toolUtil.OrderByUtils;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmResultVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.StartVO;


import javax.servlet.http.HttpSession;
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

    ResultVO<OrderByUtils> getPaimaiListOrderBy(PaimaiVo paimai);

    ResultVO<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy);

    Map<String,List<CarPmResultVo>> getEndResult();

    Map<String,List<StartVO>> getStartTimeList();

    ResultVO<CarPmDeal> getPmOrderByMemberId(Integer page,Integer rows,String mid);

    ResultVO<String> addAuction(CarPmAuctionVo auction);

    List<CarPmAuctionBO> getAuctionState(String mid,String auctionState,String joinState);

    List<CarPmAuctionBO> getAuctionDetailByIdIsWait(String auctionId);
}
