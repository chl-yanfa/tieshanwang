package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarVehicleSystem;

import java.util.List;

public interface ChlCarModelSeriesMapper {


    int insertSelective(ChlCarModelSeries record);

    ChlCarModelSeries selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChlCarModelSeries record);


    //根据品牌id查询车系
    List<ChlCarModelSeries> selectBrandId(Integer brandId);
}