package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.common.chebaofeiCommon.Exception.UserNamePasswordException;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientMapper;
import com.tieshan.api.service.chebaofeiService.v1.ClientCUserService;
import com.tieshan.api.util.toolUtil.StringUtils;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 11:10
 */
@Service
public class ClientCUserServiceImpl implements ClientCUserService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientBO queryClientBOByNameOrPhone(String loginname){
        List<ClientBO> client = clientMapper.queryClientBOByNameOrPhone(loginname);
        System.out.println(client.get(0).getPasswordSalt() + client.get(0).getStatus());
        if (client == null) {
            throw new UserNamePasswordException("用户名密码错误");
        } else if (client.size() == 0) {
            throw new UserNamePasswordException("用户名密码错误");
        } else if (client.size() > 1) {
            throw new AccountException("账号异常");
        } else {
            return client.get(0);
        }
    }

    @Override
    public ClientBO doLogin(String loginName, String password) {
        try{
            //根据用户名查询用户
            ClientBO user = queryClientBOByNameOrPhone(loginName);
            if(user==null){
                throw new DataException("未找到该用户!");
            }else{
                System.out.println(user.getPasswordSalt());
                String paramPwd = StringUtils.createPassword(password, user.getPasswordSalt(), 2);
                String orgiPassword = user.getPassword();
                if(StringUtils.equals(paramPwd, orgiPassword)){
                    return user;
                }else{
                    throw new UserNamePasswordException("用户名密码错误");
                }
            }
        }catch (Exception e){
           e.printStackTrace();
        }
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
