package com.tieshan.api.controller.tieshanpaiController.v1.auction;


import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获得所有结束的拍品和拍卖会
 * @author ningrz
 * @version 1.0
 * @date 2019/8/29 11:24
 */
@RestController
@CrossOrigin
public class getEndTimeController {

    @Autowired
    CarPmAuctionService carPmAuctionService;


    @RequestMapping(value = "getEndTimeList",method = RequestMethod.GET)
    public List<CarPmAuctionVo> getEndTimeList(){
        return carPmAuctionService.getEndTime();
    }

}
