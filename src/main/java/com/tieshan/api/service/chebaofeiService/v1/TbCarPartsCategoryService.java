package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarPartsCategory;
import com.tieshan.api.service.BaseService;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 13:59
 */
public interface TbCarPartsCategoryService extends BaseService<TbCarPartsCategory> {
    PageInfo<TbCarPartsCategory> queryMyPageListByWhere(int page, int rows, TbCarPartsCategory paramter)throws Exception;
}
