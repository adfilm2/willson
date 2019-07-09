package com.example.appjam_willson.model;

public class ReviewFixModel {
    public ReviewFix review;

    public ReviewFix getReview() {
        return review;
    }

    public void setReview(ReviewFix review) {
        this.review = review;
    }

    public static class ReviewFix{
        String stars;
        String review_content;

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
    }
}
