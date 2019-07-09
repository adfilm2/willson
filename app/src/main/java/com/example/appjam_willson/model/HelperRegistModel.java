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

<<<<<<< HEAD
    public static class Helper {
=======
    /*getter and setter end*/

    public class Helper_info {

>>>>>>> da47e518fd0974a34744f7ebf3ffea2e4595af5f
        public String category_name;
        public String categoryList_name;
        public String title;
        public String content;

<<<<<<< HEAD
=======
        /*getter and setter start*/

>>>>>>> da47e518fd0974a34744f7ebf3ffea2e4595af5f
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
<<<<<<< HEAD
    }

    public static class Helper_Exeperience {
        public String[] experience_name;

=======

        /*getter and setter end*/

    }

    public class Helper_Exeperience {

        public String[] experience_name;

        /*getter and setter start*/

>>>>>>> da47e518fd0974a34744f7ebf3ffea2e4595af5f
        public String[] getExperience_name() {
            return experience_name;
        }

        public void setExperience_name(String[] experience_name) {
            this.experience_name = experience_name;
        }
<<<<<<< HEAD
    }

}
=======

        /*getter and setter end*/

    }

}
>>>>>>> da47e518fd0974a34744f7ebf3ffea2e4595af5f
