package com.qiang.wanandroid.base;

import java.io.Serializable;

/**
 * @auther lixiqiang
 * @data：2018/8/16 0016
 */
public class BaseResponse<T> implements Serializable {

    private T data;
    private int errorCode;
    private String errorMsg;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
