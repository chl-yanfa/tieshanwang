package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.mapper.chebaofeiMapper.v1.TbCarPartsCategoryMapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarPartsCategory;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbCarPartsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 14:00
 */
@Service
public class TbCarPartsCategoryServiceImpl extends BaseServiceImpl<TbCarPartsCategory> implements TbCarPartsCategoryService {

    @Autowired
    private TbCarPartsCategoryMapper tbCarPartsCategoryMapper;


    @Override
    public PageInfo<TbCarPartsCategory> queryMyPageListByWhere(int page, int rows, TbCarPartsCategory paramter) throws Exception {
        PageHelper.startPage(page, rows);
        List<TbCarPartsCategory> data = tbCarPartsCategoryMapper.queryMyPageListByWhere(paramter);
        return new PageInfo<>(data);
    }
}
