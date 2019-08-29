package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;

import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPieces;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarWaste;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarWasteService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "v1/carwaste/")
public class TieshangjCarWasteAdminController {
    @Autowired
    private TieshangjCarWasteService tieshangjCarWasteService;

    @RequestMapping(value = "selectWaste",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectPiece(HttpServletRequest request){
        List<TieshangjCarWaste>list=tieshangjCarWasteService.selectAll();
        return ResultUtil.success(list);
    }
    @RequestMapping(value = "updateWaste",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult updateWaste(HttpServletRequest request,TieshangjCarWaste tieshangjCarWaste){
        tieshangjCarWaste.setUpdatedTime(new Date());
        int num=tieshangjCarWasteService.updateByPrimaryKeySelective(tieshangjCarWaste);
        if(num>0){
           return ResultUtil.success("修改成功");
        }
        return ResultUtil.error(500,"修改失败");
    }
}
