package com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction;

import com.tieshan.api.po.tieshanpaiPo.v1.transaction.TraHighestBid;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 17:44
 */
@Repository
public interface TraHighestBidMapper {

    TraHighestBid getTraHighestBidByCar(TraHighestBid traHighestBid);

    int updateTraHighestBidByCar(TraHighestBid parentOrderTraHighest);

    int createTraHighestBid(TraHighestBid traHighestBid);

    List<TraHighestBid> getNotThaw(Map<String,Object> data);

    Integer getNotThawCount(Map<String,Object> data);
}
