package com.example.appjam_willson.ApplicationField;

import android.app.Application;

public class ApplicationFields extends Application {

    public static String userToken = "";
    public static long timerStart = 0;
    public static long fiveMin = 300000;

    @Override
    public void onCreate(){
        super.onCreate();
    }
}
