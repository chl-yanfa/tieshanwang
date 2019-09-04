package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjHistory;

import java.util.List;

public interface TieshangjHistoryService {
    int insertSelective(TieshangjHistory record);
    List<TieshangjHistory> selectAll();
}
