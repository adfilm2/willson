package com.example.appjam_willson.model;

public class WorryCategoryListAddResponseModel {

   public String message;
   public int code;
   public Data data;

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }

   public class Data {
      public int categoryList_idx;
   }
}
