package com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction;

import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.TraOrderVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 17:28
 */
@Repository
public interface TraIndentMapper {

    List<TraOrderVo> findTraOrder(TraOrderVo traOrder);

    Integer findTraOrderTotal(TraOrderVo traOrder);

    List<TraOrderVo> findMyOrderList(Map<String,Object> data);

    Integer getMyOrdersCount(Map<String,Object> data);

    Integer updateTraIndentMinutes(TraOrderVo traOrder);

    TraOrderVo getTraOrderById(String id);

    Integer updateTraOrderState(Map<String, Object> conditions);
}
