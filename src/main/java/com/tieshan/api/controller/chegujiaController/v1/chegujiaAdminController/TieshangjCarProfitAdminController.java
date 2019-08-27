package com.tieshan.api.controller.chegujiaController.v1.chegujiaAdminController;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPiece;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarPieces;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPieceService;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarPiecesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TieshangjCarProfitAdminController {
    @Autowired
    private TieshangjCarPieceService tieshangjCarPieceService;
    @Autowired
    private TieshangjCarPiecesService tieshangjCarPiecesService;
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
}
