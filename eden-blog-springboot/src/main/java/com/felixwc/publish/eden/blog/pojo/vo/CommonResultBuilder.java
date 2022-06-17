package com.felixwc.publish.eden.blog.pojo.vo;

import com.felixwc.publish.eden.blog.pojo.vo.state.CommonState;

import java.util.Date;

/**
 * in order to learn java!
 * created at 2022/6/16 14:19
 *
 * @author felixwc
 */

// 系统返回结果的的构建者
public class CommonResultBuilder<T> {
    private CommonResult<T> commonResult;

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @author felixwc
     * @description //TODO 返回一个通用成功的状态
     * @date 20:44 2022/6/16
     **/
    public static CommonResult<Object> defaultSuccess() {
        return new CommonResult<>(CommonState.SUCCESS.getCode(), CommonState.SUCCESS.getDescription());
    }

    /**
     * @param msg - 失败原因
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @author felixwc
     * @Description //TODO 返回一个通用成功的状态
     * @Date 20:44 2022/6/16
     **/
    public static <R> CommonResult<R> defaultSuccess(String msg) {
        return new CommonResult<>(CommonState.SUCCESS.getCode(), msg);
    }

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @Author felixwc
     * @Description //TODO 返回一个通用失败的状态
     * @Date 20:45 2022/6/16
     **/
    public static <R> CommonResult<R> defaultFail() {
        return new CommonResult<>(CommonState.FAIL.getCode(), CommonState.FAIL.getDescription());
    }

    /**
     * @param msg - 失败的消息
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @author felixwc
     * @description //TODO 返回一个通用失败的状态
     * @date 20:45 2022/6/16
     **/
    public static <R> CommonResult<R> defaultFail(String msg) {
        return new CommonResult<>(CommonState.FAIL.getCode(), msg);
    }

    /**
     * @param msg - 失败的消息
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @author felixwc
     * @description //TODO 返回一个通用失败的状态
     * @date 20:45 2022/6/16
     **/

    /**
     * @param code - 状态码
     * @param msg  - 消息
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult<R>
     * @author felixwc
     * @description //TODO 返回一个通用失败的状态
     * @date 11:52 2022/6/17
     **/
    public static <R> CommonResult<R> defaultFail(String code, String msg) {
        return new CommonResult<>(code,msg);
    }


    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @Author felixwc
     * @Description //TODO 获取构建者
     * @Date 20:42 2022/6/16
     **/
    public CommonResultBuilder<T> startBuilder() {
        this.commonResult = new CommonResult<>();
        return this;
    }

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult<T>
     * @Author felixwc
     * @description //TODO 返回构建的对象
     * @date 20:42 2022/6/16
     **/
    public CommonResult<T> build() {
        return this.commonResult;
    }

    /**
     * @param msg - 返回的消息
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @author felixwc
     * @description //TODO 设置要传入的消息
     * @date 10:26 2022/6/17
     **/
    public CommonResultBuilder<T> setMessage(String msg) {
        commonResult.setMsg(msg);
        return this;
    }

    /**
     * @param code - 返回的状态码
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @author felixwc
     * @description //TODO 设置要传入的消息
     * @date 10:26 2022/6/17
     **/
    public CommonResultBuilder<T> setCode(String code) {
        commonResult.setCode(code);
        return this;
    }

    /**
     * @param data - 返回的数据
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @author felixwc
     * @description //TODO 设置要传入的消息
     * @date 10:26 2022/6/17
     **/
    public CommonResultBuilder<T> setData(T data) {
        commonResult.setData(data);
        return this;
    }

    /**
     * @param time - 返回的时间戳
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @author felixwc
     * @description //TODO 设置要传入的消息
     * @date 10:26 2022/6/17
     **/
    public CommonResultBuilder<T> setTime(Date time) {
        commonResult.setTime(time);
        return this;
    }

}
