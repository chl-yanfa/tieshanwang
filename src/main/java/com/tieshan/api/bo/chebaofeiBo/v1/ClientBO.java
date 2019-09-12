package com.tieshan.api.bo.chebaofeiBo.v1;

import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 10:51
 */
@Data
public class ClientBO extends SysClient {

    private Integer areaid;
    private String areaName;
    private String customerName;
    private String bankAccount;
    private String bank;
    private String openingBank;
    private BigDecimal walletPledge;		//保证金
    private BigDecimal walletPledgeFreeze;	//冻结保证金
    private Integer isScrapOrde;		//整车:0:暂无订单,1:有订单
    private Integer isPartsOrde;		//旧件:0:暂无订单,1:有订单
    private String phone;
}
