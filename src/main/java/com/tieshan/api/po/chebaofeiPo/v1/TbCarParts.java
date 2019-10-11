package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 14:42
 */
@Data
@Table(name="tb_car_parts")
public class TbCarParts extends BasePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partsName;

    private Integer partsCategoryId;

    @JsonIgnore
    private Boolean isvalid;
}
