package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientCertificationBO;
import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 10:31
 */
@Repository
public interface ClientMapper extends Mapper<SysClient> {

    List<ClientBO> queryClientBOByName(String loginname);

    int insertVerificationCode(Map<String,Object> map);

    String getValidateCode(Map<String, Object> params);

    List<ClientBO> queryClientBOByNameOrPhone(@Param("nameOrPhone") String nameOrPhone);

    ClientBO getClientById(String id);

    int updatePwd(SysClient sysClient);

    int updateCertification(SysClient sysClient);

    List<ClientBO> getClientByPhone(String phone);

    List<ClientCertificationBO> queryPageUserCertification(ClientVO clientVO);

    ClientCertificationBO queryUserCertification(String id);
}
