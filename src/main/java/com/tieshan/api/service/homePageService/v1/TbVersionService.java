package com.tieshan.api.service.homePageService.v1;

import com.tieshan.api.po.homePagePo.v1.TbVersion;

public interface TbVersionService {
    //根据OC查询
    TbVersion selectByPrimaryKey(Integer oc);
}
