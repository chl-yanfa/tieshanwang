package com.tieshan.api.po.chebaofeiPo.v1;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:43
 */
@Data
@Table(name="tb_attachment")
public class TbAttachment extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String originalName;

    private String storagePath;

    private String ossKey;

    private Boolean isvalid=true;
}
