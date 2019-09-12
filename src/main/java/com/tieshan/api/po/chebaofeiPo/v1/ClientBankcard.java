package com.tieshan.api.po.chebaofeiPo.v1;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * @author ningrz 个人用户银行卡管理表
 * @version 1.0
 * @date 2019/9/12 10:53
 */
@Data
@Table(name="tb_client_bankcard")
public class ClientBankcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String payeeName;

    private String bankAccount;

    private String bank;

    private String openingBank;

    private String clientid;

    private Boolean isvalid;
}
