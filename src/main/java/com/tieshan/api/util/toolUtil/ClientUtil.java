package com.tieshan.api.util.toolUtil;

import com.tieshan.api.bo.chebaofeiBo.v1.ClientBO;
import com.tieshan.api.common.chebaofeiCommon.Exception.DataException;
import org.slf4j.MDC;

import java.util.Locale;

/**
 * 检查铁扇网App用户是否登陆工具类
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 9:48
 */
public class ClientUtil {

    private final static ThreadLocal<ClientBO> tlUser = new ThreadLocal<ClientBO>();

    private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
        protected Locale initialValue() {
            // 语言的默认值
            return Locale.CHINESE;
        };
    };




    public static final String KEY_USER = "user";
    public static final String KEY_LANG = "lang";

    public static void setUser(ClientBO user) {
        tlUser.set(user);
        // 把用户信息放到log4j
        MDC.put(KEY_USER, user.getId());
    }



    /**
     * 如果没有登录会抛出异常
     *
     * @return
     * @throws DataException
     */
    public static ClientBO getUser() throws DataException {
        ClientBO user = tlUser.get();
        if (user == null) {
            throw new DataException("未登录系统");
        }
        return user;
    }



    public static void setLocale(String locale) {
        setLocale(new Locale(locale));
    }

    public static void setLocale(Locale locale) {
        tlLocale.set(locale);
    }

    public static Locale getLocale() {
        return tlLocale.get();
    }



    public static void clearAllUserInfo() {
        tlUser.remove();


        MDC.remove(KEY_USER);
    }
}
