package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;

import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.AuctionCar;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import com.tieshan.api.service.tieshanpaiService.v1.auction.CarPmAuctionService;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.PaimaiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

        ResultVO<Paimai> result = new ResultVO<Paimai>();
        List<Paimai> paimaiRealList = new ArrayList<Paimai>();
        List<Paimai> paimaiList = carPmAuctionMapper.getPaimaiListByPage(paimai);
        for (int i=0;i<paimaiList.size();i++){
            if(paimaiList.get(i).getAuctionCount()>0){
                paimaiRealList.add(paimaiList.get(i));
            }
        }
//        int total = carPmAuctionMapper.getPaimaiListTotal(paimai);
        result.setRows(paimaiRealList);
        result.setTotal(paimaiRealList.size());
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
                System.out.println("第"+(i+1)+"个拍品的auctionNo为:"+list.get(i).getAuctionId());
                list.get(i).setCurPrice(new BigDecimal(carPmAuctionMapper.getHeightPrice(list.get(i).getAuctionId())));
            }
//            for(int a=0; a<list.size(); a++){
//                if(list.get(a).getOrderState()=="2" || list.get(a).getOrderState().equals("2")){
//                    Date goRunTime = sdf.parse(list.get(a).getTimeCount());
//                    long diff = (goRunTime.getTime()-systemDate.getTime())/1000;
//                    if(diff>=0){
//                        list.get(a).setOneSecond(String.valueOf(diff));
//                    }else{
//                        list.get(a).setOneSecond("-1");
//                    }
//                }else{
//                    list.get(a).setOneSecond("-1");
//                }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        res.setRows(list);
        res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        res.setReturnMsg(Constants.RETURN_MSG_SUCCESS);
        return res;
    }
}
