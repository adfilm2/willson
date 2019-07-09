package com.example.appjam_willson.NetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;


    public void makeRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://13.125.216.169/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }
}
