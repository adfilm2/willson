package com.example.appjam_willson.model;

public class HelperRegistModel {

    public Helper helper;
    public Helper_Exeperience experience;

    public HelperRegistModel() {
        this.helper = new Helper();
        this.experience = new Helper_Exeperience();
    }

//    public HelperRegistModel(String title,String content,String category_name,String categoryList_name, String[] experience){
//        this.helper.title= title;
//        this.helper.content = content;
//        this.helper.category_name = category_name;
//        this.helper.categoryList_name = categoryList_name;
//        this.experience.experience_name = experience;
//    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    public Helper_Exeperience getExperience() {
        return experience;
    }

    public void setExperience(Helper_Exeperience experience) {
        this.experience = experience;
    }

    public static class Helper {
        public String category_name;
        public String categoryList_name;
        public String title;
        public String content;

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
    }

    public static class Helper_Exeperience {
        public String[] experience_name;

        public String[] getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String[] experience_name) {
            this.experience_name = experience_name;
        }
    }

}