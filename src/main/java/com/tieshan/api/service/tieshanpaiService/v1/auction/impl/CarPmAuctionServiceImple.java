package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;

import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.Identities;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmDeal;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
//        List<Paimai> paimaiRealList = new ArrayList<Paimai>();
//        for (int i=0;i<paimaiList.size();i++){
//            if(paimaiList.get(i).getAuctionCount()>0){
//                paimaiRealList.add(paimaiList.get(i));
//            }
//        }
        int total = carPmAuctionMapper.getPaimaiListTotal(paimai);
        result.setRows(paimaiList);
        result.setTotal(total);
        result.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        result.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return result;
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

        System.out.println(paipinList.size()+"aaaaaaa");
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
                int result = carPmAuctionMapper.addDealOrder(carPmDeal);
                System.out.println(result>0);
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
    public ResultVO<CarPmDeal> getPmOrderByMemberId(String mid) {
        List<CarPmDeal> list = carPmAuctionMapper.getPmOrderByMemberId(mid);
        ResultVO<CarPmDeal> res = new ResultVO<>();
        res.setRows(list);
        res.setReturnMsg("success");
        res.setReturnCode("200");
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

