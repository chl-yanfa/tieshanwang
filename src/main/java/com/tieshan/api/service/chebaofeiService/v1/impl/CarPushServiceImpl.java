package com.tieshan.api.service.chebaofeiService.v1.impl;

import com.tieshan.api.mapper.chebaofeiMapper.v1.CarPushMapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarPush;
import com.tieshan.api.service.chebaofeiService.v1.CarPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 15:13
 */
@Service
public class CarPushServiceImpl implements CarPushService {
    @Autowired
    CarPushMapper carPushMapper;

    @Override
    public List<CarPush> getAllCarPush() {
        return carPushMapper.getAllCarPush();
    }

    @Override
    public List<CarPush> queryListByWhere(CarPush carPush) {
        return carPushMapper.getOneCarPush(carPush.getId());
    }

    @Override
    public int updateByCarPush(CarPush carPush) {
        return carPushMapper.updateByCarPush(carPush);
    }
}
