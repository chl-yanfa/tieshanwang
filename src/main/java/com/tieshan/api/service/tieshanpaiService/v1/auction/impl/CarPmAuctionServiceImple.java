package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;

import com.tieshan.api.common.tieshanpaiCommon.v1.*;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAftersaleMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionFileMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionSetMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.BidMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.*;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.PMNumberService;
import com.tieshan.api.util.toolUtil.OrderByUtils;
import com.tieshan.api.util.toolUtil.UUIDUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.*;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/16 11:41
 */
@Service
@Transactional
public class CarPmAuctionServiceImple implements CarPmAuctionService {

    @Autowired
    CarPmAuctionMapper carPmAuctionMapper;

    @Autowired
    BidMapper bidMapper;

    @Autowired
    CarPmAftersaleMapper carPmAftersaleMapper;

    @Autowired
    PMNumberService pmNumberService;

    @Autowired
    CarPmAuctionFileMapper carPmAuctionFileMapper;

    @Autowired
    CarScrapOrderService carScrapOrderService;

    @Autowired
    CarPmAuctionSetMapper auctionSetMapper;


    @Override
    public List<CarPmAuctionVo> findAuction(CarPmAuctionVo auction) {
        return carPmAuctionMapper.findAuction(auction);
    }

    @Override
    public Integer findAuctionTotal(CarPmAuctionVo auction) {
        return carPmAuctionMapper.findAuctionTotal(auction);
    }

    @Override
    public ResultVO<CarPmAuctionVo> getAuctionInfo(String id) {

        ResultVO<CarPmAuctionVo> res = new ResultVO<CarPmAuctionVo>();

        SimpleDateFormat sd = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        CarPmAuctionVo auctionDto = carPmAuctionMapper.getAuctionInfo(id);
        auctionDto.setStartDate(sd.format(auctionDto.getAuctionStartTime()));
        auctionDto.setEndDate(sd.format(auctionDto.getAuctionEndTime()));


        sd.format(auctionDto.getAuctionStartTime());
        if(auctionDto.getHighestPrice()==null){
            auctionDto.setHighestPrice(auctionDto.getHighestPrice());
        }
        BigDecimal totalPrice = new BigDecimal("0");
        BigDecimal realPrice = new BigDecimal("0");
        BigDecimal highestPrice = auctionDto.getHighestPrice()==null?new BigDecimal("0"):auctionDto.getHighestPrice();
        BigDecimal commission = auctionDto.getCommission()==null?new BigDecimal("0"):auctionDto.getCommission();
        BigDecimal otherPrice = auctionDto.getOtherPrice()==null?new BigDecimal("0"):auctionDto.getOtherPrice();
        totalPrice=totalPrice.add(highestPrice); //当前价
        realPrice=realPrice.add(highestPrice)
                .add(commission)
                .add(otherPrice);  //合手价
        auctionDto.setCommission(commission);
        auctionDto.setOtherPrice(otherPrice);
        auctionDto.setTotalPrice(totalPrice);
        auctionDto.setRealPrice(realPrice);
        res.setEntity(auctionDto);
        res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        res.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return res;
    }

    @Override
    public ResultVO<Paimai> getPaimaiList(PaimaiVo paimai) {

        Integer size = paimai.getRows(); //获得每页显示的条数
        Integer page = paimai.getPage(); //获得页码
        Integer pageNum = (page - 1)*size;
        paimai.setPage(pageNum);

        ResultVO<Paimai> result = new ResultVO<>();
        List<Paimai> paimaiList = carPmAuctionMapper.getPaimaiListByPage(paimai);
        Map<String, List<Paimai>> collect = paimaiList.stream().collect(Collectors.groupingBy(Paimai::getWeekDay));

//        List<Paimai> paimaiRealList = new ArrayList<Paimai>();
//        for (int i=0;i<paimaiList.size();i++){
//            if(paimaiList.get(i).getAuctionCount()>0){
//                paimaiRealList.add(paimaiList.get(i));
//            }
//        }
        int total = carPmAuctionMapper.getPaimaiListTotal(paimai);
        result.setRows(paimaiList);
        result.setRows3(collect);
        result.setTotal(total);
        result.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        result.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return result;
    }

