package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAutopartsBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAutopartsDetailBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderPageBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAutoparts;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderKeywordVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:07
 */
@Repository
public interface CarScrapOrderAutopartsMapper extends Mapper<CarScrapOrderAutoparts> {
    CarScrapOrderAutopartsBO queryBOById(String id);

    CarScrapOrderAutopartsDetailBO getOrderAutopartsDetailById(String id);

    List<CarScrapOrderAutopartsBO> queryListByOrderId(String orderid);

    List<CarScrapOrderPageBO> queryBOPageList(@Param("vo") CarScrapOrderKeywordVO paramter);

    List<CarScrapOrderPageBO> getSortingParts(@Param("vo")CarScrapOrderKeywordVO paramter);

    List<CarScrapOrderPageBO> queryHistoryBOPageList(@Param("vo")CarScrapOrderKeywordVO paramter);

    Long queryBOPageListCount(@Param("vo")CarScrapOrderKeywordVO paramter);

    Integer queryPendingOrder(@Param("agentUserid")String agentUserid,@Param("partsStauts")Integer partsStauts,@Param("areasids")List<String> areasids,@Param("isSorting")Boolean isSorting);

    Integer selectPartCount(@Param("vo")CarScrapOrderKeywordVO paramter);

    int updateCarScrapOrderAutoparts(CarScrapOrderAutoparts carScrapOrderAutoparts);
}
