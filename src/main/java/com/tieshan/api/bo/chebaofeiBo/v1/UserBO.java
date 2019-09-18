package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tieshan.api.po.chebaofeiPo.v1.Permission;
import com.tieshan.api.po.chebaofeiPo.v1.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:47
 */
@Data
public class UserBO extends User {
    private String roleName;

    private String areaName;

    //区域主键
    private String areasids;
    private String roleids;
    private String sessionId;

    @JsonIgnore
    private Boolean isAllDataPermisssion=false;


    private List<Permission> permissions = new ArrayList<Permission>();
}
