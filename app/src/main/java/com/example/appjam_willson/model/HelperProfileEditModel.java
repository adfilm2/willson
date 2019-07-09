package com.example.appjam_willson.model;

public class HelperProfileEditModel {

    Helper_edit helper;
    Experience_edit experience;

    /*getter and setter start*/

    public Helper_edit getHelper() {
        return helper;
    }

    public void setHelper(Helper_edit helper) {
        this.helper = helper;
    }

    public Experience_edit getExperience() {
        return experience;
    }

    public void setExperience(Experience_edit experience) {
        this.experience = experience;
    }

    /*getter and setter end*/

    public class Helper_edit {
        String category_name;
        String categoryList_name;
        String title;
        String content;

        /*getter and setter start*/

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategoryList_name() {
            return categoryList_name;
        }

        public void setCategoryList_name(String categoryList_name) {
            this.categoryList_name = categoryList_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        /*getter and setter end*/

    }

    public class Experience_edit {
        String[] experience_name;

        /*getter and setter start*/

        public String[] getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String[] experience_name) {
            this.experience_name = experience_name;
        }

        /*getter and setter end*/
    }


}
