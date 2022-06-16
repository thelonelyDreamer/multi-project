package com.felixwc.publish.eden.blog.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * in order to learn java!
 * created at 2022/6/15 13:11
 *
 * @author felixwc
 */
@Data
public class CommonResult<T> {
    private String code;
    private T data;
    private Date date;
    private String msg;

    public CommonResult() {
        this.date=new Date();
    }

    public CommonResult(String code) {
        this();
        this.code = code;
    }

    public CommonResult(String code, String msg) {
        this(code);
        this.msg = msg;
    }

    public CommonResult(String code, T data, String msg) {
        this(code,msg);
        this.data = data;
    }
}
