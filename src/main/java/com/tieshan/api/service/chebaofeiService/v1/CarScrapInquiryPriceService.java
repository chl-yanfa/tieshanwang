package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapInquiryPriceBO;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapInquiryPriceVO;
import org.springframework.stereotype.Service;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:30
 */
public interface CarScrapInquiryPriceService {
    Integer save(CarScrapInquiryPriceVO record)throws Exception ;
}
