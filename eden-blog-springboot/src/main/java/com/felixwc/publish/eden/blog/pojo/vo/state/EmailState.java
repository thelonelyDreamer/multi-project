package com.felixwc.publish.eden.blog.pojo.vo.state;

import lombok.Getter;

/**
 * in order to learn java!
 * created at 2022/6/17 14:07
 *
 * @author felixwc
 */
@Getter
public enum EmailState {
    // AAB*
    SUCCESS("AAB0", "send successfully"),
    FAIL("AAB1", "fail to send"),
    ERROR_EMAIL("AAB2", "email address is wrong"),
    SEND_EMAIL_ALREADY("AAB3", "send already");

    EmailState(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
}
