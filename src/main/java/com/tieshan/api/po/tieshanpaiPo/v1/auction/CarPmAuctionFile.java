package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import java.io.Serializable;
import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId == null ? null : auctionId.trim();
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}