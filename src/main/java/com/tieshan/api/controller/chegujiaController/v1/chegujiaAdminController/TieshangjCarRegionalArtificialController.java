package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarRegionalArtificialService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping(value = "v1/carRegionalArtificial/")
public class TieshangjCarRegionalArtificialController {
    @Autowired
    private TieshangjCarRegionalArtificialService tieshangjCarRegionalArtificialService;
    @RequestMapping(value = "selectArtifi2",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectArtifi2(HttpServletRequest request){
        String ctid=request.getParameter("ctid");
        String pid=request.getParameter("pid");
        String tieshangjCarRegionalArtificial=tieshangjCarRegionalArtificialService.selectArtifi2(ctid,pid);
        return ResultUtil.success(tieshangjCarRegionalArtificial);
    }
}
