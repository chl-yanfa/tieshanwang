package com.tieshan.api.mapper.homePageMapper.v1;

import com.tieshan.api.bo.homePageBo.CarScrapOrderDealBO;

import java.util.List;

public interface CarScrapOrderDealMapper {
     List<CarScrapOrderDealBO> queryList();
     List<CarScrapOrderDealBO> queryListName(String modelName);
}
