package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper.ChlAutoLogosMapper;
import com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper.ChlBrandMapper;
import com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper.ChlCarModelMapper;
import com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper.ChlCarModelSeriesMapper;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyModelServiceImpl implements JyModelService {
    @Autowired
    private ChlAutoLogosMapper chlAutoLogosMapper;
    @Autowired
    private ChlBrandMapper chlBrandMapper;
    @Autowired
    private ChlCarModelSeriesMapper chlCarModelSeriesMapper;
    @Autowired
    private ChlCarModelMapper chlCarModelMapper;
    @Override
    public List<ChlAutoLogos> selectAll() {
        return chlAutoLogosMapper.selectAll();
    }

    @Override
    public List<ChlBrand> selectCBId(Integer ALId) {
        return chlBrandMapper.selectCBId(ALId);
    }

    @Override
    public List<ChlCarModelSeries> selectBrandId(Integer brandId) {
        return chlCarModelSeriesMapper.selectBrandId(brandId);
    }

    @Override
    public List<ChlCarModel> selectCheXiId(Integer chexiId) {
        return chlCarModelMapper.selectCheXiId(chexiId);
    }

    @Override
    public List<ChlCarModel> selectModelVin(String vin) {
        return chlCarModelMapper.selectModelVin(vin);
    }

    @Override
    public ChlCarModel selectModelJyid(String jyid) {
        return chlCarModelMapper.selectModelJyid(jyid);
    }

    @Override
    public int updateVinByJyid(ChlCarModel record) {
        return chlCarModelMapper.updateVinByJyid(record);
    }


}
