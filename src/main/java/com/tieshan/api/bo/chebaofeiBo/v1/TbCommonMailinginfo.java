package com.tieshan.api.bo.chebaofeiBo.v1;

import com.tieshan.api.po.chebaofeiPo.v1.BasePojo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:05
 */
@Data
@Table(name="tb_common_mailinginfo")
public class TbCommonMailinginfo extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mailingAddressName;

    private String mailingAddressTelephone;

    private Integer province;

    private Integer city;

    private Integer county;

    private String detailedAddress;

    private String clientid;
}
