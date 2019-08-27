package com.tieshan.api.service.shortMessageApiService;

import com.tieshan.api.po.shortMessageApiPo.TbVerificationCode;

import java.util.Map;

public interface TbVerificationCodeService {
    int insertSelective(TbVerificationCode record);
    String getValidateCode(String phone,String type);
}
