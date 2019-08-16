package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmCustomerInfo;

public interface CarPmCustomerInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CarPmCustomerInfo record);

    int insertSelective(CarPmCustomerInfo record);

    CarPmCustomerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CarPmCustomerInfo record);

    int updateByPrimaryKey(CarPmCustomerInfo record);
}