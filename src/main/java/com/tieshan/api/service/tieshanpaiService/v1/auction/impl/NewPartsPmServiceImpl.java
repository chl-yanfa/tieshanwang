package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;
import com.tieshan.api.common.tieshanpaiCommon.v1.Constants;
import com.tieshan.api.common.tieshanpaiCommon.v1.ResultVO;
import com.tieshan.api.common.tieshanpaiCommon.v1.RtnMsgConstants;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionSetMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.NewPartsPmFileMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.NewPartsPmMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.CarPmAuctionSet;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPm;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.NewPartsPmFile;
import com.tieshan.api.service.tieshanpaiService.v1.auction.NewPartsPmService;
import com.tieshan.api.service.tieshanpaiService.v1.auction.PMNumberService;
import com.tieshan.api.util.toolUtil.UUIDUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NewPartsPmServiceImpl implements NewPartsPmService {
    @Autowired
    private NewPartsPmMapper newPartsPmMapper;
    @Autowired
    private NewPartsPmFileMapper newPartsPmFileMapper;
    @Autowired
    PMNumberService pmNumberService;
    @Autowired
    CarPmAuctionSetMapper auctionSetMapper;
    @Autowired
    CarPmAuctionMapper carPmAuctionMapper;
    @Override
    public int insertJianFile(NewPartsPm record) {
        //新增拍品-件
        int num=newPartsPmMapper.insertSelective(record);
        //新增拍品图片
        if(StringUtils.isNotBlank(record.getFileIds())) {
            List<String> asList = Arrays.asList(record.getFileIds().split(","));
            for (int i=0;i<asList.size();i++){
                System.out.println(asList.get(i));
                NewPartsPmFile newPartsPmFile=new NewPartsPmFile();
                newPartsPmFile.setNewPartsPmId(record.getId());//件拍卖id
                newPartsPmFile.setFileType(0);//附件类型
                newPartsPmFile.setAttachmentId(Integer.parseInt(asList.get(i)));//附件存储id
                newPartsPmFile.setCreateTime(new Date());
                newPartsPmFile.setUpdateTime(new Date());
                newPartsPmFile.setCreateBy(record.getCreateBy());
                newPartsPmFile.setUpdateBy(record.getUpdateBy());
                newPartsPmFile.setSort(i);
                newPartsPmFile.setPicType(0);
                newPartsPmFileMapper.insertSelective(newPartsPmFile);
            }
        }
        return num;
    }

    @Override
    public ResultVO<String> addAuction(CarPmAuctionVo auction) {
        ResultVO<String> res = new ResultVO<>();
        //获取用户信息，便于标识是谁添加的该拍品
        if(null == auction.getCreateUser()) {
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
        if(!StringUtils.isNotBlank(auction.getFullName())){
            auction.setFullName(auction.getVehicleType());
        }
        auction.setUploadType(0);
        //用户设置出售价格
        CarPmAuctionSet carPmAuctionSet = new CarPmAuctionSet();
        carPmAuctionSet.setReservePrice(auction.getReservePrice());  //App内预期保留价
        carPmAuctionSet.setAuctionCashDeposit(auction.getAuctionCashDeposit()); //App内设置参拍保证金
        if(null == carPmAuctionSet){
            res.setReturnCode(RtnMsgConstants.RETURN_CODE_DATA_NULL);
            res.setReturnMsg(RtnMsgConstants.RETURN_MSG_DATA_NULL);
            return res;
        }
        carPmAuctionSet.setCreateUser(auction.getCreateUser());
        carPmAuctionSet.setOrderState(Constants.OrderStatus.HAS_NO_AUCTION);
        carPmAuctionSet.setId(UUIDUtil.getUUID());
        String orderNo = pmNumberService.getOrderNo();
        carPmAuctionSet.setOrderNo(orderNo);
        carPmAuctionSet.setAuctionId(auction.getId());
        auctionSetMapper.addAuctionSet(carPmAuctionSet);  //向参拍设置表新增数据
        carPmAuctionMapper.insertAuction(auction); //向拍品表新增数据

        /*//设置整车/配件
        if(auctionType == 0) {
            String scrapOrderId = auction.getScrapOrderId();
            if(StringUtils.isNotBlank(scrapOrderId)) {
                //修改状态以及绑定id
                carScrapOrderService.addScrapOrder(Constants.ScrapOrderStatus.SCRAP_CAR, scrapOrderId, auction.getId(),auction.getCreateUser());
            }
        }else {
            List<String> autopartsIdList = auction.getAutopartsIdList();
            if(autopartsIdList != null && autopartsIdList.size()>0) {
                for (String autopartsId : autopartsIdList) {
                    //修改状态以及绑定id
                    carScrapOrderService.addScrapOrder(Constants.ScrapOrderStatus.SCRAP_AUTOPARTS, autopartsId, auction.getId(),auction.getCreateUser());
                }
            }
        }*/
        return res;
    }

}
