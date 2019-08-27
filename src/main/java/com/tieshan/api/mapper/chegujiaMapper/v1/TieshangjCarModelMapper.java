package com.tieshan.api.mapper.chegujiaMapper.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;

import java.util.List;
import java.util.Map;

public interface TieshangjCarModelMapper {

    int insertSelective(TieshangjCarModel record);

    TieshangjCarModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarModel record);
    //根据车系id查看车型
    List<TieshangjCarModel> selectCheXiId(Integer chexiId);
    //根据条件查看车型(动态查询)
    List<TieshangjCarModel> selectAll(Map map);
    //根据条件查看车型(动态查询)---数量
    Integer selectAllCount(Map map);
}