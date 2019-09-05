package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.Exceljyid;

public interface ExceljyidMapper {

    int insertSelective(Exceljyid record);

    Exceljyid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exceljyid record);
    //根据精友id查看铁码
    Exceljyid selectByJyid(String jyid);
}