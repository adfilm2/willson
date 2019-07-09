package com.example.appjam_willson.model;

public class ReviewWriteModel {

    public ReviewWrite review;

    public static class ReviewWrite{
        String stars;
        String review_content;
        int helper_idx;
        int category_idx;
        int question_idx;

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

        public int getHelper_idx() {
            return helper_idx;
        }

        public void setHelper_idx(int helper_idx) {
            this.helper_idx = helper_idx;
        }

        public int getCategory_idx() {
            return category_idx;
        }

        public void setCategory_idx(int category_idx) {
            this.category_idx = category_idx;
        }

        public int getQuestion_idx() {
            return question_idx;
        }

        public void setQuestion_idx(int question_idx) {
            this.question_idx = question_idx;
        }
    }
}
