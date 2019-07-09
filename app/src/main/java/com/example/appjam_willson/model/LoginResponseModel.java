package com.example.appjam_willson.model;

public class LoginResponseModel {

    int code;
    String message;
    Data data;

    /*getter and setter start*/

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /*getter and setter end*/

    public class Data {
        String Token;
        String email;
        String password;

        /*getter and setter start*/

        public String getToken() {
            return Token;
        }

        public void setToken(String token) {
            Token = token;
        }

        /*getter and setter end*/
    }

}
