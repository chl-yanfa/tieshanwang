package com.tieshan.api.service.tieshanpaiService.v1.auction.impl;

import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.PMNumberMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.auction.PMNumber;
import com.tieshan.api.service.tieshanpaiService.v1.auction.PMNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/8 13:46
 */
@Service
public class PMNumberServiceImple implements PMNumberService {


    @Autowired
    private PMNumberMapper pmNumberMapper;

    /**
     * getAuctionNo 生成拍品编号
     * C-20180714-01 类型+年月日+序号（递增）
     */
    @Override
    public synchronized String getAuctionNo() {
        String format = "";
        StringBuffer sb=new StringBuffer();
        Date date = new Date();
        try {
            PMNumber pMNumber = pmNumberMapper.getPMNumberByType(0);
            Integer number = pMNumber.getNumber();
            sb.append("C-");
            String time=new SimpleDateFormat("yyyyMMdd").format(date);//20180620
            sb.append(time+"-");
            DecimalFormat decimalFormat = new DecimalFormat("00");
            sb.append(decimalFormat.format(number));
            pmNumberMapper.updatePMNumberById(pMNumber.getId());
            format=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * getOrderNo 生成订单编号
     * D-20180714-01 类型+年月日+序号（递增）
     */
    @Override
    public synchronized String getOrderNo() {
        String format = "";
        StringBuffer sb=new StringBuffer();
        Date date = new Date();
        try {
            PMNumber pMNumber = pmNumberMapper.getPMNumberByType(1);
            Integer number = pMNumber.getNumber();
            sb.append("D-");
            String time=new SimpleDateFormat("yyyyMMdd").format(date);//20180620
            sb.append(time+"-");
            DecimalFormat decimalFormat = new DecimalFormat("00");
            sb.append(decimalFormat.format(number));
            pmNumberMapper.updatePMNumberById(pMNumber.getId());
            format=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * getPmhID 生成拍卖会ID
     * PM-20180714-01  类型+年月日+序号（递增）
     */
    @Override
    public synchronized String getPmhID() {
        String format = "";
        StringBuffer sb=new StringBuffer();
        Date date = new Date();
        try {
            PMNumber pMNumber = pmNumberMapper.getPMNumberByType(2);
            Integer number = pMNumber.getNumber();
            sb.append("PM-");
            String time=new SimpleDateFormat("yyyyMMdd").format(date);//20180620
            sb.append(time+"-");
            DecimalFormat decimalFormat = new DecimalFormat("00");
            sb.append(decimalFormat.format(number));
            pmNumberMapper.updatePMNumberById(pMNumber.getId());
            format=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return format;
    }
}
