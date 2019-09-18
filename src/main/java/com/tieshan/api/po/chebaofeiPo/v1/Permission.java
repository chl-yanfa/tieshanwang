package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:48
 */
@Data
@Table(name="sys_permission")
public class Permission  extends BasePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "权限类型(1:虚拟菜单 2：菜单)")
    private String type;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单url")
    private String url;

    @ApiModelProperty(value = "权限编码")
    private String percode;

    @ApiModelProperty(value = "父节点id")
    private Integer parentid;

    @ApiModelProperty(value = "排序")
    private Short sortstring;

    @ApiModelProperty(value = "菜单是否可用")
    private Boolean available;
}
