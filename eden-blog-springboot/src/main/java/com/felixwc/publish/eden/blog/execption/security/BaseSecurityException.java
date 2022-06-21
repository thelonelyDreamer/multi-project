package com.felixwc.publish.eden.blog.execption.security;

/**
 * in order to learn java!
 * created at 2022/6/18 15:04
 *
 * @author felixwc
 */
public class BaseSecurityException extends RuntimeException{
    public BaseSecurityException() {
    }

    public BaseSecurityException(String message) {
        super(message);
    }

    public BaseSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseSecurityException(Throwable cause) {
        super(cause);
    }

    public BaseSecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
