package com.example.appjam_willson.model;

public class LoginModel {

    public User user;

    /*getter and setter start*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*getter and setter end*/

    public class User {
        String email;
        String password;

        /*getter and setter start*/

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

        /*getter and setter end*/
    }


}
