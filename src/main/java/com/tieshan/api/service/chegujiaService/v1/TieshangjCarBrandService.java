package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;

import java.util.List;

public interface TieshangjCarBrandService {
    //根据车标id查询品牌Name
    List<TieshangjCarBrand> selectCBId(Integer ALId);
}
