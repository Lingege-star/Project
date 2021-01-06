package com.example.myapplication.bean;

public class DeviceBean {

    /**
     * code : 200
     * message : 成功
     * data : 251adca7f6e5b89f0efc43711c0ba249
     */

    private String code;
    private String message;
    private String data;

    @Override
    public String toString() {
        return "DeviceBean{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
