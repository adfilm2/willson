package com.example.appjam_willson.model;

public class UserQuestionCreateResponseModel {

    String message;
    int code;
    public Object data;

    /*getter and setter start*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*getter and setter end*/
}
