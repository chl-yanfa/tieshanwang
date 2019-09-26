package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.vo.chebaofeiVo.v1.AttachmentVO;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:26
 */
public interface UploadService {

    Integer saveAttachmentBuniessData(AttachmentVO vo)throws Exception;

    Integer saveCarAttachmentBuniessData(String buniessid,AttachmentVO vo)throws Exception;
}
