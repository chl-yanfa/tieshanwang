package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.*;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import com.tieshan.api.service.BaseService;
import com.tieshan.api.vo.chebaofeiVo.v1.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 16:33
 */
public interface CarScrapOrderService extends BaseService<CarScrapOrder> {

    PageInfo<CarScrapOrderPageBO>  queryPageListByWhere(Integer page,Integer rows,CarScrapOrderWhereParamterVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageListByKeywordByChl(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageListByKeywordByExamine(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageListByKeywordByExamineOK(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageListByKeywordByCancel(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageHistoryListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryPageHistoryListByKeywordByChl(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryAll(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO>  queryAllByChl(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    CarScrapOrderBO queryBOById(String id)throws Exception;

    int deleteByPrimaryKey(String id,String operator)throws Exception;

    Integer cancelOrder(String id,String cancelMemo,String operator)throws Exception;

    Boolean confirmAmount(CarScrapOrderConfirmAmountVO confirmAmountVO)throws Exception;

    Integer update(CarScrapOrderVO record) throws Exception;

    Integer save(CarScrapOrderVO record)throws Exception ;

    CarScrapOrder queryById(String id);

    Integer saveOrderAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrder order,String username,String userId,String isClient) throws Exception;

    Integer saveOrderAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrder order) throws Exception;

    OrderAduitBO getOrderAuditInfo(String orderId) throws Exception;

    CarScrapOrderMyTradeBO myTrade(String clientId)throws Exception;

    PageInfo<CarScrapOrderMyTradeInfoBO> myTradeInfo(Integer page,Integer rows, String clientId)throws Exception;

    Boolean quote(CarScrapOrderQuoteVO quoteVO)throws Exception;

    Boolean quoteByPush(CarScrapOrderQuoteVO quoteVO)throws Exception;

    PageInfo<CarScrapOrderQuotePageBO>  queryQuotePageListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;

    Boolean TellUserTakeCar(String clientId,String salePhone,String saleName,String orderId);

    Boolean TellMoneyByUser(String carNumber,String orderId);
}
