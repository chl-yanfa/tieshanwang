package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmCustomerCertificationAudit;

public interface CarPmCustomerCertificationAuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmCustomerCertificationAudit record);

    int insertSelective(CarPmCustomerCertificationAudit record);

    CarPmCustomerCertificationAudit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmCustomerCertificationAudit record);

    int updateByPrimaryKey(CarPmCustomerCertificationAudit record);
}