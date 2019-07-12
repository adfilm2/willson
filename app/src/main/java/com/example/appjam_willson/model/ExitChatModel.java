package com.example.appjam_willson.model;

public class ExitChatModel {
    int question_idx;
    String status = "complete";

    public int getQuestion_idx() {
        return question_idx;
    }

    public void setQuestion_idx(int question_idx) {
        this.question_idx = question_idx;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
