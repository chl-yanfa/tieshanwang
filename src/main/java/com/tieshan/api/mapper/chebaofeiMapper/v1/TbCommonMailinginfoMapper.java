package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfo;
import com.tieshan.api.bo.chebaofeiBo.v1.TbCommonMailinginfoBO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 13:24
 */
@Repository
public interface TbCommonMailinginfoMapper extends Mapper<TbCommonMailinginfo> {
    List<TbCommonMailinginfoBO> queryListByWhere(TbCommonMailinginfo paramter);
}
