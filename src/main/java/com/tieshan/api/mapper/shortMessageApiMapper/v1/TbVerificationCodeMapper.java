package com.tieshan.api.mapper.homePageMapper.v1;

import com.tieshan.api.po.shortMessageApiPo.v1.TbVerificationCode;

import java.util.Map;

public interface TbVerificationCodeMapper {
    int insertSelective(TbVerificationCode record);
    String getValidateCode(Map<String, Object> params);
}