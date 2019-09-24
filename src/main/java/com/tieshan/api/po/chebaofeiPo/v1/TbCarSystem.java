package com.tieshan.api.po.chebaofeiPo.v1;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 16:41
 */
@Data
@Table(name="tb_car_system")
public class TbCarSystem extends BasePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brandId;
    private String systemCategory;
    private String systemId;
    private String systemName;
    private String abbreviation;
    private Integer sort;
    private String source;
    private Integer isFlag;
    private Integer isDelete;
}
