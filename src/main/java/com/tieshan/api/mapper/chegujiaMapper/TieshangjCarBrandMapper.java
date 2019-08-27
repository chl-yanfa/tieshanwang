package com.tieshan.api.mapper.chegujiaMapper;

import com.tieshan.api.po.chegujiaPo.TieshangjCarBrand;

import java.util.List;

public interface TieshangjCarBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TieshangjCarBrand record);

    int insertSelective(TieshangjCarBrand record);

    TieshangjCarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarBrand record);

    int updateByPrimaryKey(TieshangjCarBrand record);
    //根据车标id查询品牌
    List<TieshangjCarBrand> selectCBId(Integer ALId);
}