    @Override
    public ResultVO<OrderByUtils> getPaimaiListOrderBy(PaimaiVo paimai) {

        Integer pageOld = paimai.getPage();
        Integer rowsOld = paimai.getRows();

        Integer size = paimai.getRows(); //获得每页显示的条数
        Integer page = paimai.getPage(); //获得页码
        Integer pageNum = (page - 1)*size;
        paimai.setPage(pageNum);

        ResultVO<OrderByUtils> paimaiOrderByBOResultVO = new ResultVO<>();
        sortClass sort = new sortClass(); //正序
        DesClass des = new DesClass(); //倒序

        ArrayList<OrderByUtils> paimdemo = new ArrayList<>();

        List<Paimai> inglist = carPmAuctionMapper.getInglist(paimai);
        ArrayList<OrderByUtils> ingArr = OrderByUtils.getData(inglist);
        Collections.sort(ingArr,sort);

        List<Paimai> waitlist = carPmAuctionMapper.getWaitlist(paimai);
        ArrayList<OrderByUtils> waitArr = OrderByUtils.getData(waitlist);
        Collections.sort(waitArr,sort);

        List<Paimai> endlist = carPmAuctionMapper.getEndlist(paimai);
        ArrayList<OrderByUtils> endArr = OrderByUtils.getData(endlist);
        Collections.sort(endArr,des);

        for (OrderByUtils a:ingArr) {
            paimdemo.add(a);
        }
        for (OrderByUtils b:waitArr) {
            paimdemo.add(b);
        }
        for (OrderByUtils c:endArr) {
            paimdemo.add(c);
        }

        System.out.println("页码："+pageOld);
        System.out.println("条数："+rowsOld);

        List<OrderByUtils> collect = paimdemo.stream().skip((pageOld-1) * rowsOld).limit(rowsOld).collect(Collectors.toList());

        paimaiOrderByBOResultVO.setRows(collect);
        paimaiOrderByBOResultVO.setTotal(paimdemo.size());
        paimaiOrderByBOResultVO.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        paimaiOrderByBOResultVO.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return paimaiOrderByBOResultVO;
    }

