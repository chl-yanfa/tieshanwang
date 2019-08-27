package com.tieshan.api.service.chegujiaService;

import com.tieshan.api.po.chegujiaPo.TieshangjCarProfit;

public interface TieshangjCarProfitService {
    //根据车型铁码查询利润系数
    TieshangjCarProfit selectLiRun(String tiema);
}
