package com.example.appjam_willson.model;

import java.util.List;

public class WorryCategoryResponseModel {

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
        List<CategoryList> categoryList;

        /*getter and setter start*/

        public List<CategoryList> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<CategoryList> categoryList) {
            this.categoryList = categoryList;
        }

        /*getter and setter end*/
    }

    public class CategoryList {
        int categoryList_id;
        String categoryList_name;

        /*getter and setter start*/

        public int getCategoryList_id() {
            return categoryList_id;
        }

        public void setCategoryList_id(int categoryList_id) {
            this.categoryList_id = categoryList_id;
        }

        public String getCategoryList_name() {
            return categoryList_name;
        }

        public void setCategoryList_name(String categoryList_name) {
            this.categoryList_name = categoryList_name;
        }

        /*getter and setter end*/
    }

}
