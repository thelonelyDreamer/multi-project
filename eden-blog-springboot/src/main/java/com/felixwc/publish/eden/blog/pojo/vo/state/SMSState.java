package com.felixwc.publish.eden.blog.pojo.vo.state;

import lombok.Getter;

/**
 * in order to learn java!
 * created at 2022/6/17 11:42
 *
 * @author felixwc
 */
// 短信验证码相关的状态
@Getter
public enum SMSState {
    // AAA*
    SUCCESS("AAA0", "send successfully"),
    FAIL("AAA1", "fail to send"),
    ERROR_NUMBER("AAA2", "number is wrong"),
    SEND_ALREADY("AAA3", "send already");

    SMSState(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
}
