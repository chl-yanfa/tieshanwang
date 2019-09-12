package com.tieshan.api.vo.chebaofeiVo.v1;

import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 10:58
 */
@Data
public class ClientCertificationVO extends SysClient {

    @ApiModelProperty(value = "用户真实姓名")
    private String userName;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "身份证正面图片ID")
    private Integer frontIdCard;

    @ApiModelProperty(value = "身份证背面图片ID")
    private Integer backIdCard;

    @ApiModelProperty(value = "手持身份证图片ID")
    private Integer handIdCard;
}
