package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarPmAuctionFile implements Serializable {
    private Integer id;

    private String auctionId;

    private Integer fileType;  //附件类型(0:拍品图片,1:行驶证,2:银行卡,3:银行卡正面,4:扫描件,5:物资附件)

    private Integer attachmentId; //附件存储id

    private Integer sort; //图片排序

    private Integer picType; //图片类型：0-原图；1-缩略图

    private Boolean isDelete;

    private String createUser;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public CarPmAuctionFile() {}

    public CarPmAuctionFile(String auctionId, Integer fileType, Integer attachmentId, Integer sort,
                       Integer picType, String createUser) {
        this.auctionId = auctionId;
        this.fileType = fileType;
        this.attachmentId = attachmentId;
        this.sort = sort;
        this.picType = picType;
        this.createUser = createUser;
    }
}