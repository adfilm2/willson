package com.example.appjam_willson.NetworkService;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private String baseURL = "http://13.125.216.169/api/";

    private static RetrofitService ourInstance = new RetrofitService();
    public static RetrofitService getInstance() {
        return ourInstance;
    }

    private RetrofitService() {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitAPI service = retrofit.create(RetrofitAPI.class);

    public RetrofitAPI getService() {
        return service;
    }

}
