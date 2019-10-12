package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.util.toolUtil.ClientUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewPartsPMController {
    @Autowired
    TbAttachmentService tbAttachmentService;
    @Autowired
    CarPmAuctionService carPmAuctionService;

    /**
     * 新增拍品-件
     * @param auction
     * @return
     */
    @RequestMapping(value = "/addNewPartsAuction", method = RequestMethod.POST)
    public ResultVO<String> addAuction(@RequestBody CarPmAuctionVo auction) throws Exception {
        auction.setCreateUser(ClientUtil.getUser().getId());
        //前台传递一个图片路径集合
        List<String> imgPathList = auction.getTxtImg();
        System.out.println("图片List:"+imgPathList.size());

        StringBuilder stringBuffer = new StringBuilder();
        for (String s : imgPathList) {
            TbAttachment tb = new TbAttachment();
            tb.setStoragePath(s);
            TbAttachment tbAttachment = tbAttachmentService.queryOne(tb);
            stringBuffer.append(tbAttachment.getId());
            stringBuffer.append(",");
        }
        System.out.println("图片的id:"+stringBuffer);
        String newFields = stringBuffer.toString();
        auction.setFileIds(newFields.substring(0,newFields.lastIndexOf(",")));
        return carPmAuctionService.addAuction(auction);
    }
}
