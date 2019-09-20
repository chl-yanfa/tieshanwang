package com.tieshan.api.po.shortMessageApiPo.v1;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TbVerificationCode implements Serializable {
    private Integer id;

    private String verificationCode;

    private String phone;

    private Integer type;

    private Integer isDelete;

    private Date ts;

    private static final long serialVersionUID = 1L;
}