package com.tieshan.api.service.tieshanpaiService.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPm;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPmFile;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;

public interface NewPartsPmService {
    //新增拍品-件 and 新增图片
    int insertJianFile(NewPartsPm record);
    ResultVO<String> addAuction(CarPmAuctionVo auction);
}
