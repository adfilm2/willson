package com.example.appjam_willson.MainActivities;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.appjam_willson.R;

public class MainFragment2_loading extends Fragment {


    private static final int MILLISINFUTURE = 301*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 300;
    private TextView countTxt ;
    private CountDownTimer countDownTimer;
    private TextView min, sec;

    ImageView loading;



    public MainFragment2_loading(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_find_helper_loading,null);

        //타이머
        countTxt = view.findViewById(R.id.count_txt);
        min = view.findViewById(R.id.min_txt);
        countDownTimer();
        countDownTimer.start();

        loading = view.findViewById(R.id.loading_moving_willson);

        Glide.with(this).load(R.drawable.request_searching_wilson).into(loading);


            return view;
    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                int mins = count/60;
                min.setText(String.format("%02d",mins));
                countTxt.setText(String.format("%02d",count-(mins*60)));
                count --;
            }
            public void onFinish() {
                countTxt.setText("Finish .");
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }
}

