package com.example.appjam_willson.model;

public class UserQuestionCreateModel {

    public Question question;
    public int[] feeling;
    //int feeling_idx
    public int[] personality;
    //int personality_idx
    public int[] experience;
    //int experience_idx

    /*getter and setter start*/

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int[] getFeeling() {
        return feeling;
    }

    public void setFeeling(int[] feeling) {
        this.feeling = feeling;
    }

    public int[] getPersonality() {
        return personality;
    }

    public void setPersonality(int[] personality) {
        this.personality = personality;
    }

    public int[] getExperience() {
        return experience;
    }

    public void setExperience(int[] experience) {
        this.experience = experience;
    }

    /*getter and setter end*/

    public static class Question {
        String weight;
        String content;
        int emotion;
        int advise;
        int experience;
        enum agreement {
            agree, disagree
        }
        int categoryList_idx;
        enum helper_gender {
            남, 여, 모두
        }

        /*getter and setter start*/

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

        public int getEmotion() {
            return emotion;
        }

        public void setEmotion(int emotion) {
            this.emotion = emotion;
        }

        public int getAdvise() {
            return advise;
        }

        public void setAdvise(int advise) {
            this.advise = advise;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public int getCategoryList_idx() {
            return categoryList_idx;
        }

        public void setCategoryList_idx(int categoryList_idx) {
            this.categoryList_idx = categoryList_idx;
        }

        /*getter and setter end*/
    }

}
