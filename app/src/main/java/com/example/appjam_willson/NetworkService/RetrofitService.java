package com.example.appjam_willson.NetworkService;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private String baseURL = "http://13.125.216.169/api/";

    private static RetrofitService ourInstance = new RetrofitService();
    public static RetrofitService getInstance() {
        if(ourInstance ==null){
            ourInstance = new RetrofitService();
        }
        return ourInstance;
    }

    private RetrofitService() {
    }
//    OkHttpClient okHttpClient = new OkHttpClient.Builder()
//            .connectTimeout(1, TimeUnit.MINUTES)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitAPI service = retrofit.create(RetrofitAPI.class);

    public RetrofitAPI getService() {
        return service;
    }

}
