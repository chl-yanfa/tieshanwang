package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.UserRoleMapper;
import com.tieshan.api.po.chebaofeiPo.v1.UserRole;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 15:10
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements
        UserRoleService {
    private UserRoleMapper userRoleMapper;
}
