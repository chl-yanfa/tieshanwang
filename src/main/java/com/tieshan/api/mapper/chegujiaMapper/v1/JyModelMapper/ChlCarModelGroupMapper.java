package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelGroup;

public interface ChlCarModelGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChlCarModelGroup record);

    int insertSelective(ChlCarModelGroup record);

    ChlCarModelGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChlCarModelGroup record);

    int updateByPrimaryKey(ChlCarModelGroup record);
    //根据车组名称查看车组id
    Integer selectByName(String name);
}