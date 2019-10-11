package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 13:57
 */
@Data
@Table(name="tb_car_parts_category")
public class TbCarPartsCategory extends BasePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partsCategoryName;

    @JsonIgnore
    private Boolean isvalid;
}
