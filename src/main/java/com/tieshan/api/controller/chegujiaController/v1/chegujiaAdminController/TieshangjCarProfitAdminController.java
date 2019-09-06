package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPieces;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarProfit;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPieceService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPiecesService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarProfitService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1/carprofi/")
public class TieshangjCarProfitAdminController {
    @Autowired
    private TieshangjCarPieceService tieshangjCarPieceService;
    @Autowired
    private TieshangjCarPiecesService tieshangjCarPiecesService;
    @Autowired
    private TieshangjCarProfitService tieshangjCarProfitService;
    @RequestMapping(value = "selectPiece",method = RequestMethod.GET)
    @ResponseBody
    public Object selectPiece(HttpServletRequest request, Map map){
        String tiema=request.getParameter("tiema");
        List<TieshangjCarPiece> list=tieshangjCarPieceService.selectYi("1");
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        for (TieshangjCarPiece tieshangjCarPiece : list) {
            EncapsulationBO dsbo = new EncapsulationBO();
            dsbo.setType(tieshangjCarPiece.getPieceName());
            List<TieshangjCarPieces>list2=tieshangjCarPiecesService.selectEr(tiema,tieshangjCarPiece.getId().toString());
            if(list2!=null){
                dsbo.setChildren2(list2);
            }
            encapsulationBOS.add(dsbo);
        }

        return encapsulationBOS;
    }
    //根据铁码查询系数
    @RequestMapping(value = "selectProfi",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectProfi(HttpServletRequest request){
        String tiema=request.getParameter("tiema");
        TieshangjCarProfit tieshangjCarProfit=tieshangjCarProfitService.selectTie(tiema);
        return ResultUtil.success(tieshangjCarProfit);
    }
    //修改
    @RequestMapping(value = "updateProfi",method = RequestMethod.PUT)
    @ResponseBody
    public ApiResult updateProfi(HttpServletRequest request,TieshangjCarProfit tieshangjCarProfit){
        int num=tieshangjCarProfitService.updateByPrimaryKeySelective(tieshangjCarProfit);
        if(num>0){
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.error(500,"修改失败");
    }
    //新增
    @RequestMapping(value = "insertProfi",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult insertProfi(HttpServletRequest request,TieshangjCarProfit tieshangjCarProfit){
        tieshangjCarProfit.setCreatedBy("测试人员");
        tieshangjCarProfit.setCreatedTime(new Date());
        tieshangjCarProfit.setUpdatedBy("测试人员");
        tieshangjCarProfit.setUpdatedTime(new Date());
        int num=tieshangjCarProfitService.insertSelective(tieshangjCarProfit);
        if(num>0){
            return ResultUtil.success("新增成功");
        }
        return ResultUtil.error(500,"新增失败");
    }
}
