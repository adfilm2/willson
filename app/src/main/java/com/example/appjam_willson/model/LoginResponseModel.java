package com.example.appjam_willson.model;

public class LoginResponseModel {

    public int code;
    public String message;
    public Data data;

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
        public String Token;
        public user_Info userInfo;

        public user_Info getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(user_Info userInfo) {
            this.userInfo = userInfo;
        }
        /*getter and setter start*/

        public String getToken() {
            return Token;
        }

        public void setToken(String token) {
            Token = token;
        }
        /*getter and setter end*/

        public class user_Info{
            public String user_idx;
            public String nickname;
            public String gender;
            public int age;
            public String uid;

            public String getUser_idx() {
                return user_idx;
            }

            public void setUser_idx(String user_idx) {
                this.user_idx = user_idx;
            }

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getDevice_token() {
                return device_token;
            }

            public void setDevice_token(String device_token) {
                this.device_token = device_token;
            }

            public String device_token;
        }

    }

}
