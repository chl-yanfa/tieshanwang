package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.TbCommonContactsMapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbCommonContacts;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbCommonContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:14
 */
@Service
public class TbCommonContactsServiceImpl extends BaseServiceImpl<TbCommonContacts> implements
        TbCommonContactsService {

    @Autowired
    private TbCommonContactsMapper tbCommonContactsMapper;
}
