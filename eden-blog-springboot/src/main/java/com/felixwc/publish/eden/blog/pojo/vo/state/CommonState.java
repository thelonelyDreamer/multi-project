package com.felixwc.publish.eden.blog.pojo.vo.state;

/**
 * in order to learn java!
 * created at 2022/6/16 19:37
 *
 * @author felixwc
 */
public enum CommonState {
    // 0000-0099 表示操作成功
    // 0100-0199 表示操作失败
    // 其余备用

    // 操作成功
    SUCCESS("0000","success"),
    // 操作失败
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
