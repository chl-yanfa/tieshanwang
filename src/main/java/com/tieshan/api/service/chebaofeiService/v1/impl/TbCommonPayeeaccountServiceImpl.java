package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonPayeeaccount;
import com.tieshan.api.mapper.chebaofeiMapper.v1.TbCommonPayeeaccountMapper;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbCommonPayeeaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:17
 */
@Service
public class TbCommonPayeeaccountServiceImpl extends BaseServiceImpl<TbCommonPayeeaccount>
        implements TbCommonPayeeaccountService {

    @Autowired
    private TbCommonPayeeaccountMapper tbCommonPayeeaccountMapper;
}
