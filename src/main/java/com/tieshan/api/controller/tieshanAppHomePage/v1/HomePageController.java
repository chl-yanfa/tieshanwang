package com.tieshan.api.controller.tieshanAppHomePage.v1;
import com.tieshan.api.bo.homePageBo.CarScrapOrderDealBO;
import com.tieshan.api.bo.homePageBo.PaimaiBO;
import com.tieshan.api.po.homePagePo.v1.CarPmAuctionOrderDealSerach;
import com.tieshan.api.po.homePagePo.v1.TbArticle;
import com.tieshan.api.po.homePagePo.v1.TbCarousel;
import com.tieshan.api.po.homePagePo.v1.TbVersion;
import com.tieshan.api.service.homePageService.v1.*;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(value = "v1/home/")
public class HomePageController {
    @Autowired
    private PaimaiService paimaiService;
    @Autowired
    private CarScrapOrderDealService carScrapOrderDealService;
    @Autowired
    private TbVersionService tbVersionService;
    @Autowired
    private CarPmAuctionOrderDealSerachService carPmAuctionOrderDealSerachService;
    @Autowired
    private TbArticleService  tbArticleService;
    @Autowired
    private TbCarouselService tbCarouselService;
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
        Map map1=new HashMap();
        map1.put("type","1");
        List<TbCarousel>lists=tbCarouselService.select(map1);
        List<String>list=new ArrayList<>();
        for (TbCarousel listz : lists) {
            list.add(listz.getImg());
        }
        map.put("carousel",list);
        //5.新闻公告
        Map xinwen=new HashMap();
        xinwen.put("type",'1');
        xinwen.put("limits",3);
        List<TbArticle> tbArticlelist=tbArticleService.selectHomePage(xinwen);
        map.put("article",tbArticlelist);
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
