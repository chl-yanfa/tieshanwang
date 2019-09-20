package com.tieshan.api.mapper.chebaofeiMapper.v1;

import com.github.abel533.mapper.Mapper;
import com.tieshan.api.po.chebaofeiPo.v1.CarPush;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 15:13
 */
@Repository
public interface CarPushMapper extends Mapper<CarPush> {

    List<CarPush> getAllCarPush();

    List<CarPush> getOneCarPush(Integer id);

    int updateByCarPush(CarPush carPush);
}
