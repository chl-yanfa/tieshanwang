package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfo;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfoBO;
import com.tieshan.api.service.BaseService;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:48
 */
public interface TbCommonMailinginfoService extends BaseService<TbCommonMailinginfo> {
    PageInfo<TbCommonMailinginfoBO> queryListByWhere(Integer page, Integer rows, TbCommonMailinginfo paramter);
}
