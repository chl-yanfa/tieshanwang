package com.tieshan.api.mapper.tieshanpaiMapper.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAftersaleAbnormalAudit;

public interface CarPmAftersaleAbnormalAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleAbnormalAudit record);

    int insertSelective(CarPmAftersaleAbnormalAudit record);

    CarPmAftersaleAbnormalAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleAbnormalAudit record);

    int updateByPrimaryKey(CarPmAftersaleAbnormalAudit record);
}