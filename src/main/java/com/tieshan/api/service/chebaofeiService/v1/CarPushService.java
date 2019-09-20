package com.tieshan.api.service.chebaofeiService.v1;

import com.tieshan.api.po.chebaofeiPo.v1.CarPush;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:49
 */
public interface CarPushService {
    List<CarPush> getAllCarPush();
    List<CarPush> queryListByWhere(CarPush carPush);
    int updateByCarPush(CarPush carPush);
}
