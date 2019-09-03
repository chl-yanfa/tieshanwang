package com.tieshan.api.controller.chegujiaController.v1;

import com.tieshan.api.service.chegujiaService.v1.TieshangjHistoryService;
import com.tieshan.api.util.jyInterfaceUtil.jySelectId;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "v1/cargjHistory/")
public class TieshangjHistoryController {
    @Autowired
    private TieshangjHistoryService tieshangjHistoryService;

}
