package com.tieshan.api.service.homePageService;

import com.tieshan.api.po.homePagePo.bo.TbVersion;

public interface TbVersionService {
    //根据OC查询
    TbVersion selectByPrimaryKey(Integer oc);
}
