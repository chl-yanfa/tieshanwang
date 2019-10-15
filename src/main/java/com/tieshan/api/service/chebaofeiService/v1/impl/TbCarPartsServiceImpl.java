package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.mapper.chebaofeiMapper.v1.TbCarPartsMapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarParts;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbCarPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 14:46
 */
@Service
public class TbCarPartsServiceImpl extends BaseServiceImpl<TbCarParts> implements TbCarPartsService {

    @Autowired
    private TbCarPartsMapper tbCarPartsMapper;

    @Override
    public PageInfo<TbCarParts> queryByIdPageListByWhere(int page, int rows, TbCarParts paramter) throws Exception {
        PageHelper.startPage(page, rows);
        List<TbCarParts> data = tbCarPartsMapper.queryByIdPageListByWhere(paramter);
        return new PageInfo<>(data);
    }

    @Override
    public List<TbCarParts> selectLike(String partsName) {
        return tbCarPartsMapper.selectLike(partsName);
    }
}
