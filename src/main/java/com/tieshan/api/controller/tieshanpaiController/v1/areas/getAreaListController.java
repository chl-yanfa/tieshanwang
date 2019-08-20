package com.tieshan.api.controller.tieshanpaiController.v1.areas;

import com.tieshan.api.po.tieshanpaiPo.v1.areas.Areas;
import com.tieshan.api.service.tieshanpaiService.v1.areas.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ningrz 地域相关控制器
 * @version 1.0
 * @date 2019/8/19 9:17
 */

@RestController
@CrossOrigin
@RequestMapping("v1/newapi_tieshanpai/areas")
public class getAreaListController {

    @Autowired
    AreasService areasService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Areas> getAreas(){
        return areasService.getAreas();
    }

}
