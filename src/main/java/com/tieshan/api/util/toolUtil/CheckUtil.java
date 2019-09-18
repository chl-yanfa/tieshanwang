package com.tieshan.api.util.toolUtil;

import com.tieshan.api.common.chebaofeiCommon.Exception.CheckException;
import org.springframework.context.MessageSource;

public class CheckUtil {
    private static MessageSource resources;


    public static void setResources(MessageSource resources) {
        CheckUtil.resources = resources;
    }

    public static void check(boolean condition, String msgKey, Object... args) {
        if (!condition) {
            fail(msgKey, args);
        }
    }

    public static void notEmpty(String str, String msgKey, Object... args) {
        if (str == null || str.isEmpty()) {
            fail(msgKey, args);
        }
    }

    public static void notNull(Object obj, String msgKey, Object... args) {
        if (obj == null) {
            fail(msgKey, args);
        }
    }

    private static void fail(String msgKey, Object... args) {
        String message = resources.getMessage(msgKey, args, UserUtil.getLocale());
        throw new CheckException(message);
    }
}
