package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAttachmentBO;
import com.tieshan.api.bo.chebaofeiBo.v1.OrderAttachmentBO;
import com.tieshan.api.mapper.chebaofeiMapper.v1.CarScrapOrderAttachmentMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAttachment;
import com.tieshan.api.po.chebaofeiPo.v1.Example.CarScrapOrderAttachmentExample;
import com.tieshan.api.po.chebaofeiPo.v1.TbAttachment;
import com.tieshan.api.service.chebaofeiService.v1.CarScrapOrderAttachmentService;
import com.tieshan.api.service.chebaofeiService.v1.TbAttachmentService;
import com.tieshan.api.util.toolUtil.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:25
 */
@Service
public class CarScrapOrderAttachmentServiceImpl implements
        CarScrapOrderAttachmentService {

    @Autowired
    private TbAttachmentService tbAttachmentService;

    @Autowired
    private CarScrapOrderAttachmentMapper carScrapOrderAttachmentMapper;

    @Override
    public int countByExample(CarScrapOrderAttachmentExample example) {

        return carScrapOrderAttachmentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CarScrapOrderAttachmentExample example) {

        return carScrapOrderAttachmentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {

        return carScrapOrderAttachmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CarScrapOrderAttachment record) {
        record.setId(null);
        return carScrapOrderAttachmentMapper.insert(record);
    }

    @Override
    public int insertSelective(CarScrapOrderAttachment record) {
        record.setId(null);
        return carScrapOrderAttachmentMapper.insertSelective(record);
    }

    @Override
    public List<CarScrapOrderAttachment> selectByExample(
            CarScrapOrderAttachmentExample example) {

        return carScrapOrderAttachmentMapper.selectByExample(example);
    }

    @Override
    public CarScrapOrderAttachment selectByPrimaryKey(Integer id) {
        return carScrapOrderAttachmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(CarScrapOrderAttachment record,
                                        CarScrapOrderAttachmentExample example) {

        return carScrapOrderAttachmentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CarScrapOrderAttachment record,
                               CarScrapOrderAttachmentExample example) {

        return carScrapOrderAttachmentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(CarScrapOrderAttachment record) {

        return carScrapOrderAttachmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CarScrapOrderAttachment record) {

        return carScrapOrderAttachmentMapper.updateByPrimaryKey(record);
    }

    public List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid){
        CheckUtil.notEmpty(orderid, "param is null");
        return carScrapOrderAttachmentMapper.getArrachmentByOrderByid(orderid);
    }

    public List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(String orderid, String attachmentType, String buniessType){
        CheckUtil.notEmpty(orderid, "param is null");
        CheckUtil.notEmpty(attachmentType, "param is null");
        return carScrapOrderAttachmentMapper.getArrachmentByOrderIdAndAttachmentType(orderid,attachmentType,buniessType);
    }


    public Boolean deleteAttachmentByPrimaryKey(Integer id,String operator)throws Exception{
        CarScrapOrderAttachment carScrapOrderAttachment = this.selectByPrimaryKey(id);
        if(carScrapOrderAttachment!=null){

            TbAttachment tbAttachment = tbAttachmentService.queryById(carScrapOrderAttachment.getAttachmentId());

            if(tbAttachment!=null){
                carScrapOrderAttachment.setIsvalid(false);
                this.updateByPrimaryKey(carScrapOrderAttachment);
                tbAttachment.setOperator(operator);
                tbAttachment.setIsvalid(false);
                tbAttachmentService.update(tbAttachment);
                return true;
            }
        }
        return true;
    }

}
