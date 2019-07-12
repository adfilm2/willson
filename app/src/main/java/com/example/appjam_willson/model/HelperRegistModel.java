package com.example.appjam_willson.model;

public class HelperRegistModel {

    public Helper_info helper;
    public Helper_Exeperience experience;

    public HelperRegistModel() {
        this.helper = new Helper_info();
        this.experience = new Helper_Exeperience();
    }

    /*getter and setter start*/

    public Helper_info getHelper() {
        return helper;
    }

    public void setHelper(Helper_info helper) {
        this.helper = helper;
    }

    public Helper_Exeperience getExperience() {
        return experience;
    }

    public void setExperience(Helper_Exeperience experience) {
        this.experience = experience;
    }

    public class Helper_info {

        public int category_idx;
        public int categoryList_idx;
        public String title;
        public String content;

        public int getCategory_idx() {
            return category_idx;
        }

        public void setCategory_idx(int category_idx) {
            this.category_idx = category_idx;
        }

        public int getCategoryList_idx() {
            return categoryList_idx;
        }

        public void setCategoryList_idx(int categoryList_idx) {
            this.categoryList_idx = categoryList_idx;
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
    }

    public static class Helper_Exeperience {
        public String[] experience_name;

        public String[] getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String[] experience_name) {
            this.experience_name = experience_name;
        }

        /*getter and setter end*/

    }

}