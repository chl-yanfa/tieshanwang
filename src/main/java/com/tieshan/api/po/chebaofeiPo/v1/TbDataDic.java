package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:25
 */
@Data
@Table(name="tb_data_dic")
public class TbDataDic extends BasePojo {
    @JsonIgnore
    private Integer id;

    @JsonIgnore
    private String datatype;

    @JsonIgnore
    private String datatypename;

    private String dataname;

    private Integer datavalue;

    @JsonIgnore
    private Byte ordernum;

    @JsonIgnore
    private Byte status;

    @JsonIgnore
    private Integer relevanceid;
}
