package com.tieshan.api.common.chebaofeiCommon.Exception;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/18 13:51
 */
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
    }

}