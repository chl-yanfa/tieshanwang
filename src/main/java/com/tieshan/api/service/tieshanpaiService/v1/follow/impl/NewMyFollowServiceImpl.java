package com.tieshan.api.service.tieshanpaiService.v1.follow.impl;

import com.tieshan.api.mapper.tieshanpaiMapper.v1.follow.NewMyFollowMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.follow.FollowSelect;
import com.tieshan.api.po.tieshanpaiPo.v1.follow.NewMyFollow;
import com.tieshan.api.service.tieshanpaiService.v1.follow.NewMyFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewMyFollowServiceImpl implements NewMyFollowService {
    @Autowired
    private NewMyFollowMapper newMyFollowMapper;
    @Override
    public int insertSelective(NewMyFollow record) {
        return newMyFollowMapper.insertSelective(record);
    }

    @Override
    public List<NewMyFollow> selectMap(Map map) {
        return newMyFollowMapper.selectMap(map);
    }

    @Override
    public FollowSelect select(String userId) {
        return newMyFollowMapper.select(userId);
    }

    @Override
    public Integer delete(Integer id) {
        return newMyFollowMapper.delete(id);
    }


}
