package com.example.appjam_willson.model;

public class SignupModel {

    public User user;

    /*getter and setter start*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*getter and setter end*/

    public static class User {

        String nickname;
        enum gender { 남, 여, 모두  }
        int age;
        String email;
        String password;
        String device_token;

        /*getter and setter start*/

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        /*getter and setter end*/
    }


}
