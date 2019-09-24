package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientProblemBO;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientProblemMapper;
import com.tieshan.api.service.chebaofeiService.v1.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/24 9:47
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ClientProblemMapper clientProblemMapper;

    @Override
    public PageInfo<ClientProblemBO> queryPageList(Integer page, Integer rows)throws Exception{
        PageHelper.startPage(page, rows);
        List<ClientProblemBO> data = clientProblemMapper.queryPageList();
        return new PageInfo<>(data);
    }

    @Override
    public ClientProblemBO queryBOById(String id) throws Exception{
        //查询订单信息
        return clientProblemMapper.queryBOById(id);
    }
}
