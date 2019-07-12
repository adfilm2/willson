package com.example.appjam_willson.model;

import java.util.List;

public class AcceptHelperListWatchResponseModel {

    public int code;
    public String message;
    public List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    /*getter and setter end*/


    public static class Data {
        List<Accept_helper> helper;
        String[] experience;

        /*getter and setter start*/


        /*getter and setter end*/

    }

    public class Accept_helper {
        String nickname;
        String gender;
        String age;
        String category_name;
        String title;
        String content;
        String stars;
        String review_count;
        int helper_idx;

        /*getter and setter start*/


        /*getter and setter end*/

    }




}
