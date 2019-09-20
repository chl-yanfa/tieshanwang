package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientCertificationBO;
import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import com.tieshan.api.service.BaseService;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:02
 */
public interface ClientService extends BaseService<SysClient> {

    ClientBO queryClientBOByName(String loginname)throws Exception;

    Boolean resetPassword(String id,String oldpassword,String newpassword,String operator)throws Exception;

    Boolean validateCode(String phone) throws Exception;

    ClientBO queryClientBOByNameOrPhone(String whereParam)throws Exception;

    ClientBO getClientById(String id)throws Exception;

    ClientBO getClientByPhone(String phone)throws Exception;

    Boolean doRegister(ClientVO clientVO)throws Exception;

    Boolean certification(ClientCertificationVO vo)throws Exception;

    ClientBankCardBO queryUserBankCard(String clientid)throws Exception;

    Boolean addBankCard(ClientAddBankVO vo)throws Exception;

    String verifyValidateCode(String phone)throws Exception;

    Boolean forgetPwd(String id,String newpassword,String operator)throws Exception;

    PageInfo<ClientCertificationBO> queryUserCertificationList(Integer page, Integer rows, ClientVO vo) throws Exception;

    ClientCertificationBO queryUserCertification(String id) throws Exception;

    Boolean auditCertification(ClientVO clientVO)throws Exception;

}
