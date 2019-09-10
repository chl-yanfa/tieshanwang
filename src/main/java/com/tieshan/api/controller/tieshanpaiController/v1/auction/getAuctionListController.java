package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.common.tieshanpaiCommon.v1.SessionUtil;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmDeal;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.service.tieshanpaiService.v1.transaction.BidService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
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
 * @author ningrz 拍卖相关控制器
 * @version 1.0
 * @date 2019/8/15 17:57
 */
@RestController
@CrossOrigin
@RequestMapping(value = "v1/newapi_tieshanpai/auction/")
public class getAuctionListController {

    @Autowired
    CarPmAuctionService carPmAuctionService;

    @Autowired
    private BidService bidService;

    private static Log log = LogFactory.getLog(getAuctionListController.class);

    /**
     *
     * @param auction 根据条件获取拍品列表 CarPmAuctionVo auction
     * @param request
     * @return
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
     *
     * @param id 拍品唯一id
     * @return
     */
    @RequestMapping(value = "/getAuctionInfo", method = RequestMethod.GET)
    public ResultVO<CarPmAuctionVo> getAuctionInfo(String id,String timeCount,String timeEndCount){
        ResultVO<CarPmAuctionVo> cvo = carPmAuctionService.getAuctionInfo(id);
        return cvo;
    }


    /**
     *
     * @param bidVo 竞价传递参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/quoteprice", method = RequestMethod.POST)
    public synchronized Object quoteprice_new(BidVo bidVo, HttpServletRequest request, HttpServletResponse response){
        long s = System.currentTimeMillis();
        ResultVO<String> res = new ResultVO<String>();
        try{
            //验证出价金额是否为空
            if(bidVo.getBidAmount()==null){
                res.setReturnCode(Constants.PRICE_NOT_NULL);
                return res;
            }
            String memberCode = String.valueOf(bidVo.getMemberCode());  //获得用户的会员id sys_client
            String realName = SessionUtil.getRealName(); //获得用户的真实姓名

            //获取不到会员id和真实姓名就去request域中拿
            if(memberCode == null || "".equals(memberCode)){
                memberCode = request.getParameter("memberCode");
                Object object = request.getAttribute("realName");
                realName = (String) (object == null?"":object);
                if (memberCode == null || "".equals(memberCode)) {  // 500_error 会员id为空
                    res.setReturnCode(Constants.RETURN_CODE_PARAMETER_NULL);
                    return res;
                }
            }
            if(realName==null || realName.equals("")){
                realName=bidVo.getRealName();
            }
            bidVo.setMemberCode(memberCode);
            bidVo.setRealName(realName);
            res = bidService.bid(bidVo);  //进入service
        }catch(Exception e){
            log.error("出价错误："+e.toString());
            res.setReturnCode(Constants.RETURN_CODE_SYSTEM_FAIL);// 200000系统错误
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        log.info("=================出价耗时："+(e-s)+"毫秒");
        return res;
    }

    /**
     *
     * @param paimai 根据条件获取拍卖会列表信息
     * @return
     */
    @RequestMapping(value = "/getPaimaiList", method = RequestMethod.POST)
    public ResultVO<Paimai> getPaimaiList(PaimaiVo paimai) {
        return carPmAuctionService.getPaimaiList(paimai);
    }

    /**
     *
     * @param pmhId 拍卖会id
     * @param pmOrderBy 排序参数
     * @return
     */
    @RequestMapping(value = "/getAuctionCarList", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy) {
        return carPmAuctionService.getAuctionCarList(pmhId,pmOrderBy);
    }


    /**
     * 获得用户铁扇拍成交信息
     * @param mid
     * @return
     */
    @RequestMapping(value = "/getPmOrderById", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<CarPmDeal> getPmOrderByMemberId(@RequestParam(value="page",required = true) Integer page,
                                                    @RequestParam(value="rows",required = true) Integer rows,
                                                    @RequestParam(value="mid",required = true) String mid){
        return carPmAuctionService.getPmOrderByMemberId(page,rows,mid);
    }

}
