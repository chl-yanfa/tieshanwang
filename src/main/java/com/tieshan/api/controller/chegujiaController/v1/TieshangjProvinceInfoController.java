package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjProvinceInfo;
import com.tieshan.api.service.chegujiaService.v1.TieshangjProvinceInfoService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "v1/province/")
public class TieshangjProvinceInfoController {
    @Autowired
    private TieshangjProvinceInfoService tieshangjProvinceInfoService;
    @RequestMapping(value = "selectProvince",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectProvince(HttpServletRequest request){
        List<TieshangjProvinceInfo> list=tieshangjProvinceInfoService.selectAll();
        return ResultUtil.success(list);
    }
}
