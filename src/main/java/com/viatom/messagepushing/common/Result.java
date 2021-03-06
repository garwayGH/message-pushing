package com.viatom.messagepushing.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * json返回实体
 * @author qiujiawei
 * @date 2020.07.17
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("响应数据实体")
public class Result<T> {

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码",required = true,dataType = "int")
    private int code;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息",required = true,dataType = "String")
    private String msg;
    /**
     * 返回对象
     */
    @ApiModelProperty(value = "返回数据对象",dataType = "json",allowEmptyValue = true)
    private T data;

    /**
     * 成功返回数据
     * @param data 数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.msg(), data);
    }

    public static <T> Result<T> success() {
        return new Result<>(ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.msg());
    }

    public static <T> Result<T> error() {
        return new Result<>(ResponseCode.ERROR.code(), ResponseCode.ERROR.msg());
    }

    private Result(int code, String message) {
        this(code, message, null);
    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    private Result() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
