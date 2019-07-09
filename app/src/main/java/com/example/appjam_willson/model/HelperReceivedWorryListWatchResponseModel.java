package com.example.appjam_willson.model;

import java.util.List;

public class HelperReceivedWorryListWatchResponseModel {

    int code;
    String message;
    Data data;
    int size;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /*getter and setter end*/

    public class Data {
        List<Concern_Info> concerninfo;

        /*getter and setter start*/

        public List<Concern_Info> getConcerninfo() {
            return concerninfo;
        }

        public void setConcerninfo(List<Concern_Info> concerninfo) {
            this.concerninfo = concerninfo;
        }

        /*getter and setter end*/
    }

    public class Concern_Info {
        User user;
        Question_Info questionInfo;
        Category_Info categoryInfo;

        /*getter and setter start*/

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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
        String user_idx;
        String nickname;
        String gender;
        String age;

        /*getter and setter start*/

        public String getUser_idx() {
            return user_idx;
        }

        public void setUser_idx(String user_idx) {
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

        /*getter and setter start*/

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        /*getter and setter end*/

    }

    public class Category_Info {
        int category_id;
        String category_name;

        /*getter and setter start*/

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
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
