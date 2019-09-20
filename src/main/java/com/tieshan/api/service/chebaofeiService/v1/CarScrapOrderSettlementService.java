package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderSettlementBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderSettlement;
import com.tieshan.api.service.BaseService;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:48
 */
public interface CarScrapOrderSettlementService extends BaseService<CarScrapOrderSettlement> {

    Integer saveCarScrapOrderSettlement(CarScrapOrderSettlement carScrapOrderSettlement)throws Exception;

    List<CarScrapOrderSettlementBO> getCarScrapOrderSettlementByOrderId(String orderid);
}
