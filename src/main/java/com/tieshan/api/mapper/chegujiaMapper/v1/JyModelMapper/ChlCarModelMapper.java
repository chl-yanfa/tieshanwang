package com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
    //查询该精友id是否存在
    ChlCarModel selectModelJyid(String jyid);
    //根据精友id修改车型vin()
    int updateVinByJyid(ChlCarModel record);
    //查询车型（参数：车系id）
    List<ChlCarModel> selectCarModelSerid(Integer serid);
}