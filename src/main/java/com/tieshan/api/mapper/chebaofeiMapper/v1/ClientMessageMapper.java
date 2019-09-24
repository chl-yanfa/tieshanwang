package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientMessageBO;
import com.tieshan.api.po.chebaofeiPo.v1.ClientMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 17:54
 */
@Repository
public interface ClientMessageMapper extends Mapper<ClientMessage> {

    Integer queryUnReadTotal(String clientId);

    List<ClientMessageBO> queryPageList();

    ClientMessageBO queryBOById(String id);

    int changeIsRead(String id);
}
