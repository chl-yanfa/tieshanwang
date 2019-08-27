package com.tieshan.api.controller.tieshanAppHomePage.v1;
import com.tieshan.api.po.homePagePo.bo.v1.CarPmAuctionOrderDealSerach;
import com.tieshan.api.po.homePagePo.bo.v1.CarScrapOrderDealBO;
import com.tieshan.api.po.homePagePo.bo.v1.PaimaiBO;
import com.tieshan.api.po.homePagePo.bo.v1.TbVersion;
import com.tieshan.api.service.homePageService.v1.CarPmAuctionOrderDealSerachService;
import com.tieshan.api.service.homePageService.v1.CarScrapOrderDealService;
import com.tieshan.api.service.homePageService.v1.PaimaiService;
import com.tieshan.api.service.homePageService.v1.TbVersionService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomePageController {
    @Autowired
    private PaimaiService paimaiService;
    @Autowired
    private CarScrapOrderDealService carScrapOrderDealService;
    @Autowired
    private TbVersionService tbVersionService;
    @Autowired
    private CarPmAuctionOrderDealSerachService carPmAuctionOrderDealSerachService;
    @RequestMapping(value = "homePages",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult homePages(HttpServletRequest request, Map map){
        String oc=request.getParameter("oc");
        //1.首页拍卖列表
        List<PaimaiBO> queryList = paimaiService.queryList();
        map.put("paimai",queryList);
        //2.首页成交订单列表
        List<CarScrapOrderDealBO> queryList2 = carScrapOrderDealService.queryList();
        map.put("order",queryList2);
        //3.版本更新
        TbVersion queryOne = tbVersionService.selectByPrimaryKey(Integer.parseInt(oc));
        map.put("vesion",queryOne);
        //4.轮播图
        Map<String,String>carousel=new HashMap<>();
        carousel.put("lun1","https://chl-res.oss-cn-beijing.aliyuncs.com/B1jpg");
        carousel.put("lun2","https://chl-res.oss-cn-beijing.aliyuncs.com/B2.jpg");
        carousel.put("lun3","https://chl-res.oss-cn-beijing.aliyuncs.com/B3.jpg");
        map.put("carousel",carousel);
        return ResultUtil.success(map);
    }
    @RequestMapping(value = "homeSearch",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult homeSearch(HttpServletRequest request, Map map){
        String modelName=request.getParameter("modelName");
        //1.搜索拍卖 and 车报废订单 列表
        List<CarPmAuctionOrderDealSerach> queryList = carPmAuctionOrderDealSerachService.queryListName(modelName);
        map.put("order",queryList);
        return ResultUtil.success(map);
    }
}
