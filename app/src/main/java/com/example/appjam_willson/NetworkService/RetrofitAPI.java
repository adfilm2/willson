package com.example.appjam_willson.NetworkService;

import com.example.appjam_willson.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("api/users/{a}")
    Call<DataModel> getUser(@Path("a") int data);


}
