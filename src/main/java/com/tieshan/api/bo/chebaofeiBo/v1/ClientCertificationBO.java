package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 10:35
 */
@Data
public class ClientCertificationBO {
    private String id;

    private String userName;

    private String phone;

    private String idCard;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date certificationSubmitTime;

    private String certificationState;

    private String frontIdCard;

    private String backIdCard;

    private String handIdCard;

    private String certificationMemo;
}
