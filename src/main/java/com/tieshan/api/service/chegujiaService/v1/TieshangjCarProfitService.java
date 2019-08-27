package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;

public interface TieshangjCarProfitService {
    //根据车型铁码查询利润系数
    TieshangjCarProfit selectLiRun(String tiema);
}
