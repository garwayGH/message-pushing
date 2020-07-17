package com.viatom.messagepushing.common;

import java.io.Serializable;

/**
 * json返回实体
 * @author qiujiawei
 * @date 2020.07.17
 * @param <T>
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 7528805354442762223L;

    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_FAILURE = -1;

    /**
     * 返回代码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回对象
     */
    private Object data;

    public Result(int code, String message) {
        this(code, message, "");
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
