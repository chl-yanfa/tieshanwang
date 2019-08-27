package com.tieshan.api.service.shortMessageApiService.impl;

import com.tieshan.api.mapper.shortMessageApiMapper.TbVerificationCodeMapper;
import com.tieshan.api.po.shortMessageApiPo.TbVerificationCode;
import com.tieshan.api.service.shortMessageApiService.TbVerificationCodeService;
import com.tieshan.api.util.shortMessage.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TbVerificationCodeServiceImpl implements TbVerificationCodeService {
    @Autowired
    private TbVerificationCodeMapper tbVerificationCodeMapper;

    @Override
    public int insertSelective(TbVerificationCode record) {
        String sources ="0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for(int j=0;j<6;j++){
            flag.append(sources.charAt(rand.nextInt(9))+"");
        }
        System.out.println(flag.toString());
        String code =flag.toString();
        try {
            SmsSender.sendSms(record.getPhone(), SmsSender.formatmag, SmsSender.PUBLICCODE,code);
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
        record.setVerificationCode(code);
        return tbVerificationCodeMapper.insertSelective(record);
    }

    @Override
    public String getValidateCode(String phone,String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phone", phone);
        params.put("validLong", 5);
        params.put("type",type);
        String validateCodeByDB = tbVerificationCodeMapper.getValidateCode(params);
        return validateCodeByDB;
    }


}
