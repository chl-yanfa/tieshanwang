package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarModelService;
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
@RequestMapping(value = "v1/carmodelAdmin/")
public class TieshangjCarModelAdminController {
    @Autowired
    private TieshangjCarModelService tieshangjCarModelService;
    @RequestMapping(value = "selectCarModelHou",method = RequestMethod.GET)
    @ResponseBody
    public Object selectCarModelHou(HttpServletRequest request, Map map){
        String carModelName=request.getParameter("carModelName");//车型名称
        String brandId=request.getParameter("brandId");//车标id
        String page=request.getParameter("page");//第几页数
        String pagesize=request.getParameter("pagesize");//每页显示数量
        map.put("carModelName",carModelName);
        map.put("brandId",brandId);
        map.put("page",(Integer.parseInt(page)-1)*Integer.parseInt(pagesize));
        map.put("pagesize",Integer.parseInt(pagesize));
        List<TieshangjCarModel> list=tieshangjCarModelService.selectAll(map);
        Integer num=tieshangjCarModelService.selectAllCount(map);
        Map map1=new HashMap();
        map1.put("total",num);
        map1.put("rows",list);
        return map1;
    }
    @RequestMapping(value = "selectCarModelbyId",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectCarModelbyId(HttpServletRequest request){
        String carModelId=request.getParameter("carModelId");//车型id
        TieshangjCarModel tieshangjCarModel=tieshangjCarModelService.selectByPrimaryKey(Integer.parseInt(carModelId));
        return ResultUtil.success(tieshangjCarModel);
    }
}
