package com.example.appjam_willson.model;

import java.util.HashMap;
import java.util.Map;

public class ChatModel {

    public Map<String,Boolean> users = new HashMap<>(); //채팅방의 유저들
    public Map<String,Comment> comments = new HashMap<>(); //채팅방의 대화내용
    public Map<String,Object> chatStart = new HashMap<>();

    public static class Comment {

        public Comment(){

        }

        public Comment(int type){
            this.type = type;
        }

        public int type=1;

        public String uid;
        public String message;
        public Object timeStamp;
        public Map<String, Object> readUser = new HashMap<>();   //읽은 유저 체크
    }

}
