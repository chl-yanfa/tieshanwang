package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmCustomerInfo;

public interface CarPmCustomerInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CarPmCustomerInfo record);

    int insertSelective(CarPmCustomerInfo record);

    CarPmCustomerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarPmCustomerInfo record);

    int updateByPrimaryKey(CarPmCustomerInfo record);
}