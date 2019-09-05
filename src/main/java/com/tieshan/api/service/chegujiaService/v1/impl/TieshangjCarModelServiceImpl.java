package com.tieshan.api.service.chegujiaService.v1.impl;
import com.tieshan.api.mapper.chegujiaMapper.v1.TieshangjCarModelMapper;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TieshangjCarModelServiceImpl implements TieshangjCarModelService {
    @Autowired
    private TieshangjCarModelMapper tieshangjCarModelMapper;
    @Override
    public List<TieshangjCarModel> selectCheXiId(Integer chexiId) {
        return tieshangjCarModelMapper.selectCheXiId(chexiId);
    }

    @Override
    public List<TieshangjCarModel> selectAll(Map map) {
        return tieshangjCarModelMapper.selectAll(map);
    }

    @Override
    public Integer selectAllCount(Map map) {
        return tieshangjCarModelMapper.selectAllCount(map);
    }

    @Override
    public String selectByPrimarytiema(String tiema) {
        return tieshangjCarModelMapper.selectByPrimarytiema(tiema);
    }

    @Override
    public TieshangjCarModel selectByPrimaryKey(Integer id) {
        return tieshangjCarModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TieshangjCarModel> selectAlls() {
        return tieshangjCarModelMapper.selectAlls();
    }

    @Override
    public int updateByPrimaryKeySelective(TieshangjCarModel record) {
        return tieshangjCarModelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByHe(TieshangjCarModel record) {
        return tieshangjCarModelMapper.updateByHe(record);
    }

    @Override
    public String selectTieMaByJYid(String jyid) {
        return tieshangjCarModelMapper.selectTieMaByJYid(jyid);
    }

    @Override
    public String countByTieMa(String tiema) {
        return tieshangjCarModelMapper.countByTieMa(tiema);
    }


}
