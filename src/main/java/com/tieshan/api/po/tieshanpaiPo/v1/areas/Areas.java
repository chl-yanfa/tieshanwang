package com.tieshan.api.po.tieshanpaiPo.v1.areas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tieshan.api.po.chebaofeiPo.v1.BasePojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 9:22
 */
@Data
@Table(name="sys_areas")
public class Areas extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String areasCode;

    @ApiModelProperty(value = "用户管理区域名称")
    private String areasName;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String status;


    @ApiModelProperty(value = "用户管理区域经纬度")
    private String coordinate;


    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Boolean isVirtualField;

}
