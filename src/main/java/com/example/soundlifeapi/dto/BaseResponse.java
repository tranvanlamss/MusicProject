package com.example.soundlifeapi.dto;

public class BaseResponse <T>{
    public int status = 1;
    public String message = "success";
    public T data;

    public BaseResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
