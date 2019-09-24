package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAttachmentBO;
import com.tieshan.api.bo.chebaofeiBo.v1.OrderAttachmentBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAttachment;
import com.tieshan.api.po.chebaofeiPo.v1.Example.CarScrapOrderAttachmentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 14:27
 */
@Repository
public interface CarScrapOrderAttachmentMapper {

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

    List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid);

    List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(@Param("orderid") String orderid, @Param("attachmentType")String attachmentType, @Param("buniessType")String buniessType);
}
