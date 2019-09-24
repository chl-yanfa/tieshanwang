package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarBrand;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChlBrandMapper {

    ChlBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChlBrand record);

    //根据车标id查询品牌
    List<ChlBrand> selectCBId(Integer ALId);
}