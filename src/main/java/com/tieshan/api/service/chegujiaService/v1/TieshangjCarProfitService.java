package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;

public interface TieshangjCarProfitService {
    //根据车型铁码查询利润系数
    String selectLiRun(String tiema);
    //根据铁码查询数据
    TieshangjCarProfit selectTie(String tiema);
    int updateByPrimaryKeySelective(TieshangjCarProfit record);
}
