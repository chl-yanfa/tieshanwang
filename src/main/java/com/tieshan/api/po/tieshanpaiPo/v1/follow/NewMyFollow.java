package com.tieshan.api.po.tieshanpaiPo.v1.follow;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class NewMyFollow implements Serializable {
    private Integer id;

    private Integer type;

    private String typeId;

    private String userId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}