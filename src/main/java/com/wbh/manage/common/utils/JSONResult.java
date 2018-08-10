package com.wbh.manage.common.utils;

import java.io.Serializable;

/**
 * 数据封装
 * @author wbh
 * @date 2018-08-08
 */
public class JSONResult<T> implements Serializable {

    private static final long serialVersionUID = 7880907731807860636L;
    /**
     * 数据
     */
    private T data;
    /**
     * 信息
     */
    private String message;
    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 是否成功
     *
     * @return
     */
    private boolean success;

    public JSONResult() {
    }

    public JSONResult(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
