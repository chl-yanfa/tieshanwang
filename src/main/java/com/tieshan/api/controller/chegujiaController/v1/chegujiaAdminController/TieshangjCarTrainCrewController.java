package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarTrainCrew;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarTrainCrewService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/carTrainCrewAdmin/")
public class TieshangjCarTrainCrewController {
    @Autowired
    private TieshangjCarTrainCrewService tieshangjCarTrainCrewService;
    @RequestMapping(value = "selectAllTC",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectAllTC(HttpServletRequest request, Map map){
        String aId=request.getParameter("aId");
        String bId=request.getParameter("bId");
        String vId=request.getParameter("vId");
        String tId=request.getParameter("tId");
        String page=request.getParameter("page");//第几页数
        String pagesize=request.getParameter("pagesize");//每页显示数量
        map.put("page",(Integer.parseInt(page)-1)*Integer.parseInt(pagesize));
        map.put("pagesize",Integer.parseInt(pagesize));
        map.put("aId",aId);
        map.put("bId",bId);
        map.put("vId",vId);
        map.put("tId",tId);
        List<TieshangjCarTrainCrew> list=tieshangjCarTrainCrewService.selectAll(map);
        Integer num= tieshangjCarTrainCrewService.selectAllCount(map);
        Map map1=new HashMap();
        map1.put("total",num);
        map1.put("rows",list);
        return ResultUtil.success(map1);
    }
    @RequestMapping(value = "selectAllTC2",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectAllTC2(HttpServletRequest request, Map map){
        String vId=request.getParameter("vId");
        map.put("vId",vId);
        List<TieshangjCarTrainCrew> list=tieshangjCarTrainCrewService.selectAll2(map);
        return ResultUtil.success(list);
    }
}
