package com.example.appjam_willson.model;

import java.util.List;

public class HelperReceivedWorryListWatchResponseModel {

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
        List<Concern_Info> concernInfo;
        int size;

        /*getter and setter start*/

        public List<Concern_Info> getConcernInfo() {
            return concernInfo;
        }

        public void setConcernInfo(List<Concern_Info> concernInfo) {
            this.concernInfo = concernInfo;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        /*getter and setter end*/
    }

    public class Concern_Info {
        User userInfo;
        Question_Info questionInfo;
        Category_Info categoryInfo;

        /*getter and setter start*/

        public User getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(User userInfo) {
            this.userInfo = userInfo;
        }

        public Question_Info getQuestionInfo() {
            return questionInfo;
        }

        public void setQuestionInfo(Question_Info questionInfo) {
            this.questionInfo = questionInfo;
        }

        public Category_Info getCategoryInfo() {
            return categoryInfo;
        }

        public void setCategoryInfo(Category_Info categoryInfo) {
            this.categoryInfo = categoryInfo;
        }

        /*getter and setter end*/
    }

    public class User {
        int user_idx;
        String nickname;
        String gender;
        String age;

        /*getter and setter start*/

        public int getUser_idx() {
            return user_idx;
        }

        public void setUser_idx(int user_idx) {
            this.user_idx = user_idx;
        }

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

        /*getter and setter end*/

    }

    public class Question_Info {
        String title;
        int question_idx;
        String create_time;
        String selected;

        /*getter and setter start*/

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getQuestion_idx() {
            return question_idx;
        }

        public void setQuestion_idx(int question_idx) {
            this.question_idx = question_idx;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getSelected() {
            return selected;
        }

        public void setSelected(String selected) {
            this.selected = selected;
        }

        /*getter and setter end*/

    }

    public class Category_Info {
        int category_idx;
        String category_name;

        /*getter and setter start*/

        public int getCategory_idx() {
            return category_idx;
        }

        public void setCategory_idx(int category_idx) {
            this.category_idx = category_idx;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        /*getter and setter end*/

    }


}
