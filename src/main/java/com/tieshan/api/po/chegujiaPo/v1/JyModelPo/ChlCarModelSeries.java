package com.tieshan.api.po.chegujiaPo.v1.JyModelPo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChlCarModelSeries implements Serializable {
    private Integer id;

    private String vehicleSystemName;

    private Integer brandId;

    private Integer state;

    private Date createdTime;

    private String createdBy;

    private String updatedBy;

    private Date updatedTime;

    private String vehicleSystemCode;

    private static final long serialVersionUID = 1L;

    private Integer sid;

    private Integer bid;

    private String brname;

    private ChlAutoLogos chlAutoLogos;
}