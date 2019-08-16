package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmFinancePay;

public interface CarPmFinancePayMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmFinancePay record);

    int insertSelective(CarPmFinancePay record);

    CarPmFinancePay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmFinancePay record);

    int updateByPrimaryKey(CarPmFinancePay record);
}