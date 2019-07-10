package com.example.appjam_willson.model;

public class CreateWorryResponseModel {
    String message;
    int code;
    public Data data;

    public class Data{
        public int question_idx;
    }
}
