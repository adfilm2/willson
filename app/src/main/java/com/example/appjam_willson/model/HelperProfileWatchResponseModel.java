package com.example.appjam_willson.model;

import java.util.List;

public class HelperProfileWatchResponseModel {

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
        List<Helper_profile> helper;
        List<Experience_profile> experience;
        List<Personality_profile> personality;

        /*getter and setter start*/

        public List<Helper_profile> getHelper() {
            return helper;
        }

        public void setHelper(List<Helper_profile> helper) {
            this.helper = helper;
        }

        public List<Experience_profile> getExperience() {
            return experience;
        }

        public void setExperience(List<Experience_profile> experience) {
            this.experience = experience;
        }

        public List<Personality_profile> getPersonality() {
            return personality;
        }

        public void setPersonality(List<Personality_profile> personality) {
            this.personality = personality;
        }

        /*getter and setter end*/

    }

    public class Helper_profile {

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

    public class Experience_profile {
        String experience_name;

        /*getter and setter start*/

        public String getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String experience_name) {
            this.experience_name = experience_name;
        }

        /*getter and setter end*/

    }

    public class Personality_profile {

        String personality_name;

        /*getter and setter start*/

        public String getPersonality_name() {
            return personality_name;
        }

        public void setPersonality_name(String personality_name) {
            this.personality_name = personality_name;
        }

        /*getter and setter end*/

    }

}
