package com.example.appjam_willson.ApplicationField;

import android.app.Application;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class ApplicationFields extends Application {

    //유저 데이터 관련
    public static String userToken ;
    public static String uid;
    public static String user_id;
    public static String user_nickname;
    public static String device_token;

    //타이머 관련
    public static long timerStart;
    public static boolean timerSwitch = false;
    public static boolean matchingStack = false;

    public static int myHelper_idx = 0;
    public static int myQuestion_idx = 0;

    //mainfragment2_null 탭바 색
    public static ImageView home;
    public static ImageView request;
    public static TextView hometxt;
    public static TextView requesttxt;


    @Override
    public void onCreate(){
        super.onCreate();
    }
}
