package com.tieshan.api.vo.tieshanpaiVo.v1.auction;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAuctionFile;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 9:30
 */
public class CarPmAuctionFileVo extends CarPmAuctionFile {

    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
