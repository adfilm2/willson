package com.example.appjam_willson.NetworkService;

import com.example.appjam_willson.model.DataModel;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseActivity;
import com.example.appjam_willson.model.HelperStoryModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("users/{a}")
    Call<DataModel> getUser(@Path("a") int data);

    @GET("helper/story")
    Call<HelperStoryModel> helper_story_get(@Header("willson-token") String token);

    @POST("helper/registration")
    Call<HelperRegistResponseActivity> helper_regist_post(@Header("willson-token") String token, @Body HelperRegistModel helperRegistModel);

}