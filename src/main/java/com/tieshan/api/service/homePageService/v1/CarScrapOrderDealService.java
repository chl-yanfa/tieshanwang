package com.tieshan.api.service.homePageService.v1;
import com.tieshan.api.bo.homePageBo.CarScrapOrderDealBO;

import java.util.List;

public interface CarScrapOrderDealService {
    public List<CarScrapOrderDealBO> queryList();
    List<CarScrapOrderDealBO> queryListName(String modelName);
}
