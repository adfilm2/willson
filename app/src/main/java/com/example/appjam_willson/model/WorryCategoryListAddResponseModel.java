package com.example.appjam_willson.model;

public class WorryCategoryListAddResponseModel {

    public Result result;

    /*getter and setter start*/

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    /*getter and setter end*/

    public class Result {
        String message;
        int code;

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

        /*getter and setter end*/
    }

}
