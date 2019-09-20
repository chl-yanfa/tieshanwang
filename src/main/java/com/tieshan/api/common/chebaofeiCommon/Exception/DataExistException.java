package com.tieshan.api.common.chebaofeiCommon.Exception;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 14:20
 */
public class DataExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataExistException() {
    }

    public DataExistException(String message) {
        super(message);
    }

    public DataExistException(Throwable cause) {
        super(cause);
    }

    public DataExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
    }
}
