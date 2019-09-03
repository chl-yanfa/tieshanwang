package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;

import java.util.List;

public interface ChlAutoLogosMapper {

    ChlAutoLogos selectByPrimaryKey(Integer autoLogosId);

    int updateByPrimaryKeySelective(ChlAutoLogos record);
    //查询所有车标
    List<ChlAutoLogos> selectAll();

}