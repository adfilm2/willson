package com.example.appjam_willson.model;

import java.util.List;

public class UserProfileWatchResponseModel {

    int code;
    String message;
    Data data;

    /*getter and setter start*/

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /*getter and setter end*/

    public class Data {
        public User user;
        public List<Personality> user_personality;
        public Question question;

        /*getter and setter start*/

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Personality> getUser_personality() {
            return user_personality;
        }

        public void setUser_personality(List<Personality> user_personality) {
            this.user_personality = user_personality;
        }

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }
        /*getter and setter end*/
    }

    public class User {
        public String nickname;
        public String gender;
        public String age;

        /*getter and setter start*/

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        /*getter and setter end*/
    }

    public class Personality {
        public String personality_name;

        /*getter and setter start*/

        public String getPersonality_name() {
            return personality_name;
        }

        public void setPersonality_name(String personality_name) {
            this.personality_name = personality_name;
        }

        /*getter and setter end*/
    }

    public class Question {
        public String category_name;
        public int weight;
        public String content;
        public String helper_gender;
        public int advise;
        public int experience;
        public List<Personality> question_personality;
        public List<Feeling> question_feeling;
        public List<Experience> question_experience;

        /*getter and setter start*/

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHelper_gender() {
            return helper_gender;
        }

        public void setHelper_gender(String helper_gender) {
            this.helper_gender = helper_gender;
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

        public List<Personality> getQuestion_personality() {
            return question_personality;
        }

        public void setQuestion_personality(List<Personality> question_personality) {
            this.question_personality = question_personality;
        }

        public List<Feeling> getQuestion_feeling() {
            return question_feeling;
        }

        public void setQuestion_feeling(List<Feeling> question_feeling) {
            this.question_feeling = question_feeling;
        }

        public List<Experience> getQuestion_experience() {
            return question_experience;
        }

        public void setQuestion_experience(List<Experience> question_experience) {
            this.question_experience = question_experience;
        }

        /*getter and setter end*/
    }

    public class Feeling {
        public String feeling_name;

        /*getter and setter start*/

        public String getFeeling_name() {
            return feeling_name;
        }

        public void setFeeling_name(String feeling_name) {
            this.feeling_name = feeling_name;
        }

        /*getter and setter end*/
    }

    public class Experience {
        public String experience_name;

        /*getter and setter start*/

        public String getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String experience_name) {
            this.experience_name = experience_name;
        }

        /*getter and setter end*/
    }


}
