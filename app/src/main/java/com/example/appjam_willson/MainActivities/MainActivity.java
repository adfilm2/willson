package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.AcceptHelperListWatchResponseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int question_idx;

    static ImageView image_home;
    static ImageView image_request;
    static ImageView image_chat;
    static ImageView image_mypage;

    static TextView text_home;
    static TextView text_request;
    static TextView text_chat;
    static TextView text_mypage;
    static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();

        final LinearLayout button1 = findViewById(R.id.layout_home);
        final LinearLayout button2 = findViewById(R.id.layout_request);
        final LinearLayout button3 = findViewById(R.id.layout_chat);
        final LinearLayout button4 = findViewById(R.id.layout_mypage);

        final ImageView image_home = findViewById(R.id.Image_home);
        final ImageView image_request = findViewById(R.id.Image_request);
        final ImageView image_chat = findViewById(R.id.Image_chat);
        final ImageView image_mypage = findViewById(R.id.Image_mypage);

        TextView text_home = findViewById(R.id.text_home);
        TextView text_request = findViewById(R.id.text_request);
        TextView text_chat = findViewById(R.id.text_chat);
        TextView text_mypage = findViewById(R.id.text_mypage);


//
//        String complete = intent.getExtras().getString("complete");
//        if (complete =="OK"){
//            changeImage(image_request, image_home, image_mypage, image_chat);
//            changeTextColor(text_request, text_home, text_chat, text_mypage);
//            checkMatch();
//        }
//
//

        //MainFragment1을 자동으로 띄워줌
        startMainView();
        changeImage(image_home, image_chat, image_mypage, image_request);
        changeTextColor(text_home, text_request, text_chat, text_mypage);

        // passPushTokenToServer();

        Timestamp testTimes = new Timestamp(System.currentTimeMillis());
        if(ApplicationFields.timerStart != 0){

        }
        ApplicationFields.timerStart = testTimes.getTime();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(image_home, image_chat, image_mypage, image_request);
                changeTextColor(text_home, text_request, text_chat, text_mypage);
                MainFragment fragment = new MainFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(image_request, image_home, image_mypage, image_chat);
                changeTextColor(text_request, text_home, text_chat, text_mypage);
                checkMatch();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(image_chat, image_home, image_mypage, image_request);
                changeTextColor(text_chat, text_home, text_request, text_mypage);

                MainFragment3 fragment = new MainFragment3();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();



            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(image_mypage, image_home, image_chat, image_request);
                changeTextColor(text_mypage, text_home, text_chat, text_request);
                MainFragment4 fragment = new MainFragment4();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();

            }
        });
    }





    void passPushTokenToServer() {
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.w("getInstanceId failed", task.getException());
                    return;
                }
                String token = task.getResult().getToken();
                Map<String, Object> map = new HashMap<>();
                map.put("pushToken", token);
                FirebaseDatabase.getInstance().getReference().child("users").child(uid).updateChildren(map);
            }
        });
    }

    private static void changeImage(ImageView first, ImageView second, ImageView third, ImageView fourth) {
        first.setSelected(true);
        second.setSelected(false);
        third.setSelected(false);
        fourth.setSelected(false);
    }

    public static void changeTextColor(TextView first, TextView second, TextView third, TextView fourth) {
        first.setTextColor(Color.parseColor("#2f2f2f"));
        second.setTextColor(Color.parseColor("#9e9e9e"));
        third.setTextColor(Color.parseColor("#9e9e9e"));
        fourth.setTextColor(Color.parseColor("#9e9e9e"));
    }


    private void startMainView() {

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
    }

    public void checkMatch() {

        Call<AcceptHelperListWatchResponseModel> accept_helper = RetrofitService.getInstance().getService().get_accept_helper(question_idx);
        //여기 윗줄에 question_idx값 안넣어줌
        accept_helper.enqueue(retrofitCallback);

    }

    private Callback<AcceptHelperListWatchResponseModel> retrofitCallback = new Callback<AcceptHelperListWatchResponseModel>() {

        @Override
        public void onResponse(Call<AcceptHelperListWatchResponseModel> call, Response<AcceptHelperListWatchResponseModel> response) {
            AcceptHelperListWatchResponseModel result = response.body();

            if (result.getCode() == 1000) {
                MainFragment2 fragment = new MainFragment2();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            } else {
                MainFragment2_null fragment = new MainFragment2_null();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            }
        }

        @Override
        public void onFailure(Call<AcceptHelperListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };
}

