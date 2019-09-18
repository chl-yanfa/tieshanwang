package com.tieshan.api.controller.chebaofeiController.v1;

import com.tieshan.api.common.chebaofeiCommon.ResultBean;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapInquiryPriceService;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapInquiryPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:25
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/carscraporder-applet/inquiryprice")
public class CarScrapInquiryPriceController {

    @Autowired
    private CarScrapInquiryPriceService carScrapInquiryPriceService;

    /**
     * 新增询价
     *
     * @param inquiryPriceVO 页面传递询价数据
     * @return
     * @throws Exception
     *
     */
    @RequestMapping(value = "/addInquiryprice",method = RequestMethod.POST)
    public ResultBean<Boolean> addOrder(@RequestBody CarScrapInquiryPriceVO inquiryPriceVO, BindingResult bindingResult)
            throws Exception {

        return new ResultBean<Boolean>(carScrapInquiryPriceService.save(inquiryPriceVO)==1);

    }
}

