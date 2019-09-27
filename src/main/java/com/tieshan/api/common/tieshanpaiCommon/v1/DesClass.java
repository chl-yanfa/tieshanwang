package com.tieshan.api.common.tieshanpaiCommon.v1;

import com.tieshan.api.util.toolUtil.OrderByUtils;

import java.util.Comparator;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/26 15:22
 */
public class DesClass implements Comparator {
    public int compare(Object arg0, Object arg1) {
        OrderByUtils user0 = (OrderByUtils) arg0;
        OrderByUtils user1 = (OrderByUtils) arg1;
        int flag = user1.getDetail().getPaimaiStartTime().compareTo(user0.getDetail().getPaimaiStartTime());
        return flag;
    }
}
