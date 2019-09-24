package com.tieshan.api.vo.chebaofeiVo.v1;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 9:32
 */
@Data
public class CarScrapOrderExternalVO extends CarScrapOrderVO {
    //委托方(当前登录用户id)
    private String clientId;

    //申请客户类型（1：个人 2：大客户）,系统根据登录人判断
    private String clientType;

    private String pid;

    private String type;

    private String cityId;

    private String carNumberId;
}
