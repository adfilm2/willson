package com.example.appjam_willson.model;

import java.util.List;

public class FeelingStatusListResponseModel {

    String message;
    int code;
    Data data;

    /*getter and setter start*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /*getter and setter end*/


    public class Data {
        List<PersonalityList> personalityList;

        /*getter and setter start*/

        public List<PersonalityList> getPersonalityList() {
            return personalityList;
        }

        public void setPersonalityList(List<PersonalityList> personalityList) {
            this.personalityList = personalityList;
        }

        /*getter and setter end*/
    }

    public class PersonalityList {
        int personality_idx;
        String personality_name;

        /*getter and setter start*/

        public int getPersonality_idx() {
            return personality_idx;
        }

        public void setPersonality_idx(int personality_idx) {
            this.personality_idx = personality_idx;
        }

        public String getPersonality_name() {
            return personality_name;
        }

        public void setPersonality_name(String personality_name) {
            this.personality_name = personality_name;
        }

        /*getter and setter end*/
    }

}
