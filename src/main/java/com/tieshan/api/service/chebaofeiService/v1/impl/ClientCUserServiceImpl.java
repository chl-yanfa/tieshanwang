package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.common.chebaofeiCommon.CommonSystemParamter;
import com.tieshan.api.common.chebaofeiCommon.Exception.CheckException;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataExistException;
import com.tieshan.api.common.chebaofeiCommon.Exception.UserNamePasswordException;
import com.tieshan.api.common.chebaofeiCommon.SystemParameter;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientBankcardMapper;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientMapper;
import com.tieshan.api.po.chebaofeiPo.v1.ClientBankcard;
import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import com.tieshan.api.service.chebaofeiService.v1.ClientCUserService;
import com.tieshan.api.util.shortMessage.SmsSender;
import com.tieshan.api.util.toolUtil.CheckUtil;
import com.tieshan.api.util.toolUtil.StringUtils;
import com.tieshan.api.util.toolUtil.UUIDUtil;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private ClientBankcardMapper clientBankcardMapper;

    @Autowired
    private RedisTemplate redisTemplate;

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
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String key = SystemParameter.TICKET + ticket;
        String value = operations.get(key);
        if (org.apache.commons.lang3.StringUtils.isBlank(value)) {
            return null;
        }
        ClientBO user = SystemParameter.MAPPER.readValue(value, ClientBO.class);
        operations.set(SystemParameter.TICKET+ticket, value,3600 * 24 * 30, TimeUnit.SECONDS);
        return user;
    }

    @Override
    public Boolean setPwd(String id, String oldPassword, String newPassword, String operator, String loginName) throws Exception {
        ClientBO client = clientMapper.getClientById(id);
        if(client==null){
            throw new DataException("用户不存在");
        }
        String hashpass = StringUtils.createPassword(oldPassword,client.getPasswordSalt(), CommonSystemParamter.HASHITERATIONS);
        if(StringUtils.equals(hashpass, client.getPassword())){
            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            client.setId(id);
            client.setPasswordSalt(salt);
            client.setPassword(StringUtils.createPassword(newPassword, salt, 2));
            client.setOperator(operator);
            clientMapper.updatePwd(client);
            return true;
        }else{
            throw new UserNamePasswordException("密码输入错误");
        }
    }

    @Override
    public Boolean getValidateCode(String phone) {
        String sources ="0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for(int j=0;j<6;j++){
            flag.append(sources.charAt(rand.nextInt(9))+"");
        }
        System.out.println(flag.toString());
        String code =flag.toString();
        try {
            SmsSender.sendSms(phone, SmsSender.formatmag, SmsSender.PUBLICCODE,code);
        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000L);}
        catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("type", 0);
        map.put("code", code);
        map.put("phone", phone);
        clientMapper.insertVerificationCode(map);
        return true;
    }

    @Override
    public ClientBO queryUserById(String id) {
        ClientBO bo = clientMapper.getClientById(id);
        return bo;
    }

    @Override
    public ClientBO queryUserByPhone(String phone) {
        List<ClientBO> list = clientMapper.getClientByPhone(phone);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Boolean doRegister(ClientVO clientVO) throws Exception {
        SysClient params =new SysClient();
        String loginName = clientVO.getLoginName();
        if(!loginName.matches("[0-9a-zA-Z]{4,23}")) {
            throw new CheckException("用户名只能输入字母或数字");
        }
        params.setPhone(clientVO.getPhone());
        params.setStatus("1");
        SysClient selectOne = clientMapper.selectOne(params);
        if(selectOne!=null) {
            throw new DataExistException("手机号码重复");
        }
        SysClient params2 =new SysClient();
        params2.setLoginName(loginName);
        params2.setStatus("1");
        SysClient selectOne2 = clientMapper.selectOne(params2);
        if(selectOne2!=null) {
            throw new DataExistException("用户名重复");
        }
        /**
         * 校验手机验证码
         */
        String validateCodeByDB = verifyValidateCode(clientVO.getPhone());
        if(StringUtils.isBlank(validateCodeByDB)||!StringUtils.equals(clientVO.getValidateCode(), validateCodeByDB)) {
            throw new DataException("验证码错误");
        }
        /**
         * 新增用户,userType=1,certification_state = 0
         */
        SysClient client =new SysClient();
        BeanUtils.copyProperties(clientVO, client);
        client.setId(UUIDUtil.getUUID());
        client.setUserType("1");
        client.setCertificationState(0);
        client.setStatus("1");
        client.setCreater(client.getId());
        client.setCreatetime(new Date());
        if(StringUtils.isNotBlank(clientVO.getPassword())) {
            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            client.setPasswordSalt(salt);
            client.setPassword(StringUtils.createPassword(clientVO.getPassword(), salt, 2));
        }
        clientMapper.insertSelective(client);
        return true;
    }

    @Override
    public Boolean certification(ClientCertificationVO vo) throws Exception {
        CheckUtil.notNull(vo, "param.is.null");
        CheckUtil.notEmpty(vo.getId(), "param.is.null");
        CheckUtil.notEmpty(vo.getUserName(), "param.is.null");
        CheckUtil.notEmpty(vo.getIdCard(), "param.is.null");
        CheckUtil.notNull(vo.getFrontIdCard(), "param.is.null");
        CheckUtil.notNull(vo.getBackIdCard(), "param.is.null");
        CheckUtil.notNull(vo.getHandIdCard(), "param.is.null");
        SysClient clientByDB = clientMapper.getClientById(vo.getId());
        if(clientByDB==null){
            throw new DataException("数据不存在");
        }
        SysClient client =new SysClient();
        BeanUtils.copyProperties(vo, client);
        client.setId(vo.getId());
        client.setUserName(vo.getUserName());
        client.setIdCard(vo.getIdCard());
        client.setFrontIdCard(vo.getFrontIdCard());
        client.setBackIdCard(vo.getBackIdCard());
        client.setHandIdCard(vo.getHandIdCard());
        client.setCertificationState(1);
        client.setCertificationSubmitTime(new Date());
        client.setOperatortime(new Date());
        clientMapper.updateCertification(client);
        return true;
    }

    @Override
    public ClientBankCardBO queryUserBankCard(String clientid) throws Exception {
        ClientBankcard params =new ClientBankcard();
        params.setClientid(clientid);
        params.setIsvalid(true);
        List<ClientBankcard> list = clientBankcardMapper.select(params);
        if(list!=null && list.size()>0) {
            ClientBankCardBO bo = new ClientBankCardBO();
            BeanUtils.copyProperties(list.get(0), bo);
            return bo;
        }
        return null;
    }

    @Override
    public Boolean addBankCard(ClientAddBankVO vo) throws Exception {
        CheckUtil.notNull(vo, "param.is.null");
        CheckUtil.notEmpty(vo.getClientid(), "param.is.null");
        CheckUtil.notEmpty(vo.getPayeeName(), "param.is.null");
        CheckUtil.notEmpty(vo.getBankAccount(), "param.is.null");
        CheckUtil.notEmpty(vo.getBank(), "param.is.null");
        CheckUtil.notEmpty(vo.getOpeningBank(), "param.is.null");
        SysClient clientByDB = clientMapper.getClientById(vo.getClientid());
        //验证用户信息是否存在
        if(clientByDB==null||clientByDB.getCertificationState()!=CommonSystemParamter.CLIENT_CERTIFICATION_ED_STATE){
            throw new DataException("用户不存在");
        }
        //验证银行卡名称
        if(!vo.getPayeeName().equals(clientByDB.getUserName())) {
            throw new DataException("用户名不一致");
        }
        ClientBankcard clientBankcard =new ClientBankcard();
        BeanUtils.copyProperties(vo, clientBankcard);
        clientBankcard.setIsvalid(true);
        //验证银行卡是否存在(目前只能存一个)
        ClientBankcard params =new ClientBankcard();
        params.setClientid(vo.getClientid());
        params.setIsvalid(true);
        ClientBankcard selectOne = clientBankcardMapper.selectOne(params);
        if(selectOne!=null) {
            clientBankcard.setId(selectOne.getId());
            clientBankcard.setOperator(vo.getClientid());
            clientBankcard.setOperatortime(new Date());
            clientBankcardMapper.updateBankCard(clientBankcard);
        }else {
            clientBankcard.setCreater(vo.getClientid());
            clientBankcard.setCreatetime(new Date());
            clientBankcardMapper.insertSelective(clientBankcard);
        }
        return true;
    }

    @Override
    public String verifyValidateCode(String phone) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phone", phone);
        params.put("validLong", 5);
        return clientMapper.getValidateCode(params);
    }

    @Override
    public Boolean forgetPwd(String id, String newPwd, String operator) throws Exception {
        SysClient client = clientMapper.getClientById(id);
        if (client == null) {
            throw new DataException("用户不存在");
        }
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        client.setPasswordSalt(salt);
        client.setPassword(StringUtils.createPassword(newPwd, salt, 2));
        client.setOperator(operator);
        clientMapper.updatePwd(client);
        return true;
    }
}
