package com.tieshan.api.po.tieshanpaiPo.v1.auction;

import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/8 13:38
 */
@Data
public class PMNumber {
    private Integer id;
    private Integer type;
    private Integer number;
    private String memo;
    private Date createTime;
    private Date updateTime;
    private Date ts;
}
