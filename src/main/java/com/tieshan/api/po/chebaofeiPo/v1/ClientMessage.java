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
 * @date 2019/9/23 17:49
 */
@Data
@Table(name="tb_client_message")
public class ClientMessage extends BasePojo {
    @Id
    private String id;

    @ApiModelProperty(value = "客户id")
    private String clientId;

    @ApiModelProperty(value = "消息标题")
    private String title;

    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "消息类型:0-实名认证 1-报价确认")
    private String type;

    @ApiModelProperty(value = "是否已读(0:未读，1:已读)")
    private Integer isread;

    @ApiModelProperty(value = "是否删除(0:有效，1:删除)")
    private Integer isremove;

    @JsonIgnore
    private String creater;
    @JsonIgnore
    private Date createtime;
}
