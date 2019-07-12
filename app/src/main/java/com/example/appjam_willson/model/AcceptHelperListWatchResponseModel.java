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

        public List<Accept_helper> getHelper() {
            return helper;
        }

        public void setHelper(List<Accept_helper> helper) {
            this.helper = helper;
        }

        public String[] getExperience() {
            return experience;
        }

        public void setExperience(String[] experience) {
            this.experience = experience;
        }

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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public String getReview_count() {
            return review_count;
        }

        public void setReview_count(String review_count) {
            this.review_count = review_count;
        }

        public int getHelper_idx() {
            return helper_idx;
        }

        public void setHelper_idx(int helper_idx) {
            this.helper_idx = helper_idx;
        }

        /*getter and setter end*/

    }

}
