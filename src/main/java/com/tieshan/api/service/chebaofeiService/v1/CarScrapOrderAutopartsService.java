package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAutopartsBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderAutopartsDetailBO;
import com.tieshan.api.bo.chebaofeiBo.v1.CarScrapOrderPageBO;
import com.tieshan.api.bo.chebaofeiBo.v1.OrderAttachmentBO;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAutoparts;
import com.tieshan.api.service.BaseService;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderAutopartsVO;
import com.tieshan.api.vo.chebaofeiVo.v1.CarScrapOrderKeywordVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 10:51
 */
public interface CarScrapOrderAutopartsService extends BaseService<CarScrapOrderAutoparts> {

    CarScrapOrderAutoparts queryById(String id);

    CarScrapOrderAutopartsBO queryBOById(String id)throws Exception;

    Integer  saveAutoparts(CarScrapOrderAutopartsVO carScrapOrderAutopartsVO)throws Exception;

    CarScrapOrderAutopartsDetailBO getOrderAutopartsDetailById(String id)throws Exception;

    List<CarScrapOrderAutopartsBO> queryListByOrderId(String orderid)throws Exception;

    PageInfo<CarScrapOrderPageBO> queryBOPageListByWhere(Integer page, Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO> getSortingParts(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;

    PageInfo<CarScrapOrderPageBO> queryHistoryBOPageList(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;

    Integer saveOrderAutopartsAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrderAutoparts parts)throws Exception;

    Integer queryPendingOrder(String agentUserid,Integer partsStauts,List<String> areasids,Boolean isSorting)throws Exception;

    String createQRcode(String partsid)throws Exception;

    Boolean saveSortingParts(String id,Integer sortingStatus, String operator)throws Exception;

    OrderAttachmentBO importFile(MultipartFile file, String id)throws Exception ;

    Integer selectCount(CarScrapOrderKeywordVO paramter)throws Exception ;

    boolean removeFile(Integer attachmentId, String operator)throws Exception ;

    Integer  updateAutopartsByIdSelective(CarScrapOrderAutoparts record)throws Exception;

    Integer deleteById(String id);
}
