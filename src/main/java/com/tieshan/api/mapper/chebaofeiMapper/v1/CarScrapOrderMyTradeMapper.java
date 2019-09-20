package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderMyTradeBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderMyTradeInfoBO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:49
 */
@Repository
public interface CarScrapOrderMyTradeMapper {

     CarScrapOrderMyTradeBO queryMyTrade(String clientId);

     List<CarScrapOrderMyTradeInfoBO> queryPageMyTradeInfo(String clientId);
}
