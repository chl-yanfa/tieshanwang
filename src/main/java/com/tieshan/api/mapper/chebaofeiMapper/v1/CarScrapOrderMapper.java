package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderPageBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderQuotePageBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import com.tieshan.api.po.chebaofeiPo.v1.Example.CarScrapOrderExample;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderKeywordVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:22
 */
@Repository
public interface CarScrapOrderMapper extends Mapper<CarScrapOrder> {

    List<CarScrapOrderPageBO> queryPageListByWhere(CarScrapOrderExample example);

    List<CarScrapOrderPageBO> queryPageListByPush(@Param("id")String id);

    List<CarScrapOrderPageBO> queryPageListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO> queryPageListByKeywordByChl(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO> queryOldPartsWillReceivePageListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO> queryAll(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO> queryAllByChl(@Param("vo") CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO>  queryPageHistoryListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO>  queryPageHistoryListByKeywordByChl(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO>  queryPageListByKeywordByExamine(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO>  queryPageListByKeywordByExamineOK(@Param("vo")CarScrapOrderKeywordVO vo);

    List<CarScrapOrderPageBO>  queryPageListByKeywordByCancel(@Param("vo")CarScrapOrderKeywordVO vo);

    CarScrapOrderBO queryBOById(String id);

    List<CarScrapOrderQuotePageBO>  queryQuotePageListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);

    int updateCarScrapOrder(CarScrapOrder carScrapOrder);
}
