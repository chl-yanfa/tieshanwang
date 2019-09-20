package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.po.chebaofeiPo.v1.ClientBankcard;
import org.springframework.stereotype.Repository;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 15:58
 */
@Repository
public interface ClientBankcardMapper extends Mapper<ClientBankcard> {

    int updateBankCard(ClientBankcard clientBankcard);
}
