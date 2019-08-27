package com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction;

import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.BidVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 17:26
 */
@Repository
public interface BidMapper {

    OrderInfoVo getOrderInfo(BidVo bidDto);

    OrderInfoVo getOrderInfoResultByWS(@Param("auctionNo")String auctionNo);
}
