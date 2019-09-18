package com.tieshan.api.common.chebaofeiCommon.Exception;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 10:29
 */
public class UserNamePasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNamePasswordException() {
    }

    public UserNamePasswordException(String message) {
        super(message);
    }

    public UserNamePasswordException(Throwable cause) {
        super(cause);
    }

    public UserNamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNamePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
    }
}
