package com.felixwc.publish.eden.blog.pojo.vo.state;

/**
 * in order to learn java!
 * created at 2022/6/18 16:33
 *
 * @author felixwc
 */
public enum SecurityState {
    // AA**
    JWT_SUCCESS("AA00", "succeed to obtain jwt token."),
    JWT_FAIL("AA01", "failed to obtain jwt token."),
    JWT_INVALID("AA03","jwt is invalid."),
    UNKNOWN_ERROR("AA04","unknown error."),
    USER_NOT_EXIST("AA05","user not exist."),
    USER_CERTIFICATE_INVALID("AA06","The user have no certificate."),
    USER_INFO_ERROR("AA07","The user's information is invalid.");
    private String code;
    private String description;

    SecurityState(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
