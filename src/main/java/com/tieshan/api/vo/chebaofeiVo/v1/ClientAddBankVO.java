package com.tieshan.api.vo.chebaofeiVo.v1;

import com.tieshan.api.po.chebaofeiPo.v1.ClientBankcard;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 11:00
 */
@Data
public class ClientAddBankVO extends ClientBankcard {

    @ApiModelProperty(value = "用户真实姓名")
    private String payeeName;

    @ApiModelProperty(value = "银行卡号")
    private String bankAccount;

    @ApiModelProperty(value = "所属银行")
    private String bank;

    @ApiModelProperty(value = "开户行")
    private String openingBank;
}
