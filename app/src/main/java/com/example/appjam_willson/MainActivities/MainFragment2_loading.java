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
import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.AcceptHelperListWatchResponseModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment2_loading extends Fragment {


    private static final int COUNT_DOWN_INTERVAL = 300;

    private SimpleDateFormat timerFormat = new SimpleDateFormat("m:ss");
    private TextView countTxt ;
    private CountDownTimer countDownTimer;

    ImageView loading;



    public MainFragment2_loading(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_find_helper_loading,null);

        //타이머
        countTxt = view.findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();

        loading = view.findViewById(R.id.loading_moving_willson);

        Glide.with(this).load(R.drawable.request_searching_wilson).into(loading);

        return view;
    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(ApplicationFields.fiveMin, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {

                ApplicationFields.timerSwitch = true;
                Date date = new Date(millisUntilFinished);
                String restTime = timerFormat.format(date);
                countTxt.setText(restTime);
            }
            public void onFinish() {
                ApplicationFields.timerSwitch = false;
                countTxt.setText("완료 !");
                ApplicationFields.fiveMin = 300000;

                int question_idx = 1;
                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6zshLEiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3OTk0ODcsImV4cCI6MTU3MTQzOTQ4NywiaXNzIjoid2lsbHNvbiJ9.l2Slk87lEK8Ne_SUMiiIfsXVSuUDfa5VWaeyE3PmZIs";
                Call<AcceptHelperListWatchResponseModel> accept_helper = RetrofitService.getInstance().getService().get_accept_helper(token, question_idx);
                accept_helper.enqueue(retrofitCallback);
            }
        };
    }

    private Callback<AcceptHelperListWatchResponseModel> retrofitCallback = new Callback<AcceptHelperListWatchResponseModel>() {

        @Override
        public void onResponse(Call<AcceptHelperListWatchResponseModel> call, Response<AcceptHelperListWatchResponseModel> response) {
            AcceptHelperListWatchResponseModel result = response.body();

            if (result.getCode() == 1000 && result.getData().getHelper() != null) {
                MainFragment2 fragment = new MainFragment2();
                getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            }

            else {
                MainFragment2_null fragment = new MainFragment2_null();
                getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            }
        }

        @Override
        public void onFailure(Call<AcceptHelperListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };



//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        countDownTimer.cancel();   //카운트다운 쓰레드 종료
//        databaseReference.removeEventListener(valueEventListener);
//        finish();
//    }
}

