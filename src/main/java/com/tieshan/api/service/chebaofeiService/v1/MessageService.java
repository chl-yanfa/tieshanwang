package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientMessageBO;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.po.chebaofeiPo.v1.ClientMessage;
import com.tieshan.api.service.BaseService;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 17:47
 */
public interface MessageService extends BaseService<ClientMessage> {

    Integer queryUnReadTotal(String clientId)throws Exception;

    PageInfo<ClientMessageBO> queryPageList(Integer page, Integer rows)throws Exception;

    ClientMessageBO queryBOById(String id)throws Exception;

    int changeIsread(String id)throws Exception;
}
