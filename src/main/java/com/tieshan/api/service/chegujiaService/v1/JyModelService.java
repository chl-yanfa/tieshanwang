package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;

import java.util.List;

public interface JyModelService {
    //查询所有车标
    List<ChlAutoLogos> selectAll();
    //根据车标id查询品牌
    List<ChlBrand> selectCBId(Integer ALId);
    //根据品牌id查询车系
    List<ChlCarModelSeries> selectBrandId(Integer brandId);
    //根据车系id查看车型
    List<ChlCarModel> selectCheXiId(Integer chexiId);
    //查询该vin是否存在
    List<ChlCarModel> selectModelVin(String vin);
}
