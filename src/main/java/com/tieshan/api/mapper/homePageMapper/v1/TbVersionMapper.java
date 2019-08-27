package com.tieshan.api.mapper.homePageMapper.v1;

import com.tieshan.api.po.homePagePo.bo.v1.TbVersion;

public interface TbVersionMapper {
    //根据OC查询
    TbVersion selectByPrimaryKey(Integer oc);


}