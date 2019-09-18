package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.abel533.entity.Example;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import com.tieshan.api.mapper.chebaofeiMapper.v1.CarScrapInquiryPriceMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapInquiryPrice;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapInquiryPriceAttachment;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapInquiryPriceAttachmentService;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapInquiryPriceService;
import com.tieshan.api.util.toolUtil.CheckUtil;
import com.tieshan.api.util.toolUtil.UUIDUtil;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapInquiryPriceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:34
 */
@Service
public class CarScrapInquiryPriceServiceImpl extends BaseServiceImpl<CarScrapInquiryPrice> implements CarScrapInquiryPriceService {

    @Autowired
    private CarScrapInquiryPriceMapper carScrapInquiryPriceMapper;

    @Autowired
    private CarScrapInquiryPriceAttachmentService carScrapInquiryPriceAttachmentService;

    @Override
    public Integer save(CarScrapInquiryPriceVO inquiryPriceVO) throws Exception {
        CheckUtil.notNull(inquiryPriceVO, "param.is.null");
        CarScrapInquiryPrice record = new CarScrapInquiryPrice();
        BeanUtils.copyProperties(inquiryPriceVO, record);
        //校验订单
        boolean issuccuss = valid(record);
        if(issuccuss) {
            String id = UUIDUtil.getUUID();
            record.setId(id);
            record.setStatus(0);
            List<Integer> partsAttachmentIdList = inquiryPriceVO.getPartsAttachmentIdList();
            if(partsAttachmentIdList!=null && partsAttachmentIdList.size()>0) {
                for (Integer partsAttachmentId : partsAttachmentIdList) {
                    CarScrapInquiryPriceAttachment attachment = new CarScrapInquiryPriceAttachment();
                    attachment.setAttachmentId(partsAttachmentId);
                    attachment.setInquiryPriceId(id);
                    attachment.setIsremove(0);
                    carScrapInquiryPriceAttachmentService.save(attachment);
                }
            }
        }else {
            throw new DataException("询价数据异常");
        }
        return super.save(record);
    }

    private boolean valid(CarScrapInquiryPrice record){
        CheckUtil.notNull(record, "param.is.null");
        CheckUtil.notNull(record.getScrapType(), "param.is.null");
        CheckUtil.check((Integer.parseInt(record.getScrapType())>0), "param.is.null");
        CheckUtil.check((Integer.parseInt(record.getScrapType())<3), "param.is.null");
        return true;
    }

}
