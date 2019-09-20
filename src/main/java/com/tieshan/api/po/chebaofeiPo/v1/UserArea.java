package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:37
 */
@Data
@Table(name="sys_user_area")
public class UserArea extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private String userid;

    @ApiModelProperty(value = "区域id")
    private Integer areaid;

    private String creater;

    private String operator;

    private Date createtime;

    private Date operatortime;
}
