package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCityInfo;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCityInfoService;
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
@RequestMapping(value = "v1/city/")
public class TieshangjCityInfoController {
    @Autowired
    private TieshangjCityInfoService tieshangjCityInfoService;
    @RequestMapping(value = "selectCityByPid",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCityByPid(HttpServletRequest request){
        String pid=request.getParameter("pid");
        List<TieshangjCityInfo> list=tieshangjCityInfoService.selectProvid(pid);
        return ResultUtil.success(list);
    }
}
