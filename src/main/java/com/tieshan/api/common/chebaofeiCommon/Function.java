package com.tieshan.api.common.chebaofeiCommon;

/**
 * @author ningrz
 * @version 1.0 redisService调用回调接口函数
 * @date 2019/9/12 11:30
 */
public interface Function<E, T> {

    public T callBack(E e);

}