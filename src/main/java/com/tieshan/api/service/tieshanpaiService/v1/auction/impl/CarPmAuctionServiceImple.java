package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;

import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 11:41
 */
@Service
@Transactional
public class CarPmAuctionServiceImple implements CarPmAuctionService {

    @Autowired
    CarPmAuctionMapper carPmAuctionMapper;

    @Override
    public List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction) {
        return carPmAuctionMapper.findAuction(auction);
    }

    @Override
    public Integer findAuctionTotal(CarPmAuctionVo auction) {
        return carPmAuctionMapper.findAuctionTotal(auction);
    }

    @Override
    public ResultVO<CarPmAuctionVo> getAuctionInfo(String id) {

        ResultVO<CarPmAuctionVo> res = new ResultVO<CarPmAuctionVo>();

        CarPmAuctionVo auctionDto = carPmAuctionMapper.getAuctionInfo(id);
        if(auctionDto.getHighestPrice()==null){
            auctionDto.setHighestPrice(auctionDto.getHighestPrice());
        }
        BigDecimal totalPrice = new BigDecimal("0");
        BigDecimal highestPrice = auctionDto.getHighestPrice()==null?new BigDecimal("0"):auctionDto.getHighestPrice();
        BigDecimal commission = auctionDto.getCommission()==null?new BigDecimal("0"):auctionDto.getCommission();
        BigDecimal otherPrice = auctionDto.getOtherPrice()==null?new BigDecimal("0"):auctionDto.getOtherPrice();
        totalPrice=totalPrice.add(highestPrice)
                .add(commission)
                .add(otherPrice);
        auctionDto.setCommission(commission);
        auctionDto.setOtherPrice(otherPrice);
        auctionDto.setTotalPrice(totalPrice);
        res.setEntity(auctionDto);
        res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        res.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return res;
    }
}
