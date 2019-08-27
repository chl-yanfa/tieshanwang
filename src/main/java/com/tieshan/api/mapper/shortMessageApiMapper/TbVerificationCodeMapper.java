package com.tieshan.api.mapper.shortMessageApiMapper;

import com.tieshan.api.po.shortMessageApiPo.TbVerificationCode;

import java.util.Map;

public interface TbVerificationCodeMapper {
    int insertSelective(TbVerificationCode record);
    String getValidateCode(Map<String, Object> params);
}