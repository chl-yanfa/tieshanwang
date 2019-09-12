package com.tieshan.api.vo.chebaofeiVo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 10:57
 */
@Data
public class ClientVO {
    private String id;

    @NotEmpty(message="用户名不能为空")
    @Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String loginName;

    @ApiModelProperty(value = "客户姓名")
    private String userName;

    @NotEmpty(message="手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String validateCode;

    private Integer certificationState;

    private String certificationMemo;

    private String operator;

    private String creater;

    private String keyWord;
}
