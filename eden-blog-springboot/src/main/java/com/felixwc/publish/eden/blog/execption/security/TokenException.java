package com.felixwc.publish.eden.blog.execption.security;

/**
 * in order to learn java!
 * created at 2022/6/19 11:35
 *
 * @author felixwc
 */
public class TokenException extends BaseSecurityException{
    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }

    public TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
