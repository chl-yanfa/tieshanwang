package com.tieshan.api.common.chebaofeiCommon.Exception;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:41
 */
public class AttachmentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AttachmentException() {
    }

    public AttachmentException(String message) {
        super(message);
    }

    public AttachmentException(Throwable cause) {
        super(cause);
    }

    public AttachmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttachmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
    }

}