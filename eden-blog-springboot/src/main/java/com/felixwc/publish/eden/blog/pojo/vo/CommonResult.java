package com.felixwc.publish.eden.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * in order to learn java!
 * created at 2022/6/15 13:11
 *
 * @author felixwc
 */
@Data
@ApiModel(value = "commonResult",description = "common returned type")
public class CommonResult<T> {

    @ApiModelProperty(value = "请求返回的系统状态码")
    private String code;
    @ApiModelProperty("返回的数据")
    private T data;
    @ApiModelProperty("返回的时间")
    private Date time;
    @ApiModelProperty("返回的消息")
    private String msg;

    public CommonResult() {
        this.time=new Date();
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
