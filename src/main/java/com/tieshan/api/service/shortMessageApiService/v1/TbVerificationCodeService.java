package com.tieshan.api.service.shortMessageApiService.v1;
import com.tieshan.api.po.shortMessageApiPo.v1.TbVerificationCode;


public interface TbVerificationCodeService {
    int insertSelective(TbVerificationCode record);
    String getValidateCode(String phone,String type);
}
