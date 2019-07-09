package com.example.appjam_willson.model;

import java.util.List;

public class AcceptHelperListWatchResponseModel {

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
        List<Accept_helper> helper;
        List<Accept_Experience> experience;

        /*getter and setter start*/

        public List<Accept_helper> getHelper() {
            return helper;
        }

        public void setHelper(List<Accept_helper> helper) {
            this.helper = helper;
        }

        public List<Accept_Experience> getExperience() {
            return experience;
        }

        public void setExperience(List<Accept_Experience> experience) {
            this.experience = experience;
        }

        /*getter and setter end*/

    }

    public class Accept_helper {
        String nickname;
        String gender;
        String age;
        String category_name;
        String content;
        String stars;
        String review_count;

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

        /*getter and setter end*/

    }

    public class Accept_Experience {
        String[] experience_name;

        /*getter and setter start*/

        public String[] getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String[] experience_name) {
            this.experience_name = experience_name;
        }

        /*getter and setter end*/

    }


}
