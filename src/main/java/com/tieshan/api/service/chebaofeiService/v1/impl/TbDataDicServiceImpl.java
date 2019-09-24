package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.TbDataDicMapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbDataDic;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbDataDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 18:46
 */
@Service
public class TbDataDicServiceImpl extends BaseServiceImpl<TbDataDic> implements
        TbDataDicService {

    @Autowired
    private TbDataDicMapper tbDataDicMapper;
}
