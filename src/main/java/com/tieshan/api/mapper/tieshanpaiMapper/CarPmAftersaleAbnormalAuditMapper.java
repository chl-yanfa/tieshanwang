package com.tieshan.api.mapper.tieshanpaiMapper;

import com.tieshan.api.po.tieshanpaiPo.CarPmAftersaleAbnormalAudit;

public interface CarPmAftersaleAbnormalAuditMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarPmAftersaleAbnormalAudit record);

    int insertSelective(CarPmAftersaleAbnormalAudit record);

    CarPmAftersaleAbnormalAudit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarPmAftersaleAbnormalAudit record);

    int updateByPrimaryKey(CarPmAftersaleAbnormalAudit record);
}