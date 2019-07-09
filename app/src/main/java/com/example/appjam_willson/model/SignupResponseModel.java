package com.example.appjam_willson.model;

public class SignupResponseModel {

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
        Signup_Body body;

        /*getter and setter start*/

        public Signup_Body getBody() {
            return body;
        }

        public void setBody(Signup_Body body) {
            this.body = body;
        }

        /*getter and setter end*/
    }

    public class Signup_Body {
        String nickname;
        String gender;
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

        /*getter and setter end*/
    }


}
