package com.example.appjam_willson.model;

import java.util.List;

public class ReviewListResponseModel {

    int code;
    String message;
    List<ReviewInfo> data;

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

    public List<ReviewInfo> getData() {
        return data;
    }

    public void setData(List<ReviewInfo> data) {
        this.data = data;
    }

    public static class ReviewInfo {

        int review_idx;
        String stars;
        String review_content;
        String write_date;
        String category_name;
        String nickname;

        public int getReview_idx() {
            return review_idx;
        }

        public void setReview_idx(int review_idx) {
            this.review_idx = review_idx;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public String getReview_content() {
            return review_content;
        }

        public void setReview_content(String review_content) {
            this.review_content = review_content;
        }

        public String getWrite_date() {
            return write_date;
        }

        public void setWrite_date(String write_date) {
            this.write_date = write_date;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
