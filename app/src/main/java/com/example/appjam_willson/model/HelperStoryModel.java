package com.example.appjam_willson.model;

import java.util.List;

public class HelperStoryModel {
    public int code;
    public List<story> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<story> getData() {
        return data;
    }

    public void setData(List<story> data) {
        this.data = data;
    }

    public static class story{
        String nickname;
        String category_name;
        String content;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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
    }
}
