package com.qiang.wanandroid.base;

import java.io.Serializable;

/**
 * @auther lixiqiang
 * @data：2018/8/16 0016
 */
public class BaseResponse<T> implements Serializable {




    private int error;
    private String msg;
    private  T data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
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
