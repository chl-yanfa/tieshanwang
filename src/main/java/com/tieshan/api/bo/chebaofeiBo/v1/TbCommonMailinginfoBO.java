package com.tieshan.api.bo.chebaofeiBo.v1;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:23
 */
@Data
public class TbCommonMailinginfoBO {
    private Integer id;

    private String mailingAddressName;

    private String mailingAddressTelephone;

    private Integer province;

    private Integer city;

    private Integer county;

    private String detailedAddress;

    private String clientid;

    private String provinceName;

    private String cityName;

    private String countyName;
}
