package com.example.appjam_willson.model;

import java.util.List;

public class WorryFeelingWatchResponseModel {

    public Result result;

    /*getter and setter start*/

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    /*getter and setter end*/

    public class Result {
        int code;
        Data data;

        /*getter and setter start*/

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
    }

    public class Data {

        List<FeelingList> feelingList;

        /*getter and setter start*/

        public List<FeelingList> getFeelingList() {
            return feelingList;
        }

        public void setFeelingList(List<FeelingList> feelingList) {
            this.feelingList = feelingList;
        }

        /*getter and setter end*/
    }

    public class FeelingList {
        int feeling_idx;
        String feeling_name;

        /*getter and setter start*/

        public int getFeeling_idx() {
            return feeling_idx;
        }

        public void setFeeling_idx(int feeling_idx) {
            this.feeling_idx = feeling_idx;
        }

        public String getFeeling_name() {
            return feeling_name;
        }

        public void setFeeling_name(String feeling_name) {
            this.feeling_name = feeling_name;
        }

        /*getter and setter end*/
    }

}
