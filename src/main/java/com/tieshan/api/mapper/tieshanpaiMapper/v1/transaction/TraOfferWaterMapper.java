package com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction;

import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.TraOfferWaterVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.TraOrderVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 17:53
 */
@Repository
public interface TraOfferWaterMapper {

    //保存出价记录
    int createTraOfferWater(TraOfferWaterVo waterDto);

    //获取我对某个订单的最高价 -不区分报价和竞价
    int getMaxBidAmountByUser(TraOrderVo traOrder);

    //通过订单编号获取我的报价列表
    List<TraOfferWaterVo> getMyBidAmountListByCarCode(TraOrderVo traOrder);

    //查询用户对某个订单的出价金额
    List<TraOfferWaterVo> findBidAmountByUser(TraOrderVo traOrder);

    //查询用户对某个订单的竟价金额
    List<TraOrderVo> findComAmountByUser(TraOrderVo traOrder);

    //查询会员报价车辆列表
    List<TraOfferWaterVo> findOfferWaterByMember(TraOrderVo traOrder);

    //通过订单号查询流水信息
    List<TraOfferWaterVo> findTraOfferWaterByOrderId(String orderId);

    //车辆出价列表
    List<TraOfferWaterVo> findPriceList(Map<String, Object> data);

    //获取当前商户出过价的车辆总数
    Integer getMeberBidTotal(TraOfferWaterVo data);

    //查询用户对某个  车辆 的最高报价和竞价
    List<TraOfferWaterVo> getQuoteAndBidByCarCode(TraOfferWaterVo data);

    //车辆出价列表(优质车辆使用)
    List<TraOfferWaterVo> findPriceList2(Map<String, Object> data);

    //在流水表中获取我对某一辆车的报价列表
    List<TraOfferWaterVo> getMyCarQuotation(TraOrderVo traOrder);

    //出价前判断当前会员出价次数
    Integer getQuotePriceSize(TraOfferWaterVo waterDto);

    //查询最高价
    List<TraOfferWaterVo> findPriceListLook(Map<String, Object> data);
}
