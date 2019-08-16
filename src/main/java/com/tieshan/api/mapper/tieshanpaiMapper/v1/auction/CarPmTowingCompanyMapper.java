package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmTowingCompany;

public interface CarPmTowingCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmTowingCompany record);

    int insertSelective(CarPmTowingCompany record);

    CarPmTowingCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmTowingCompany record);

    int updateByPrimaryKey(CarPmTowingCompany record);
}