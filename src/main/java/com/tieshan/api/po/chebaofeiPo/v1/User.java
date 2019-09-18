package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:46
 */
@Data
public class User extends BasePojo {
    @Id
    private String id;

    @ApiModelProperty(value = "用户的登录名称，比如'zhangsan',用户名只能输入字母或数字")
    @NotEmpty(message="用户名不能为空")
    @Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String loginName;

    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    @ApiModelProperty(value = "用户密码,密码不能为空")
    @NotEmpty(message="用户名不能为空")
    @JsonIgnore
    private String password;

    @ApiModelProperty(value = "用户密码加密盐,不用输入系统随机生成")
    @JsonIgnore
    private String passwordSalt;

    @ApiModelProperty(value = "用户状态(1:正常 2:删除 3:禁用),默认：'正常'")
    private String status="1";

    private String contactPhone;
}
