package com.tieshan.api.controller.chebaofeiController.v1;

import com.tieshan.api.common.chebaofeiCommon.Exception.AttachmentException;
import com.tieshan.api.common.chebaofeiCommon.PicUploadResult;
import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.service.chebaofeiService.v1.UploadService;
import com.tieshan.api.vo.chebaofeiVo.v1.AttachmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:24
 */
@RestController
@RequestMapping(value="/carscraporder-attachment/ali/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @RequestMapping(value="/attachmet",method = RequestMethod.POST)
    public ResultBean<List<PicUploadResult>> addOrUpdateResource(
            @RequestParam("files") String[] files) throws Exception {

        List<PicUploadResult> resultList = new ArrayList<>();
        PicUploadResult result = new PicUploadResult();

        if(files!=null){
            //保存到数据库
            AttachmentVO data = new AttachmentVO();
            for (int i=0;i<files.length;i++){
                data.setOriginalName( files[i].substring(files[i].lastIndexOf("/")+1,files[i].length()).replaceAll("\"",""));
                data.setStoragePath(files[i].replaceAll("\"",""));
                int id =  uploadService.saveAttachmentBuniessData(data);
                if(id>0){
                    result.setId(id);
                    result.setUrl(files[i].replaceAll("\"",""));
                }
            }
            resultList.add(result);
        }else{
            throw new AttachmentException("URL为空");
        }
        return new ResultBean<>(resultList);
    }
}
