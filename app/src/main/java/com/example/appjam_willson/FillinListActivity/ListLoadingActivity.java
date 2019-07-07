package com.example.appjam_willson.FillinListActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.appjam_willson.R;

public class ListLoadingActivity extends AppCompatActivity {

    private static final int MILLISINFUTURE = 301*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 300;
    private TextView countTxt ;
    private CountDownTimer countDownTimer;
    private TextView min, sec;

    ImageView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_helper_loading);

        //로딩이미지
/*        ImageView loading = (ImageView)findViewById(R.id.);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.rotate);
        loading.startAnimation(animation1);*/

        //타이머
        countTxt = (TextView)findViewById(R.id.count_txt);
        min = (TextView)findViewById(R.id.min_txt);
        countDownTimer();
        countDownTimer.start();

        loading = (ImageView)findViewById(R.id.loading_moving_willson);

        Glide.with(this).load(R.drawable.request_searching_wilson).into(loading);

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
                countTxt.setText(String.valueOf("Finish ."));
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
