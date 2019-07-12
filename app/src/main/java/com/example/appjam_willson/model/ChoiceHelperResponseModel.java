package com.example.appjam_willson.model;

public class ChoiceHelperResponseModel {
    String message;
    int code;
    Data data;


    ////////////////////////////////////////////

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

    //////////////////////////////

    public class Data {
        int matching_idx;

        ////////////////////////////////////////////////////////

        public int getMatching_idx() {
            return matching_idx;
        }

        public void setMatching_idx(int matching_idx) {
            this.matching_idx = matching_idx;
        }


        ////////////////////////////////////////////////////////
    }



}
