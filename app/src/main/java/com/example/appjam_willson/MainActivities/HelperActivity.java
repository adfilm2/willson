package com.example.appjam_willson.MainActivities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HelperActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        LinearLayout button1=findViewById(R.id.willsonLayout_receive);
        LinearLayout button2=findViewById(R.id.willsonLayout_chat);
        LinearLayout button3=findViewById(R.id.willsonLayout_profile);
        LinearLayout button4=findViewById(R.id.willsonLayout_mypage);


        final ImageView willsonImage_receive=findViewById(R.id.willsonImage_receive);
        final ImageView willsonImage_chat=findViewById(R.id.willsonImage_chat);
        final ImageView willsonImage_profile=findViewById(R.id.willsonImage_profile);
        final ImageView willsonImage_mypage=findViewById(R.id.willsonImage_mypage);

        final TextView willsonText_receive=findViewById(R.id.willsonText_receive);
        final TextView willsonText_chat=findViewById(R.id.willsonText_chat);
        final TextView willsonText_profile=findViewById(R.id.willsonText_profile);
        final TextView willsonText_mypage=findViewById(R.id.willsonText_mypage);

//        passPushTokenToServer();

        checkMatch();
        changeImage(willsonImage_receive,willsonImage_chat,willsonImage_profile,willsonImage_mypage);
        changeTextColor(willsonText_receive,willsonText_chat,willsonText_profile,willsonText_mypage);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(willsonImage_receive,willsonImage_chat,willsonImage_profile,willsonImage_mypage);
                changeTextColor(willsonText_receive,willsonText_chat,willsonText_profile,willsonText_mypage);

                checkMatch();
                HelperFragment fragment = new HelperFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(willsonImage_chat,willsonImage_receive,willsonImage_profile,willsonImage_mypage);
                changeTextColor(willsonText_chat,willsonText_receive,willsonText_profile,willsonText_mypage);

                HelperFragment2 fragment = new HelperFragment2();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(willsonImage_profile,willsonImage_chat,willsonImage_receive,willsonImage_mypage);
                changeTextColor(willsonText_profile,willsonText_chat,willsonText_receive,willsonText_mypage);

                HelperFragment3 fragment = new HelperFragment3();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(willsonImage_mypage,willsonImage_chat,willsonImage_profile,willsonImage_receive);
                changeTextColor(willsonText_mypage,willsonText_chat,willsonText_profile,willsonText_receive);

                HelperFragment4 fragment = new HelperFragment4();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
    }

    void passPushTokenToServer(){
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.w( "getInstanceId failed", task.getException());
                    return;
                }

                String token = task.getResult().getToken();

                Map<String,Object> map = new HashMap<>();
                map.put("pushToken",token);
                FirebaseDatabase.getInstance().getReference().child("users").child(uid).updateChildren(map);
            }
        });
    }

    private void changeImage(ImageView first,ImageView second,ImageView third,ImageView fourth) {
        first.setSelected(true);
        second.setSelected(false);
        third.setSelected(false);
        fourth.setSelected(false);
    }

    private void changeTextColor(TextView first,TextView second, TextView third, TextView fourth) {
        first.setTextColor(Color.parseColor("#2f2f2f"));
        second.setTextColor(Color.parseColor("#9e9e9e"));
        third.setTextColor(Color.parseColor("#9e9e9e"));
        fourth.setTextColor(Color.parseColor("#9e9e9e"));
    }


    public void checkMatch() {

        /*int question_idx = 100*/;

      String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTksIm5pY2tuYW1lIjoi7J2066aE7J2066aEIiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyODU3MDU3LCJleHAiOjE1NzE0OTcwNTcsImlzcyI6IndpbGxzb24ifQ.j8sNiLFIXRsZ-CZORN6zuG9IZAS8rQ7m_i0FyRr6LQY";


        Call<HelperReceivedWorryListWatchResponseModel> call_worryList = RetrofitService.getInstance().getService().helper_receiveList_get(token);
        call_worryList.enqueue(retrofitCallback);

    }

    private Callback<HelperReceivedWorryListWatchResponseModel> retrofitCallback = new Callback<HelperReceivedWorryListWatchResponseModel>() {

        @Override
        public void onResponse(Call<HelperReceivedWorryListWatchResponseModel> call, Response<HelperReceivedWorryListWatchResponseModel> response) {
            HelperReceivedWorryListWatchResponseModel result = response.body();

            Log.d("성공ㅇㅇㅇㅇㅇㅇㅇㅇㅇHelperActivity", String.valueOf(result.getCode()));
            Log.d("ㅇㅇㅇHelperActivity상태값", result.getData().getConcernInfo().get(0).getQuestionInfo().getSelected());
            Log.d("메시지ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ", result.getMessage());
//            Log.d("유저 닉네임", result.getData().getConcernInfo().get(0).getUserInfo().getNickname());

            Log.d("sizesizesizesizesize", String.valueOf(result.getData().getSize()));

            if (result.getCode() == 800 && result.getData().getSize() != 0) {
                /*adapter_send = result.getData().getConcernInfo();*/
               /* helperFragment1Adapter = new HelperFragment1Adapter(adapter_send, getActivity());
                helper_fragment1_recyclerView.setAdapter(helperFragment1Adapter);*/
                HelperFragment fragment = new HelperFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();

            }
            else if(result.getData().getSize() == 0){
                HelperFragment1_null fragment = new HelperFragment1_null();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
           /* Log.d("리ㅣㅣㅣㅣ", String.valueOf(result.getData().getSize()));
            Log.d("삽질ㄹㄹㄹㄹㄹㄹ", String.valueOf(result.getData().getConcernInfo().get(1).getUserInfo()));
       */
        }

        @Override
        public void onFailure(Call<HelperReceivedWorryListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실패ㅐㅐㅐㅐㅐ","대실패");
        }
    };

  /*  public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();
    }*/


}

