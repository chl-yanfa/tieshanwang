package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfo;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfoBO;
import com.tieshan.api.mapper.chebaofeiMapper.v1.TbCommonMailinginfoMapper;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbCommonMailinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:22
 */
@Service
public class TbCommonMailinginfoServiceImpl extends BaseServiceImpl<TbCommonMailinginfo>
        implements TbCommonMailinginfoService {


    @Autowired
    private TbCommonMailinginfoMapper tbCommonMailinginfoMapper;

    @Override
    public PageInfo<TbCommonMailinginfoBO> queryListByWhere(Integer page,
                                                            Integer rows, TbCommonMailinginfo paramter) {
        PageHelper.startPage(page, rows);
        List<TbCommonMailinginfoBO> tbCommonMailinginfos = tbCommonMailinginfoMapper.queryListByWhere(paramter);
        return new PageInfo<>(tbCommonMailinginfos);
    }



}
