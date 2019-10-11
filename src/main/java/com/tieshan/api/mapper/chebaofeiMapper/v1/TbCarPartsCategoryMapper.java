package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.po.chebaofeiPo.v1.TbCarPartsCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/10/9 14:02
 */
@Repository
public interface TbCarPartsCategoryMapper extends Mapper<TbCarPartsCategory> {
    List<TbCarPartsCategory> queryMyPageListByWhere(@Param("paramter")TbCarPartsCategory paramter)throws Exception;
}
