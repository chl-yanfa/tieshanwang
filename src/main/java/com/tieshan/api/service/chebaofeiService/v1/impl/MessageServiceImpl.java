package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientMessageBO;
import com.tieshan.api.common.chebaofeiCommon.PageResult;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientMessageMapper;
import com.tieshan.api.po.chebaofeiPo.v1.ClientMessage;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 17:50
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<ClientMessage>
        implements MessageService {

    @Autowired
    private ClientMessageMapper clientMessageMapper;

    /**
     * 根据客户id获取未读消息条数
     * @param clientId
     * @return
     */
    @Override
    public Integer queryUnReadTotal(String clientId) {
        //查询订单信息
        return clientMessageMapper.queryUnReadTotal(clientId);
    }


    @Override
    public PageInfo<ClientMessageBO> queryPageList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<ClientMessageBO> data = clientMessageMapper.queryPageList();
        return new PageInfo<>(data);
    }

    /**
     * 根据消息id获取消息详情
     * @param id
     * @return
     */
    @Override
    public ClientMessageBO queryBOById(String id) {
        //查询订单信息
        return clientMessageMapper.queryBOById(id);
    }

    @Override
    public int changeIsread(String id) {
        return clientMessageMapper.changeIsRead(id);
    }
}
