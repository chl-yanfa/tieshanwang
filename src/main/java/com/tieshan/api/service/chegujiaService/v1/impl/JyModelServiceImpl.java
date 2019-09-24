package com.tieshan.api.service.chegujiaService.v1.impl;

import com.tieshan.api.mapper.chegujiaMapper.v1.JyModelMapper.*;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlBrand;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModel;
import com.tieshan.api.po.chegujiaPo.v1.JyModelPo.ChlCarModelSeries;
import com.tieshan.api.service.chegujiaService.v1.JyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ChlCarModelGroupMapper chlCarModelGroupMapper;
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

    @Override
    public Integer selectByName(String name) {
        return chlCarModelGroupMapper.selectByName(name);
    }

    @Override
    public int insertSelective(ChlCarModel record) {
        return chlCarModelMapper.insertSelective(record);
    }

    @Override
    public ChlCarModel selectByPrimaryKey(Integer id) {
        return chlCarModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ChlCarModelSeries> selectSearch(Map map) {
        return chlCarModelSeriesMapper.selectSearch(map);
    }


}
