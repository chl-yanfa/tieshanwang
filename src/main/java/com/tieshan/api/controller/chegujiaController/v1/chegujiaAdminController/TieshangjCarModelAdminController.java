package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarModel;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarModelService;
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
public class TieshangjCarModelAdminController {
    @Autowired
    private TieshangjCarModelService tieshangjCarModelService;
    @RequestMapping(value = "selectCarModelHou",method = RequestMethod.GET)
    @ResponseBody
    public Object selectCarModelHou(HttpServletRequest request, Map map){
        String carModelName=request.getParameter("carModelName");//车型名称
        String brandName=request.getParameter("brandName");//品牌名称
        String page=request.getParameter("page");//第几页数
        String pagesize=request.getParameter("pagesize");//每页显示数量
        map.put("carModelName",carModelName);
        map.put("brandName",brandName);
        map.put("page",Integer.parseInt(page));
        map.put("pagesize",Integer.parseInt(pagesize));
        List<TieshangjCarModel> list=tieshangjCarModelService.selectAll(map);
        Integer num=tieshangjCarModelService.selectAllCount(map);
        Map map1=new HashMap();
        map1.put("total",num);
        map1.put("rows",list);
        return list;
    }
}
