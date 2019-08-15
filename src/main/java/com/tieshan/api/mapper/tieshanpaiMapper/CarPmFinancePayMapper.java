package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmFinancePay;

public interface CarPmFinancePayMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmFinancePay record);

    int insertSelective(CarPmFinancePay record);

    CarPmFinancePay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmFinancePay record);

    int updateByPrimaryKey(CarPmFinancePay record);
}