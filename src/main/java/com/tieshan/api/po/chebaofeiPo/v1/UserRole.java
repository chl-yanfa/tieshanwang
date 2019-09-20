package com.tieshan.api.po.chebaofeiPo.v1;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:41
 */
@Data
@Table(name="sys_user_role")
public class UserRole extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userid;

    private Integer roleid;
}
