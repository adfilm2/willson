package com.example.appjam_willson.model;

import android.support.v4.app.INotificationSideChannel;

public class CreateWorryModel {
    private Question quesition;
    private Integer[] feeling;
    private Integer[] personality;
    private Integer[] experience;

    public class Question{
        String weight;
        String content;
        Integer emotion;
        Integer advise;
        Integer experience;
        Enum agreement;
        Integer categoryList_idx;
        Enum helper_gender;

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
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

        public Enum getAgreement() {
            return agreement;
        }

        public void setAgreement(Enum agreement) {
            this.agreement = agreement;
        }

        public Integer getCategoryList_idx() {
            return categoryList_idx;
        }

        public void setCategoryList_idx(Integer categoryList_idx) {
            this.categoryList_idx = categoryList_idx;
        }

        public Enum getHelper_gender() {
            return helper_gender;
        }

        public void setHelper_gender(Enum helper_gender) {
            this.helper_gender = helper_gender;
        }

    }


}
