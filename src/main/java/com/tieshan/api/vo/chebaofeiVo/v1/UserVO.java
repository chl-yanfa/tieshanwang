package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:59
 */
@Data
public class UserVO {
    private String id;

    @NotEmpty(message="用户名不能为空")
    @Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String loginName;

    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    @ApiModelProperty(value = "用户真实姓名")
    private String password;

    @ApiModelProperty(value = "用户角色ids,表单页面有多个角色选择拼接角色id逗号分隔(例如：'1,2,3')")
    private String roleids;

    @ApiModelProperty(value = "用户管理区域,表单页面有多个区域选择拼接区域id逗号分隔(例如：'1,2,3')")
    private String  areasids;

    private String newpassword;

    private String operator;

    private String creater;;
}
