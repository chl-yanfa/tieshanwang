package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ningrz 系统po的基类
 * @version 1.0
 * @date 2019/9/12 11:05
 */
@Data
public class BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Date createtime;

    @JsonIgnore
    private Date operatortime;

    @JsonIgnore
    private String creater;

    @JsonIgnore
    private String operator;
}
