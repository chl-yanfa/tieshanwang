package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmTowingCompany;

public interface CarPmTowingCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmTowingCompany record);

    int insertSelective(CarPmTowingCompany record);

    CarPmTowingCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmTowingCompany record);

    int updateByPrimaryKey(CarPmTowingCompany record);
}