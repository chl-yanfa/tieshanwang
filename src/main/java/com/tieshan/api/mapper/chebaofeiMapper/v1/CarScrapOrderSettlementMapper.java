package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderSettlementBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderSettlement;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:21
 */
@Repository
public interface CarScrapOrderSettlementMapper extends Mapper<CarScrapOrderSettlement> {
    List<CarScrapOrderSettlementBO> getCarScrapOrderSettlementByOrderId(String orderid);
    List<CarScrapOrderSettlementBO>  getCarScrapOrderOfOldSettlementByOrderId(String orderid);
}
