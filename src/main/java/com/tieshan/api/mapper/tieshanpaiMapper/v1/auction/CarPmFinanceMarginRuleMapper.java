package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmFinanceMarginRule;

public interface CarPmFinanceMarginRuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmFinanceMarginRule record);

    int insertSelective(CarPmFinanceMarginRule record);

    CarPmFinanceMarginRule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmFinanceMarginRule record);

    int updateByPrimaryKey(CarPmFinanceMarginRule record);
}