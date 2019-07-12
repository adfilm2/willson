package com.example.appjam_willson.model;

import java.util.List;

public class AcceptHelperListWatchResponseModel {

    public int code;
    public String message;
    public Data data;

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


    public static class Data {
        List<Helper_list> helper_list;

        /*getter and setter start*/

        public List<Helper_list> getHelper_list() {
            return helper_list;
        }

        public void setHelper_list(List<Helper_list> helper_list) {
            this.helper_list = helper_list;
        }
    }
        /*getter and setter end*/

    public class Helper_list {
        Accept_helper helper;
        List<String> experience;

        public Accept_helper getHelper() {
            return helper;
        }

        public void setHelper(Accept_helper helper) {
            this.helper = helper;
        }

        public List<String> getExperience() {
            return experience;
        }

        public void setExperience(List<String> experience) {
            this.experience = experience;
        }
    }

    public class Accept_helper {
        String nickname;
        String gender;
        String age;
        int category_idx;
        int categoryList_idx;
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

        public int getCategory_idx() {
            return category_idx;
        }

        public void setCategory_idx(int category_idx) {
            this.category_idx = category_idx;
        }

        public int getCategoryList_idx() {
            return categoryList_idx;
        }

        public void setCategoryList_idx(int categoryList_idx) {
            this.categoryList_idx = categoryList_idx;
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

