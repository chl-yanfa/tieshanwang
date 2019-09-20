package com.tieshan.api.service.chebaofeiService.v1.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientBankCardBO;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientCertificationBO;
import com.tieshan.api.common.chebaofeiCommon.CommonSystemParamter;
import com.tieshan.api.common.chebaofeiCommon.Exception.*;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientBankcardMapper;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientCertificationRecordMapper;
import com.tieshan.api.mapper.chebaofeiMapper.v1.ClientMapper;
import com.tieshan.api.po.chebaofeiPo.v1.ClientBankcard;
import com.tieshan.api.po.chebaofeiPo.v1.ClientCertificationRecord;
import com.tieshan.api.po.chebaofeiPo.v1.SysClient;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.ClientService;
import com.tieshan.api.util.shortMessage.SmsSender;
import com.tieshan.api.util.toolUtil.CheckUtil;
import com.tieshan.api.util.toolUtil.StringUtils;
import com.tieshan.api.util.toolUtil.UUIDUtil;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientAddBankVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientCertificationVO;
import com.tieshan.api.vo.chebaofeiVo.v1.ClientVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ClientServiceImpl extends BaseServiceImpl<SysClient> implements
        ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientBankcardMapper clientBankcardMapper;
    @Autowired
    private ClientCertificationRecordMapper clientCertificationRecordMapper;

    public ClientBO queryClientBOByName(String loginname)throws Exception{

        List<ClientBO> client = clientMapper.queryClientBOByName(loginname);

        if(client==null){
            //用戶名密码错误
            throw new UserNamePasswordException("用户名密码错误");
        }else if(client.size()==0){
            //用戶名密码错误
            throw new UserNamePasswordException("用户名密码错误");
        }else if (client.size()>1){
            //账号异常
            throw new AccountException("账号异常");
        }else{
            return client.get(0);
        }



    }


    public Boolean resetPassword(String id,String oldpassword,String newpassword,String operator)throws Exception{

        SysClient client = clientMapper.selectByPrimaryKey(id);

        if(client==null){
            throw new DataException("数据不存在");
        }


        String hashpass = StringUtils.createPassword(oldpassword,client.getPasswordSalt(), CommonSystemParamter.HASHITERATIONS);
        if(StringUtils.equals(hashpass, client.getPassword())){
            String salt = UUID.randomUUID().toString().replaceAll("-", "");
            client.setPasswordSalt(salt);
            client.setPassword(StringUtils.createPassword(newpassword, salt, 2));
            client.setOperator(operator);
            clientMapper.updateByPrimaryKey(client);
            return true;
        }else{
            throw new UserNamePasswordException("密码输入错误");
        }



    }

    public Boolean validateCode(String phone)throws Exception {
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
    public ClientBO queryClientBOByNameOrPhone(String whereParam) throws Exception {
        List<ClientBO> client = clientMapper.queryClientBOByNameOrPhone(whereParam);
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
    public ClientBO getClientById(String id) throws Exception {
        ClientBO bo = clientMapper.getClientById(id);
        return bo;
    }

    @Override
    public ClientBO getClientByPhone(String phone) throws Exception {
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
        SysClient clientByDB = clientMapper.selectByPrimaryKey(vo.getId());
        if(clientByDB==null){
            throw new DataException("数据不存在");
        }
        SysClient client =new SysClient();
        BeanUtils.copyProperties(vo, client);
        client.setCertificationState(1);
        client.setCertificationSubmitTime(new Date());
        client.setOperatortime(new Date());
        clientMapper.updateByPrimaryKeySelective(client);
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
        SysClient clientByDB = clientMapper.selectByPrimaryKey(vo.getClientid());
        //验证用户信息是否存在
        if(clientByDB==null||clientByDB.getCertificationState()!=CommonSystemParamter.CLIENT_CERTIFICATION_ED_STATE){
            throw new DataException("数据不存在");
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
            clientBankcardMapper.updateByPrimaryKeySelective(clientBankcard);
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
        String validateCodeByDB = clientMapper.getValidateCode(params);
        return validateCodeByDB;
    }

    @Override
    public Boolean forgetPwd(String id, String newpassword, String operator) throws Exception {
        SysClient client = clientMapper.selectByPrimaryKey(id);
        if (client == null) {
            throw new DataException("数据不存在");
        }
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        client.setPasswordSalt(salt);
        client.setPassword(StringUtils.createPassword(newpassword, salt, 2));
        client.setOperator(operator);
        clientMapper.updateByPrimaryKeySelective(client);
        return true;
    }


    @Override
    public PageInfo<ClientCertificationBO> queryUserCertificationList(Integer page, Integer rows, ClientVO clientVO)
            throws Exception {
        PageHelper.startPage(page, rows);
        List<ClientCertificationBO> listData = clientMapper.queryPageUserCertification(clientVO);

        return new PageInfo<ClientCertificationBO>(listData);
    }


    @Override
    public ClientCertificationBO queryUserCertification(String id) throws Exception {

        return clientMapper.queryUserCertification(id);
    }


    @Override
    public Boolean auditCertification(ClientVO clientVO) throws Exception {
        CheckUtil.notNull(clientVO, "param.is.null");
        CheckUtil.notEmpty(clientVO.getId(), "param.is.null");
        CheckUtil.notNull(clientVO.getCertificationState(), "param.is.null");
        if(clientVO.getCertificationState() != CommonSystemParamter.CLIENT_CERTIFICATION_ED_STATE&&clientVO.getCertificationState() != CommonSystemParamter.CLIENT_CERTIFICATION_REFUSE_STATE) {
            throw new DataException("审核传入状态异常");
        }
        SysClient clientByDB = clientMapper.selectByPrimaryKey(clientVO.getId());
        if(clientByDB==null){
            throw new DataException("数据不存在");
        }
        if(clientByDB.getCertificationState() != CommonSystemParamter.CLIENT_CERTIFICATION_TOAUDIT_STATE) {
            throw new DataException("数据状态异常");
        }
        SysClient client =new SysClient();
        BeanUtils.copyProperties(clientVO, client);
        client.setCertificationAuditUser(clientVO.getOperator());
        client.setCertificationAuditTime(new Date());
        client.setOperatortime(new Date());
        clientMapper.updateByPrimaryKeySelective(client);
        //新增实名记录
        ClientCertificationRecord record =new ClientCertificationRecord();
        record.setId(UUIDUtil.getUUID());
        record.setAuditTime(new Date());
        record.setAuditUser(clientVO.getOperator());
        record.setClientid(clientByDB.getId());
        record.setCreater(clientByDB.getId());
        record.setCreatetime(new Date());
        record.setMemo(clientVO.getCertificationMemo());
        record.setState(clientVO.getCertificationState()==CommonSystemParamter.CLIENT_CERTIFICATION_ED_STATE?
                CommonSystemParamter.CLIENT_CERTIFICATION_RECORD_AGREE_STATE:CommonSystemParamter.CLIENT_CERTIFICATION_RECORD_REFUSE_STATE);
        clientCertificationRecordMapper.insert(record);
        return true;
    }
}
