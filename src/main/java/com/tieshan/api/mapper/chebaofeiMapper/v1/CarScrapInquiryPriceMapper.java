package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapInquiryPriceBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapInquiryPrice;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapInquiryPricePageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:54
 */
@Repository
public interface CarScrapInquiryPriceMapper extends Mapper<CarScrapInquiryPrice> {
    List<CarScrapInquiryPriceBO> queryPageListByWhere(CarScrapInquiryPricePageVO vo);
}
