package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.bo.chebaofeiBo.v1.AttachmentBO;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import com.tieshan.api.service.chebaofeiService.v1.UploadService;
import com.tieshan.api.vo.chebaofeiVo.v1.AttachmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:32
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private TbAttachmentService tbAttachmentService;

    @Override
    public Integer saveAttachmentBuniessData(AttachmentVO vo) throws Exception {
        AttachmentBO bo = new AttachmentBO();
        TbAttachment record = new TbAttachment();  //tb_attachment表对象 nrz
        record.setOriginalName(vo.getOriginalName());
        record.setStoragePath(vo.getStoragePath());
        TbAttachment result = tbAttachmentService.saveReturnPersistentObject(record);
        bo.setId(result.getId());
        return bo.getId();
    }

    @Override
    public Integer saveCarAttachmentBuniessData(String buniessid, AttachmentVO vo) throws Exception {
        return null;
    }
}
