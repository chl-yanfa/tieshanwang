package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarTrainCrew;

import java.util.List;
import java.util.Map;

public interface TieshangjCarTrainCrewService {
    List<TieshangjCarTrainCrew> selectAll(Map map);
    Integer selectAllCount(Map map);
    List<TieshangjCarTrainCrew> selectAll2(Map map);
}
