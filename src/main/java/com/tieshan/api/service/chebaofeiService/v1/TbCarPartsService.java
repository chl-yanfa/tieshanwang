package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarParts;
import com.tieshan.api.service.BaseService;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 14:44
 */
public interface TbCarPartsService extends BaseService<TbCarParts> {
    PageInfo<TbCarParts> queryByIdPageListByWhere(int page, int rows, TbCarParts paramter)throws Exception;
}
