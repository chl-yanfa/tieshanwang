package com.tieshan.api.controller.chebaofeiController.v1;

import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAttachment;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderAttachmentService;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 15:34
 */
@RestController
@RequestMapping(value="/carscraporder-applet/carattachment")
public class CarAttachmentController {

    @Autowired
    private CarScrapOrderAttachmentService carScrapOrderAttachmentService;

    @Autowired
    private TbAttachmentService tbAttachmentService;

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Boolean> delete(@PathVariable("id")Integer id) throws Exception {
        //根据id查询carscraporderattachment
        CarScrapOrderAttachment carScrapOrderAttachment = carScrapOrderAttachmentService.selectByPrimaryKey(id);
        if(carScrapOrderAttachment!=null){
            //删除carScrapOrderAttachment
            carScrapOrderAttachment.setIsvalid(false);
            carScrapOrderAttachmentService.updateByPrimaryKey(carScrapOrderAttachment);
            TbAttachment attachement = tbAttachmentService.queryById(carScrapOrderAttachment.getAttachmentId());
            if(attachement!=null){
                attachement.setIsvalid(false);
                return new ResultBean<>(tbAttachmentService.update(attachement) == 1);
            }
        }
        return new ResultBean<>(false);
    }
}
