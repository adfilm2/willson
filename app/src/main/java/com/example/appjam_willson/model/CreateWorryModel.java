package com.example.appjam_willson.model;

import android.support.v4.app.INotificationSideChannel;

public class CreateWorryModel {

    public Question question;
    public Integer[] feeling;
    public Integer[] personality;
    public Integer[] experience;

    public static class Question{
        public Integer weight;
        public String content;
        public Integer emotion;
        public Integer advise;
        public Integer experience;
        public Integer categoryList_idx;
        public Agreement agreement;
        public Helper_gender helper_gender;
        public enum Agreement { agree, disagree}
        public enum Helper_gender { 남, 여, 모두 }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getEmotion() {
            return emotion;
        }

        public void setEmotion(Integer emotion) {
            this.emotion = emotion;
        }

        public Integer getAdvise() {
            return advise;
        }

        public void setAdvise(Integer advise) {
            this.advise = advise;
        }

        public Integer getExperience() {
            return experience;
        }

        public void setExperience(Integer experience) {
            this.experience = experience;
        }

//        public void setAgreement(Enum agreement) {
//            this.agreement = agreement;
//        }

        public Integer getCategoryList_idx() {
            return categoryList_idx;
        }

        public void setCategoryList_idx(Integer categoryList_idx) {
            this.categoryList_idx = categoryList_idx;
        }

//
//        public void setHelper_gender(Enum helper_gender) {
//            this.helper_gender = helper_gender;
//        }

    }


}
