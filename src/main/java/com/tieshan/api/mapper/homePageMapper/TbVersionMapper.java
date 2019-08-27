package com.tieshan.api.mapper.homePageMapper;

import com.tieshan.api.po.homePagePo.bo.TbVersion;

public interface TbVersionMapper {
    //根据OC查询
    TbVersion selectByPrimaryKey(Integer oc);


}