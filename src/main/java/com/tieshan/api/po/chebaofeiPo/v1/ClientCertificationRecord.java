package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:12
 */
@Data
@Table(name="tb_client_certification_record")
public class ClientCertificationRecord {
    @Id
    private String id;
    @ApiModelProperty(value = "用户id")
    private String clientid;
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
    @ApiModelProperty(value = "审核人")
    private String auditUser;
    @ApiModelProperty(value = "0：审核通过；-1：审核驳回")
    private Integer state;
    @ApiModelProperty(value = "备注")
    private String memo;
    @JsonIgnore
    private String creater;
    @JsonIgnore
    private Date createtime;
}
