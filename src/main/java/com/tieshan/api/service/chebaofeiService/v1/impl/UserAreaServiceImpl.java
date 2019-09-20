package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.UserAreaMapper;
import com.tieshan.api.po.chebaofeiPo.v1.UserArea;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.UserAreaService;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:54
 */
@Service
public class UserAreaServiceImpl extends BaseServiceImpl<UserArea> implements UserAreaService {

    private UserAreaMapper userAreaMapper;

}
