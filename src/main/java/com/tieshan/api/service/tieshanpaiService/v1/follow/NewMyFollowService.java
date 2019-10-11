package com.tieshan.api.service.tieshanpaiService.v1.follow;

import com.tieshan.api.po.tieshanpaiPo.v1.follow.FollowSelect;
import com.tieshan.api.po.tieshanpaiPo.v1.follow.NewMyFollow;

import java.util.List;
import java.util.Map;

public interface NewMyFollowService {
    //新增关注
    int insertSelective(NewMyFollow record);
    //查询关注列表
    List<NewMyFollow> selectMap(Map map);
    //根据用户id查询关注
    FollowSelect select(String userId);
    //删除关注
    Integer delete(Integer id);
}
