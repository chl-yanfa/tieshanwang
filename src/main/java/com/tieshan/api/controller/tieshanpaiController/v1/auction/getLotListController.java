package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.common.tieshanpaiCommon.v1.SessionUtil;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.service.tieshanpaiService.v1.transaction.BidService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.BidVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/15 17:57
 */
@RestController
@RequestMapping(value = "v1/newapi_tieshanpai/auction/")
public class getLotListController {

    @Autowired
    CarPmAuctionService carPmAuctionService;

    @Autowired
    private BidService bidService;

    private static Log log = LogFactory.getLog(getLotListController.class);

    /**
     * 拍卖列表
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public Object ListPage(@RequestBody CarPmAuctionVo auction, HttpServletRequest request){
        ResultVO<CarPmAuctionVo> res = new ResultVO<CarPmAuctionVo>();
        List<CarPmAuctionVo> list = new ArrayList<CarPmAuctionVo>();
        try{
            list = carPmAuctionService.findAuction(auction);
            if (null != list && list.size() > 0) {
                res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                res.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
                res.setRows(list);
            } else {
                res.setReturnCode(Constants.RETURN_CODE_DATA_NULL);
                res.setReturnMsg(Constants.RETURN_MSG_DATA_NULL);
            }
            int total = carPmAuctionService.findAuctionTotal(auction);
            res.setTotal(total);
        }catch(Exception e){
            res.setReturnCode(Constants.RETURN_CODE_SYSTEM_FAIL);
            res.setReturnMsg(Constants.RETURN_MSG_SYSTEM_FAIL);
            e.printStackTrace();
        }
        return res;
    }


    /**
     * 拍卖详情
     */
    @RequestMapping(value = "/getAuctionInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultVO<CarPmAuctionVo> getAuctionInfo(String id){
        return carPmAuctionService.getAuctionInfo(id);
    }


    /**
     * 竞价
     */
    @RequestMapping(value = "/quoteprice", method = RequestMethod.POST)
    @ResponseBody
    public synchronized Object quoteprice_new(BidVo bidVo, HttpServletRequest request, HttpServletResponse response){
        long s = System.currentTimeMillis();
        ResultVO<String> res = new ResultVO<String>();
        try{
            //是否为空验证
            if(bidVo.getBidAmount()==null){
                res.setReturnCode(Constants.PRICE_NOT_NULL);
                return res;
            }
            String memberCode = String.valueOf(bidVo.getMemberCode());
            String realName = SessionUtil.getRealName();
            if(memberCode == null || "".equals(memberCode)){
                memberCode = request.getParameter("memberCode");
                Object object = request.getAttribute("realName");
                realName = (String) (object == null?"":object);
                if (memberCode == null || "".equals(memberCode)) {
                    res.setReturnCode(Constants.RETURN_CODE_PARAMETER_NULL);
                    return res;
                }
            }
            bidVo.setMemberCode(memberCode);
            bidVo.setRealName(realName);
            res = bidService.bid(bidVo);
        }catch(Exception e){
            log.error("出价错误："+e.toString());
            res.setReturnCode(Constants.RETURN_CODE_SYSTEM_FAIL);// 200000系统错误
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        log.info("=================出价耗时："+(e-s)+"毫秒");
        return res;
    }

}
