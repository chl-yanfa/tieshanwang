package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.tieshan.api.bo.tieshanpaiBo.v1.CarPmAuctionBO;
import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPm;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.NewPartsPmService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import com.tieshan.api.util.toolUtil.ClientUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "v1/NewPartsPm/")
public class NewPartsPMController {
    @Autowired
    TbAttachmentService tbAttachmentService;
    @Autowired
    CarPmAuctionService carPmAuctionService;
    @Autowired
    NewPartsPmService newPartsPmService;
    /**
     * 新增拍品-件的新增
     * @param auction
     * @return
     */
    @RequestMapping(value = "/addNewPartsPm", method = RequestMethod.POST)
    public ApiResult addNewPartsPm(@RequestBody NewPartsPm auction) throws Exception {
        auction.setCreateBy(ClientUtil.getUser().getId());
        auction.setUpdateBy(ClientUtil.getUser().getId());
        auction.setCreateTime(new Date());
        auction.setUpdateTime(new Date());
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
        int num=newPartsPmService.insertJianFile(auction);
        if(num>0){
            int id = auction.getId();
            return ResultUtil.success(id);
        }
        return ResultUtil.error(501,"新增失败");
    }
    /**
     * 新增拍品-件
     * @param auction
     * @return
     */
    @RequestMapping(value = "/addAuction", method = RequestMethod.POST)
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
        ResultVO<String> resultVO = carPmAuctionService.addAuction(auction);
        return resultVO;
    }
}
