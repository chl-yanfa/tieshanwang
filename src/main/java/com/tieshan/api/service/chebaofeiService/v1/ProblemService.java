package com.tieshan.api.service.chebaofeiService.v1;

import com.github.pagehelper.PageInfo;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientProblemBO;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/24 9:27
 */
public interface ProblemService {

    PageInfo<ClientProblemBO> queryPageList(Integer page, Integer rows)throws Exception;

    ClientProblemBO queryBOById(String id)throws Exception;
}
