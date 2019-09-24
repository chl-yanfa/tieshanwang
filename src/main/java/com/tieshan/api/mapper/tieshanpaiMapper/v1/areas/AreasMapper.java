package com.tieshan.api.mapper.tieshanpaiMapper.v1.areas;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.po.tieshanpaiPo.v1.areas.Areas;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 9:19
 */
@Repository
public interface AreasMapper extends Mapper<Areas> {

    List<Areas> getAreas();

}