    @Override
    public ResultVO<AuctionCar> getAuctionCarList(String pmhId,String pmOrderBy) {
        ResultVO<AuctionCar> res = new ResultVO<AuctionCar>();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        List<AuctionCar> list = carPmAuctionMapper.getAuctionCarList(pmhId,pmOrderBy);
        String initSingleTime = list.get(0).getSingleTime();
        Date systemDate = new Date();
        try{
            for (int i=0; i< list.size(); i++){
                //如果拍品状态不等于‘竞拍中4’和‘成交5’的话，也就是‘等待竞拍2’。就添加距开始秒数
                if((list.get(i).getOrderState()!="4" || !list.get(i).getOrderState().equals("4"))
                  &&
                  (list.get(i).getOrderState()!="5" || !list.get(i).getOrderState().equals("5"))
                ){
                    if(i>0){
                        list.get(i).setSingleTime(String.valueOf(Integer.parseInt(list.get(i).getSingleTime())*i));
                        Date date = sdf.parse(list.get(i).getAuctionStartTime());
                        Calendar rightNow = Calendar.getInstance();
                        rightNow.setTime(date);
                        rightNow.add(Calendar.SECOND,Integer.parseInt(list.get(i).getSingleTime()));    //获得拍品开始时间
                        Date dt = rightNow.getTime();
                        String reStr = sdf.format(dt);
                        list.get(i).setTimeCount(reStr); //重新定义各个拍品的开始时间

                        Date dateEnd = sdf.parse(list.get(i).getTimeCount());
                        Calendar rightEnd = Calendar.getInstance();
                        rightEnd.setTime(dateEnd);
                        rightEnd.add(Calendar.SECOND,Integer.parseInt(initSingleTime));  //获得拍品结束时间
                        Date dtEnd = rightEnd.getTime();
                        String reStrEnd = sdf.format(dtEnd);
                        list.get(i).setTimeEndCount(reStrEnd);

                    }else if(i==0){
                        list.get(i).setTimeCount((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(sdf.parse(list.get(i).getAuctionStartTime())));
                        Date dateEndOne = sdf.parse(list.get(i).getTimeCount());
                        Calendar rightEnd = Calendar.getInstance();
                        rightEnd.setTime(dateEndOne);
                        rightEnd.add(Calendar.SECOND,Integer.parseInt(initSingleTime));  //获得拍品结束时间
                        Date dtEnd = rightEnd.getTime();
                        String reStrEnd = sdf.format(dtEnd);
                        list.get(i).setTimeEndCount(reStrEnd);
                    }
                    //向拍品表更新每个拍品的开始时间和结束时间
                    Map<String,Object> smap = new HashMap<String,Object>();
                    smap.put("start",list.get(i).getTimeCount());
                    smap.put("end",list.get(i).getTimeEndCount());
                    smap.put("sid",list.get(i).getAuctionId());
                    int result = carPmAuctionMapper.updateSinglePiece(smap);
                    System.out.println(result>0?"success":"error");

                    /**
                     * 计算距开始秒数
                     */
                    Date goRunTime = sdf.parse(list.get(i).getTimeCount());
                    long diff = (goRunTime.getTime()-systemDate.getTime())/1000;
                    list.get(i).setOneSecond(diff>=0?String.valueOf(diff):"-1");
                }else{
                    list.get(i).setOneSecond("-1");
                }
                int result = carPmAuctionMapper.getHeightPrice(list.get(i).getAuctionId());
                list.get(i).setCurPrice(new BigDecimal(result>0?result:0));
            }

            //按照拍品开始时间进行正序
            list.sort((item1,item2)->{
                try {
                    return sdf.parse(item1.getTimeCount()).compareTo(sdf.parse(item2.getTimeCount()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 1;
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        res.setRows(list);
        res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        res.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return res;
    }

    @Override
    public Map<String,List<CarPmResultVo>> getEndResult() {

        //获取所有快要结束拍卖会
        List<CarPmResultVo> pmhList = carPmAuctionMapper.getIngPmh();

        //获取所有正在竞拍状态下、并且结束时间小于当前时间的拍品
        List<CarPmResultVo> paipinList = carPmAuctionMapper.getIngPaiPin();

        //切拍列表
        List<CarPmResultVo> chopPaipinList = new ArrayList<>();

        //流拍列表
        List<CarPmResultVo> outPaipinList = new ArrayList<>();


        Map<String, List<CarPmResultVo>> successResult = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paipinList.forEach(item->{
            System.out.println(item.getThisPrice()+"       "+item.getRetainPrice());
            if(item.getThisPrice()>=item.getRetainPrice()){
                System.out.println("进入");
                //根据切拍时间查询成交人的id
                String members = carPmAuctionMapper.getMembers(item.getPpNo());
                DealVO dealVO = carPmAuctionMapper.getAuctionDealInfo(item.getPpId());

                //向切拍列表添加数据后，向成交表添加数据
                CarPmDeal carPmDeal = new CarPmDeal();
                carPmDeal.setId(Identities.uuid2());
                carPmDeal.setOrderNo(dealVO.getOrderNo());
                carPmDeal.setAuctionId(dealVO.getAuctionId());
                BigDecimal dealPrice = dealVO.getCommission().add(dealVO.getOtherPrice()).add(dealVO.getHighestPrice());
                carPmDeal.setPayPrice(dealPrice);
                carPmDeal.setAuctionName(dealVO.getFullName());
                carPmDeal.setDealTime(item.getPpEndTime());
                carPmDeal.setDealerId(members);
                carPmDeal.setDealWay(1);
                carPmDeal.setAuctionType(dealVO.getAuctionType());
                carPmDeal.setDealCn("已成交");
                int result = carPmAuctionMapper.addDealOrder(carPmDeal);

                try{

                    OrderInfoVo order = bidMapper.getOrderInfoResultByWS(item.getPpNo());
                    CarPmAftersale caf = new CarPmAftersale();
                    caf.setId(Identities.uuid2());
                    caf.setAuctionId(item.getPpId());
                    caf.setAuctionSetId(order.getId());
                    caf.setDealTime(simpleDateFormat.parse( item.getPpEndTime()));
                    caf.setDealHandler(carPmAuctionMapper.getUserName(members));
                    caf.setPayState(0);
                    caf.setTakeCarState(0);
                    caf.setDeferState(0);
                    caf.setAdjustPriceState(0);
                    caf.setBackCarState(0);
                    caf.setIsHistory(false);
                    caf.setIsDelete(false);
                    caf.setCreateUser(members);
                    caf.setCreateTime(simpleDateFormat.parse( item.getPpEndTime()));
                    int addResult = carPmAftersaleMapper.insert(caf);
                }catch (Exception e){
                    e.printStackTrace();
                }
                chopPaipinList.add(item);
            }else{
                outPaipinList.add(item);
            }
        });

        successResult.put("pmh", pmhList);
        successResult.put("qiepai", chopPaipinList);
        successResult.put("liupai", outPaipinList);
        return successResult;
        }

    @Override
    public Map<String, List<StartVO>> getStartTimeList() {
        List<StartVO> startResult = carPmAuctionMapper.getStartResult();
        //要启动的拍卖会列表
        List<StartVO> nowstartPmh = new ArrayList<>();

        List<StartVO> newnowstartPmh = new ArrayList<>();

        //要启动的拍品列表_1
        List<StartVO> startPaipin = new ArrayList<>();

        //要启动的拍品列表_2 等于当前系统时间
        List<StartVO> nowstartPaipin = new ArrayList<>();

        Map<String,List<StartVO>> map =new HashMap<>();

        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sb.format(new Date());

        String beforeOne = TimeAddSecond(nowTime,-1);
        String beforeTwo = TimeAddSecond(nowTime,-2);

        String afterOne = TimeAddSecond(nowTime,1);
        String afterTwo = TimeAddSecond(nowTime,2);

        /**
         * 拍卖会优先执行，并设置6秒的误差
         */

        startResult.forEach(item->{
            String pmhStartTime = TimeAddSecond(item.getAuctionStartTime(),5);
            if(pmhStartTime.equals(nowTime) ||
                pmhStartTime.equals(beforeOne) ||
                pmhStartTime.equals(beforeTwo) ||
                pmhStartTime.equals(afterOne) ||
                pmhStartTime.equals(afterTwo)
             ){
                nowstartPmh.add(item);
            }
        });

        for (int i=0;i<nowstartPmh.size();i++){
            if(i!=nowstartPmh.size()-1){
                if(!nowstartPmh.get(i).getPmhId().equals(nowstartPmh.get(i+1).getPmhId())){
                    newnowstartPmh.add(nowstartPmh.get(i));
                }
            }else{
                newnowstartPmh.add(nowstartPmh.get(i));
            }
        }



        /**
         * 定义各个拍品的开始时间
         */
        for (int i=0; i<startResult.size(); i++){
                Integer result = Integer.parseInt(startResult.get(i).getPmOrder());
                startResult.get(i).setSingleTime(String.valueOf(Integer.parseInt(startResult.get(i).getSingleTime())* (result-1)));

                String resultStr = TimeAddSecond(startResult.get(i).getAuctionStartTime(),  Integer.parseInt(startResult.get(i).getSingleTime()));
                startResult.get(i).setTimeCount(resultStr);
                System.out.println();
                startPaipin.add(startResult.get(i));
            }

        /**
         * 设置6秒的误差
         */
        for(int i=0; i<startPaipin.size(); i++){
            String reStr = TimeAddSecond(startPaipin.get(i).getTimeCount(),5);
            if(reStr.equals(nowTime) ||
                    reStr.equals(beforeOne) ||
                    reStr.equals(beforeTwo) ||
                    reStr.equals(afterOne) ||
                    reStr.equals(afterTwo)
              ){
                nowstartPaipin.add(startPaipin.get(i));
            }
        }

        map.put("nowpmh",newnowstartPmh);
        //map.put("paipin",startPaipin);
        map.put("nowpaipin",nowstartPaipin);
        return map;
    }

    @Override
    public ResultVO<CarPmDeal> getPmOrderByMemberId(Integer page,Integer rows,String mid) {
        Integer pageNum = (page-1) * rows;
        Map<String,Object> map = new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("rows",rows);
        map.put("mid",mid);
        List<CarPmDeal> list = carPmAuctionMapper.getPmOrderByMemberId(map);
        Integer total = carPmAuctionMapper.getTotalPmOrder(mid);
        ResultVO<CarPmDeal> res = new ResultVO<>();
        res.setRows(list);
        res.setTotal(total);
        res.setReturnMsg("success");
        res.setReturnCode("200");
        return res;
    }

    @Override
    public ResultVO<String> addAuction(CarPmAuctionVo auction){
        ResultVO<String> res = new ResultVO<>();
        //获取用户信息，便于标识是谁添加的该拍品
        if(null == auction.getClientUserId()) {
            res.setReturnCode(RtnMsgConstants.RETURN_CODE_LOGIN_NULL);
            res.setReturnMsg(RtnMsgConstants.RETURN_MSG_LOGIN_NULL);
            return res;
        }
        if(null == auction){
            res.setReturnCode(RtnMsgConstants.RETURN_CODE_PARAMETER_NULL);
            res.setReturnMsg(RtnMsgConstants.RETURN_MSG_PARAMETER_NULL);
            return res;
        }
        Integer auctionType = auction.getAuctionType();
        //对VIN中字母转换大写
        if(StringUtils.isNotBlank(auction.getVin())) {
            auction.setVin(auction.getVin().toUpperCase());
        }
        String auctionNo = pmNumberService.getAuctionNo();
        auction.setAuctionNo(auctionNo);
        //新增拍品信息
        auction.setId(UUIDUtil.getUUID());
        auction.setAuctionState(10);

        //用户设置出售价格
        CarPmAuctionSet carPmAuctionSet = new CarPmAuctionSet();
        carPmAuctionSet.setReservePrice(auction.getReservePrice());  //App内预期保留价
        carPmAuctionSet.setAuctionCashDeposit(auction.getAuctionCashDeposit()); //App内设置参拍保证金
        if(null == carPmAuctionSet){
            res.setReturnCode(RtnMsgConstants.RETURN_CODE_DATA_NULL);
            res.setReturnMsg(RtnMsgConstants.RETURN_MSG_DATA_NULL);
            return res;
        }
        carPmAuctionSet.setCreateUser(auction.getClientUserId());
        carPmAuctionSet.setOrderState(Constants.OrderStatus.HAS_NO_AUCTION);
        carPmAuctionSet.setId(UUIDUtil.getUUID());
        String orderNo = pmNumberService.getOrderNo();
        carPmAuctionSet.setOrderNo(orderNo);
        auctionSetMapper.addAuctionSet(carPmAuctionSet);  //向参拍设置表新增数据
        carPmAuctionMapper.insertAuction(auction); //向拍品表新增数据
        //新增图片
        if(StringUtils.isNotBlank(auction.getFileIds())) {
            List<String> asList = Arrays.asList(auction.getFileIds().split(","));
            if(asList!=null && asList.size()>0) {
                List<Integer> fileIdList = asList.stream().map(Integer::parseInt).collect(Collectors.toList());
                if(fileIdList!=null && fileIdList.size()>0) {
                    List<CarPmAuctionFile> list =new ArrayList<CarPmAuctionFile>();
                    CarPmAuctionFile file;
                    for (int i = 0;i<fileIdList.size();i++) {
                        file = new CarPmAuctionFile( auction.getId(), 0, fileIdList.get(i), i, 0, null);
                        list.add(file);
                    }
                    carPmAuctionFileMapper.addAuctionFileBatch(list);
                }
            }
        }
        //设置整车/配件
        if(auctionType == 0) {
            String scrapOrderId = auction.getScrapOrderId();
            if(StringUtils.isNotBlank(scrapOrderId)) {
                //修改状态以及绑定id
                carScrapOrderService.addScrapOrder(Constants.ScrapOrderStatus.SCRAP_CAR, scrapOrderId, auction.getId(),auction.getClientUserId());
            }
        }else {
            List<String> autopartsIdList = auction.getAutopartsIdList();
            if(autopartsIdList != null && autopartsIdList.size()>0) {
                for (String autopartsId : autopartsIdList) {
                    //修改状态以及绑定id
                    carScrapOrderService.addScrapOrder(Constants.ScrapOrderStatus.SCRAP_AUTOPARTS, autopartsId, auction.getId(),auction.getClientUserId());
                }
            }
        }
        return res;
    }

    /**
     * 时间相加函数
     * @param time 要添加秒数的时间
     * @param addCount 秒数
     * @return
     */
    public String TimeAddSecond(String time,Integer addCount){
        try{
            Calendar rightNow = Calendar.getInstance();
            SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date yanchidate = sb.parse(time);
            rightNow.setTime(yanchidate);
            rightNow.add(Calendar.SECOND,addCount);
            Date dt = rightNow.getTime();
            String reStr = sb.format(dt);
            return reStr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

