package com.tieshan.api.mapper.chegujiaMapper.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;

import java.util.List;

public interface TieshangjCarBrandMapper {


    int insertSelective(TieshangjCarBrand record);

    TieshangjCarBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TieshangjCarBrand record);

    //根据车标id查询品牌
    List<TieshangjCarBrand> selectCBId(Integer ALId);
}