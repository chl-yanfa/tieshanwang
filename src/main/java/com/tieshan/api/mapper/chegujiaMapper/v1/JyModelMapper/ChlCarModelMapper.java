package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;

import java.util.List;

public interface ChlCarModelMapper {

    int insertSelective(ChlCarModel record);

    ChlCarModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChlCarModel record);

    int updateByPrimaryKeyWithBLOBs(ChlCarModel record);

    int updateByPrimaryKey(ChlCarModel record);
    //查询该vin是否存在
    List<ChlCarModel> selectModelVin(String vin);
    //根据车系id查看车型
    List<ChlCarModel> selectCheXiId(Integer chexiId);
}