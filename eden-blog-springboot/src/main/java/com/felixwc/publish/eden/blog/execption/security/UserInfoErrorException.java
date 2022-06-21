package com.felixwc.publish.eden.blog.execption.security;

/**
 * in order to learn java!
 * created at 2022/6/18 23:54
 *
 * @author felixwc
 */
public class UserInfoErrorException extends BaseSecurityException{
    public UserInfoErrorException() {
        super();
    }

    public UserInfoErrorException(String message) {
        super(message);
    }

    public UserInfoErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInfoErrorException(Throwable cause) {
        super(cause);
    }

    public UserInfoErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
