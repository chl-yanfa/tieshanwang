package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.TbAttachmentMapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:29
 */
@Service
public class TbAttachmentServiceImpl extends BaseServiceImpl<TbAttachment> implements
        TbAttachmentService {

    @Autowired
    private TbAttachmentMapper tbAttachmentMapper;

}
