package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmCustomerCertificationAudit;

public interface CarPmCustomerCertificationAuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPmCustomerCertificationAudit record);

    int insertSelective(CarPmCustomerCertificationAudit record);

    CarPmCustomerCertificationAudit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPmCustomerCertificationAudit record);

    int updateByPrimaryKey(CarPmCustomerCertificationAudit record);
}