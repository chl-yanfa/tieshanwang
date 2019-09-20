package com.tieshan.api.service.tieshanpaiService.v1.areas;

import com.tieshan.api.po.tieshanpaiPo.v1.areas.Areas;
import com.tieshan.api.service.BaseService;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/19 9:35
 */
public interface AreasService extends BaseService<Areas> {

    List<Areas> getAreas();
}
