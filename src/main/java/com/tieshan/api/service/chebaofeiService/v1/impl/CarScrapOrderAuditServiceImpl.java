package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.github.abel533.entity.Example;
import com.tieshan.api.mapper.chebaofeiMapper.v1.CarScrapOrderAuditMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAudit;
import com.tieshan.api.service.Impl.BaseServiceImpl;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:11
 */
@Service
public class CarScrapOrderAuditServiceImpl extends BaseServiceImpl<CarScrapOrderAudit> implements CarScrapOrderAuditService {

    @Autowired
    private CarScrapOrderAuditMapper carScrapOrderAuditMapper;

    public Integer save(CarScrapOrderAudit record) throws Exception{
        //查询上一次订单id
        Example example =new Example(CarScrapOrderAudit.class);
        example.setOrderByClause("audit_time desc ,id desc");
        example.createCriteria().andEqualTo("orderId", record.getOrderId());

        List<CarScrapOrderAudit> carScrapOrderAuditList = super.queryListByExample(example);
        if(carScrapOrderAuditList.size()>0){
            CarScrapOrderAudit lastAuditData = carScrapOrderAuditList.get(0);
            record.setLasttimeId(lastAuditData.getId());
        }
        return super.save(record);
    }
}
