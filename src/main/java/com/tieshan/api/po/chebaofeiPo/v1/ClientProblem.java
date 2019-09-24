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
 * @date 2019/9/24 9:42
 */
@Data
@Table(name="tb_client_problem")
public class ClientProblem extends BasePojo {

    @Id
    private String id;

    @ApiModelProperty(value = "常见问题标题")
    private String title;

    @ApiModelProperty(value = "常见问题内容")
    private String content;

    @ApiModelProperty(value = "是否删除(0:有效，1:删除)")
    private Integer isremove;

    @JsonIgnore
    private String creater;

    @JsonIgnore
    private Date createtime;
}
