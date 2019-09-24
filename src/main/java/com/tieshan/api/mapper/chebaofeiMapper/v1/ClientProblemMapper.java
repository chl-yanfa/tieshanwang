package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.ClientProblemBO;
import com.tieshan.api.po.chebaofeiPo.v1.ClientProblem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/24 9:48
 */
@Repository
public interface ClientProblemMapper extends Mapper<ClientProblem> {

    List<ClientProblemBO> queryPageList();

    ClientProblemBO queryBOById(String id);
}
