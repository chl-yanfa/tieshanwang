package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 9:45
 */
@Data
@Table(name="sys_client")
public class SysClient extends BasePojo{

    @Id
    private String id;

    @ApiModelProperty(value = "客户姓名")
    private String userName;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "客户类型（1.个人 2.大客户）")
    private String userType;

    @ApiModelProperty(value = "微信号")
    private String weixincode;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private String password;

    //@ApiModelProperty(value = "密码盐")
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private String passwordSalt;

    @ApiModelProperty(value = "大客户用户所属公司")
    private Integer companyid;

    @ApiModelProperty(value = "大客户用户角色类型（1:整车报废管理员 2:旧件回收管理员）")
    //@ApiModelProperty(hidden=true)
    private String businessType;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "身份证正面图片ID")
    private Integer frontIdCard;

    @ApiModelProperty(value = "身份证背面图片ID")
    private Integer backIdCard;

    @ApiModelProperty(value = "手持身份证图片ID")
    private Integer handIdCard;

    @ApiModelProperty(value = "实名认证状态")
    private Integer certificationState;

    @ApiModelProperty(value = "实名认证提交时间")
    private Date certificationSubmitTime;

    @ApiModelProperty(value = "实名认证审核时间")
    private Date certificationAuditTime;

    @ApiModelProperty(value = "实名认证审核人")
    private String certificationAuditUser;

    @ApiModelProperty(value = "实名认证备注")
    private String certificationMemo;

    //@ApiModelProperty(value = "数据状态,1:正常,2:删除,3:禁用账号")
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private String status;
}
