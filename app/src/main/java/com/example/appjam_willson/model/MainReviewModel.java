package com.example.appjam_willson.model;

import java.util.List;

public class MainReviewModel {
    public int code;
    public String message;
    public List<ReviewData> data;

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

    public List<ReviewData> getData() {
        return data;
    }

    public void setData(List<ReviewData> data) {
        this.data = data;
    }

    public static class ReviewData{
        public String category_name;
        public String content;
        public String nickname;

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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
