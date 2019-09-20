package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAttachmentBO;
import com.tieshan.api.bo.chebaofeiBo.v1.OrderAttachmentBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAttachment;
import com.tieshan.api.po.chebaofeiPo.v1.Example.CarScrapOrderAttachmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:08
 */
public interface CarScrapOrderAttachmentService {
    int countByExample(CarScrapOrderAttachmentExample example);

    int deleteByExample(CarScrapOrderAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarScrapOrderAttachment record);

    int insertSelective(CarScrapOrderAttachment record);

    List<CarScrapOrderAttachment> selectByExample(CarScrapOrderAttachmentExample example);

    CarScrapOrderAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarScrapOrderAttachment record, @Param("example") CarScrapOrderAttachmentExample example);

    int updateByExample(@Param("record") CarScrapOrderAttachment record, @Param("example") CarScrapOrderAttachmentExample example);

    int updateByPrimaryKeySelective(CarScrapOrderAttachment record);

    int updateByPrimaryKey(CarScrapOrderAttachment record);

    public List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid);

    public List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(String orderid, String attachmentType, String buniessType);

    public Boolean deleteAttachmentByPrimaryKey(Integer id,String operator)throws Exception;
}
