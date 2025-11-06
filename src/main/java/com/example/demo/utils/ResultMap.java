package com.example.demo.utils;

import java.util.Map;

public class ResultMap<T> {
    private boolean success;
    private String message;
    private T data;

    public ResultMap() {
        this.success = false;
        this.message = "";
        this.data = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
