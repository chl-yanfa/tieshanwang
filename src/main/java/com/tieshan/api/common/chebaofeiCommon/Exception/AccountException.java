package com.tieshan.api.common.chebaofeiCommon.Exception;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:11
 */
public class AccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
    }
}