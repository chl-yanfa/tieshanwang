package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.service.chebaofeiService.v1.ClientCUserService;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 11:10
 */
@Service
public class ClientCUserServiceImpl implements ClientCUserService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public ClientBO queryClientBOByNameOrPhone(String loginname) throws Exception {
        return null;
    }

    @Override
    public ClientBO doLogin(String loginName, String password) throws Exception {
        //根据用户名查询用户
        ClientBO user = this.queryClientBOByNameOrPhone(loginName);

        return null;
    }

    @Override
    public ClientBO queryUserByTicket(String ticket) throws Exception {
        return null;
    }

    @Override
    public Boolean setPwd(String id, String oldPassword, String newPassword, String operator, String loginName) throws Exception {
        return null;
    }

    @Override
    public Boolean getValidateCode(String phone) throws Exception {
        return null;
    }

    @Override
    public ClientBO queryUserById(String id) throws Exception {
        return null;
    }

    @Override
    public ClientBO queryUserByPhone(String phone) throws Exception {
        return null;
    }

    @Override
    public Boolean doRegister(ClientVO clientVO) throws Exception {
        return null;
    }

    @Override
    public Boolean certification(ClientCertificationVO clientVO) throws Exception {
        return null;
    }

    @Override
    public ClientBankCardBO queryUserBankCard(String clientid) throws Exception {
        return null;
    }

    @Override
    public Boolean addBankCard(ClientAddBankVO clientVO) throws Exception {
        return null;
    }

    @Override
    public Boolean verifyValidateCode(String phone, String validateCode) throws Exception {
        return null;
    }

    @Override
    public Boolean forgetPwd(String id, String newPwd, String operator) throws Exception {
        return null;
    }
}
