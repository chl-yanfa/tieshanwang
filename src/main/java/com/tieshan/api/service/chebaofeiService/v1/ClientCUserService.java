package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/12 9:43
 */

public interface ClientCUserService {

    ClientBO queryClientBOByNameOrPhone(String whereParam)throws Exception;

    ClientBO doLogin(String loginName, String password)throws Exception;

    ClientBO queryUserByTicket(String ticket) throws Exception;

    Boolean setPwd(String id,String oldPassword, String newPassword,String operator,String loginName)throws Exception;

    Boolean getValidateCode(String phone) throws Exception;

    ClientBO queryUserById(String id) throws Exception;

    ClientBO queryUserByPhone(String phone) throws Exception;

    Boolean doRegister(ClientVO clientVO)throws Exception;

    Boolean certification(ClientCertificationVO clientVO)throws Exception;

    ClientBankCardBO queryUserBankCard(String clientid) throws Exception;

    Boolean addBankCard(ClientAddBankVO clientVO)throws Exception;

    String verifyValidateCode(String phone)throws Exception;

    Boolean forgetPwd(String id, String newPwd,String operator)throws Exception;

}
