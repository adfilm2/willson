package com.example.appjam_willson.model;

public class SignupModel {

        public String nickname;
        public String gender;
//        public Gender gender;
        public int age;
        public String email;
        public String password;
        public String device_token;
        public String uid;
        public int[] personality_idx;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public int[] getPersonality() {
        return personality_idx;
    }

    public void setPersonality(int[] personality) {
        this.personality_idx = personality;
    }
}
