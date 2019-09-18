package com.tieshan.api.util.toolUtil;

import java.util.UUID;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:52
 */
public class UUIDUtil {

    /***
     * 获得随机数字UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }



}
