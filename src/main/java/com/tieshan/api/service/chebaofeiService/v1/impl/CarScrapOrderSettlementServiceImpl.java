package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderSettlementBO;
import com.tieshan.api.common.chebaofeiCommon.CommonSystemParamter;
import com.tieshan.api.common.chebaofeiCommon.Exception.SettlementAmountException;
import com.tieshan.api.mapper.chebaofeiMapper.v1.CarScrapOrderSettlementMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAutoparts;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderSettlement;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderAutopartsService;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderService;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderSettlementService;
import com.tieshan.api.util.toolUtil.CheckUtil;
import com.tieshan.api.util.toolUtil.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:19
 */
@Service
public class CarScrapOrderSettlementServiceImpl extends BaseServiceImpl<CarScrapOrderSettlement>
        implements CarScrapOrderSettlementService {
    @Autowired
    private CarScrapOrderSettlementMapper carScrapOrderSettlementMapper;

    @Autowired
    private CarScrapOrderService carScrapOrderService;

    @Autowired
    private CarScrapOrderAutopartsService carScrapOrderAutopartsService;


    public Integer saveCarScrapOrderSettlement(CarScrapOrderSettlement carScrapOrderSettlement) throws Exception{
        if(carScrapOrderSettlement!=null){
            if(carScrapOrderSettlement.getSettlementAmount()!=null&&carScrapOrderSettlement.getSettlementAmount().compareTo(new BigDecimal(0))>0){
                CheckUtil.notEmpty(carScrapOrderSettlement.getSettlementObjectId(), "param.is.null");
                CheckUtil.notEmpty(carScrapOrderSettlement.getSettlementType(), "param.is.null");
                if(StringUtils.equals(carScrapOrderSettlement.getSettlementType(), CommonSystemParamter.ORDER_WhOLECAR_TYPE)){
                    //根据订单id查询订单
                    CarScrapOrder order = this.carScrapOrderService.queryById(carScrapOrderSettlement.getSettlementObjectId());
                    if(order!=null){
                        //查询已经结算的总金额
                        List<CarScrapOrderSettlementBO> settleList = carScrapOrderSettlementMapper.getCarScrapOrderSettlementByOrderId(order.getId());
                        BigDecimal totalAmountSettled = new BigDecimal(0);
                        for(CarScrapOrderSettlementBO settlebo :settleList){
                            if(settlebo.getSettlementAmount()!=null)
                                totalAmountSettled = totalAmountSettled.add(settlebo.getSettlementAmount());
                        }
                        BigDecimal totalSettlementAmount = totalAmountSettled.add(carScrapOrderSettlement.getSettlementAmount()==null?new BigDecimal(0):carScrapOrderSettlement.getSettlementAmount() );
                        //判断结算金额是否大于订单金额
                        if(totalSettlementAmount.compareTo(order.getOrderAmount())>0){
                            throw new SettlementAmountException("结算金额大于订单金额");
                        }
                        //保存结算审核记录
                        carScrapOrderService.saveOrderAuditingRecord(carScrapOrderSettlement.getSettlementObjectId(), CommonSystemParamter.ORDER_SETTLEMENT_STATUS, carScrapOrderSettlement.getSettlementRemarks(), carScrapOrderSettlement.getCreater(), null);
                        if(totalSettlementAmount.compareTo(order.getOrderAmount())==0){
                            //订单结束
                            carScrapOrderService.saveOrderAuditingRecord(carScrapOrderSettlement.getSettlementObjectId(), CommonSystemParamter.ORDER_END_STATUS, carScrapOrderSettlement.getSettlementRemarks(), carScrapOrderSettlement.getCreater(), null);
                        }
                        carScrapOrderSettlement.setSettlementTime(new Date());
                        return super.save(carScrapOrderSettlement);
                    }else{
                        return 0;
                    }
                }else if (StringUtils.equals(carScrapOrderSettlement.getSettlementType(), CommonSystemParamter.ORDER_OLDPARTS_TYPE)){
                    //根据配件id查询配件
                    CarScrapOrderAutoparts parts = this.carScrapOrderAutopartsService.queryById(carScrapOrderSettlement.getSettlementObjectId());
                    if(parts!=null){
                        List<CarScrapOrderSettlementBO>  settleList = carScrapOrderSettlementMapper.getCarScrapOrderSettlementByOrderId(parts.getId());
                        BigDecimal totalAmountSettled = new BigDecimal(0);
                        for(CarScrapOrderSettlementBO settlebo :settleList){
                            if(settlebo.getSettlementAmount()!=null)
                                totalAmountSettled = totalAmountSettled.add(settlebo.getSettlementAmount());
                        }
                        BigDecimal totalSettlementAmount = totalAmountSettled.add(carScrapOrderSettlement.getSettlementAmount()==null?new BigDecimal(0):carScrapOrderSettlement.getSettlementAmount());
                        //判断结算金额是否大于订单金额
                        if(totalSettlementAmount.compareTo(parts.getAmount()==null?new BigDecimal(0):parts.getAmount())>0){
                            throw new SettlementAmountException("结算金额大于订单金额");
                        }
                        carScrapOrderAutopartsService.saveOrderAutopartsAuditingRecord(carScrapOrderSettlement.getSettlementObjectId(), CommonSystemParamter.PARTS_SETTLEMENT_STATUS, carScrapOrderSettlement.getSettlementRemarks(), carScrapOrderSettlement.getCreater(), null);
                        if(totalSettlementAmount.compareTo(parts.getAmount()==null?new BigDecimal(0):parts.getAmount())==0){
                            carScrapOrderAutopartsService.saveOrderAutopartsAuditingRecord(carScrapOrderSettlement.getSettlementObjectId(), CommonSystemParamter.PARTS_END_STATUS, carScrapOrderSettlement.getSettlementRemarks(), carScrapOrderSettlement.getCreater(), null);
                        }
                        carScrapOrderSettlement.setSettlementTime(new Date());
                        return super.save(carScrapOrderSettlement);
                    }else{
                        return 0;
                    }
                }
            }else{
                return 0;
            }
        }
        return 1;
    }


    public List<CarScrapOrderSettlementBO>  getCarScrapOrderSettlementByOrderId(String orderid){
        //根据订单id查询订单信息
        CarScrapOrder order = this.carScrapOrderService.queryById(orderid);
        if(order!=null){
            if(StringUtils.equals(CommonSystemParamter.ORDER_WhOLECAR_TYPE, order.getOrderType())){
                return carScrapOrderSettlementMapper.getCarScrapOrderSettlementByOrderId(orderid);
            }else{
                return carScrapOrderSettlementMapper.getCarScrapOrderOfOldSettlementByOrderId(orderid);
            }
        }
        return null;
    }
}
