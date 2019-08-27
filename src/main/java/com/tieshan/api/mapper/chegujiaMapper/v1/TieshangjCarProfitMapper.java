package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;

public interface TieshangjCarProfitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarProfit record);

    int insertSelective(TieshangjCarProfit record);

    TieshangjCarProfit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarProfit record);


    //根据车型铁码查询利润系数
    TieshangjCarProfit selectLiRun(String tiema);
}