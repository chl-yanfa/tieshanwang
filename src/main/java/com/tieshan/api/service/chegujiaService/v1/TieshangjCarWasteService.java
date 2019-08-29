package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;

import java.util.List;

public interface TieshangjCarWasteService {
    List<TieshangjCarWaste> selectAll();
    TieshangjCarWaste selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(TieshangjCarWaste record);
}
