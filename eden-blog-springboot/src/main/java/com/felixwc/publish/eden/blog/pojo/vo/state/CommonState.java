package com.felixwc.publish.eden.blog.pojo.vo.state;

/**
 * in order to learn java!
 * created at 2022/6/16 19:37
 *
 * @author felixwc
 */
public enum CommonState {
    SUCCESS("0000","success"),
    FAIL("0100","fail");
    private String code;
    private String description;

    CommonState(String code, String description) {
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
