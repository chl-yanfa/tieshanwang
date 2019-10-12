package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.tieshan.api.bo.tieshanpaiBo.v1.CarPmAuctionBO;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.common.tieshanpaiCommon.v1.SessionUtil;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmDeal;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.service.tieshanpaiService.v1.transaction.BidService;
import com.tieshan.api.util.toolUtil.ClientUtil;
import com.tieshan.api.util.toolUtil.OrderByUtils;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.BidVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    TbAttachmentService tbAttachmentService;

    @Autowired
    private BidService bidService;

    private static Log log = LogFactory.getLog(getAuctionListController.class);

    /**
     *
     * @param auction 根据条件获取拍品列表 CarPmAuctionVo auction
     * @return
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public Object ListPage(@RequestBody CarPmAuctionVo auction) throws DataException {
        ResultVO<CarPmAuctionVo> res = new ResultVO<>();
        List<CarPmAuctionVo> list = new ArrayList<>();
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
    public ResultVO<CarPmAuctionVo> getAuctionInfo(String id) throws DataException {
        ResultVO<CarPmAuctionVo> cvo = carPmAuctionService.getAuctionInfo(id);
        return cvo;
    }


    /**
     *
     * @param bidVo 竞价传递参数
     * @param request
     * @return
     */
    @RequestMapping(value = "/quoteprice", method = RequestMethod.POST)
    public synchronized Object quoteprice_new(BidVo bidVo, HttpServletRequest request) {

        System.out.println("接收到用户的报价参数为11111:"+bidVo);

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
            System.out.println("接收到用户的报价参数为22222:"+bidVo);
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
     * @param paimai 根据条件获取拍卖会列表信息-排序后
     * @return
     */
    @RequestMapping(value = "/getPaimaiListByPX", method = RequestMethod.POST)
    public ResultVO<OrderByUtils> getPaimaiListByOrder(PaimaiVo paimai) {
        return carPmAuctionService.getPaimaiListOrderBy(paimai);
    }

    /**
     *
     * @param pmhId 拍卖会id
     * @param pmOrderBy 排序参数
     * @return
     */
    @RequestMapping(value = "/getAuctionCarList", method = RequestMethod.POST)
    public ResultVO<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy) {
        return carPmAuctionService.getAuctionCarList(pmhId,pmOrderBy);
    }


    /**
     * 获得用户铁扇拍成交信息
     * @param mid
     * @return
     */
    @RequestMapping(value = "/getPmOrderById", method = RequestMethod.POST)
    public ResultVO<CarPmDeal> getPmOrderByMemberId(@RequestParam(value="page") Integer page,
                                                    @RequestParam(value="rows") Integer rows,
                                                    @RequestParam(value="mid") String mid) {
        return carPmAuctionService.getPmOrderByMemberId(page,rows,mid);
    }

    /**
     * 新增拍品
     * @param auction
     * @return
     */
    @RequestMapping(value = "/addAuction", method = RequestMethod.POST)
    public ResultVO<String> addAuction(@RequestBody CarPmAuctionVo auction) throws Exception {
        auction.setCreateUser(ClientUtil.getUser().getId());
        //前台传递一个图片路径集合
        List<String> imgPathList = auction.getTxtImg();
        System.out.println("图片List:"+imgPathList.size());

        StringBuilder stringBuffer = new StringBuilder();
        for (String s : imgPathList) {
            TbAttachment tb = new TbAttachment();
            tb.setStoragePath(s);
            TbAttachment tbAttachment = tbAttachmentService.queryOne(tb);
            stringBuffer.append(tbAttachment.getId());
            stringBuffer.append(",");
        }
        System.out.println("图片的id:"+stringBuffer);


        List<String> docImgPathList = auction.getDocImg();
        System.out.println("手续List:"+docImgPathList.size());
        StringBuilder sbuild = new StringBuilder();
        for (String docImgPath:docImgPathList) {
            TbAttachment tb = new TbAttachment();
            tb.setStoragePath(docImgPath);
            TbAttachment tbAttachment = tbAttachmentService.queryOne(tb);
            sbuild.append(tbAttachment.getId());
            sbuild.append(",");
        }
        System.out.println("手续图片的id:"+sbuild);


        List<String> auctionIdList = auction.getAujianIds();
        if(auctionIdList.size()>0){
            System.out.println("件拍卖idList:"+auctionIdList.size());
            StringBuilder jianld = new StringBuilder();
            for (String docImgPath:auctionIdList) {
                jianld.append(docImgPath);
                jianld.append(",");
            }
            System.out.println("件拍卖的id:"+jianld);
            String jianlds = jianld.toString();
            auction.setAujianId(jianlds);
        }


        String newFields = stringBuffer.toString();
        String newDocImgFields = sbuild.toString();



        auction.setFileIds(newFields.substring(0,newFields.lastIndexOf(",")));
        auction.setDocFiles(newDocImgFields.substring(0,newDocImgFields.lastIndexOf(",")));
        ResultVO<String> resultVO = carPmAuctionService.addAuction(auction);
        resultVO.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        resultVO.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return resultVO;
    }


    /**
     * 获取待审核、已审核、审核未通过列表
     */
    @RequestMapping(value = "/getAuctionListByState",method = RequestMethod.POST)
    public ResultVO<CarPmAuctionBO> getWaitCheckList(@RequestParam(value = "aucationState")String auctionState) throws Exception {
        String mid = ClientUtil.getUser().getId();
        List<CarPmAuctionBO> auctionStateList = carPmAuctionService.getAuctionState(mid, auctionState);
        ResultVO<CarPmAuctionBO> resultVO = new ResultVO<>();
        resultVO.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        resultVO.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        resultVO.setRows(auctionStateList);
        return resultVO;
    }

    /**
     * 根据拍品id获取待审核、已审核、审核未通过详情
     * @return
     */
    @RequestMapping(value = "/getAuctionDetailById",method = RequestMethod.GET)
    public ResultVO<CarPmAuctionBO> getAuctionDetailById(@RequestParam("auctionId") String auctionId){
        List<CarPmAuctionBO> auctionDetailByIdIsWait = carPmAuctionService.getAuctionDetailByIdIsWait(auctionId);
        ResultVO<CarPmAuctionBO> resultVO = new ResultVO<>();
        resultVO.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        resultVO.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        resultVO.setRows(auctionDetailByIdIsWait);
        return resultVO;
    }
}
