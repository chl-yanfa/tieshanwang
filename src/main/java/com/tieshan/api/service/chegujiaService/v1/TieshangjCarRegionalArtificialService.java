package com.tieshan.api.service.chegujiaService.v1;

import org.apache.ibatis.annotations.Param;

public interface TieshangjCarRegionalArtificialService {
    //根据车型铁码查询在某个省份的人工调整值
    String selectArtifi(@Param("tiema") String tiema, @Param("pid") String pid);
}
