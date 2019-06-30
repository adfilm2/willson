package com.example.appjam_willson;


import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class List3Activity extends AppCompatActivity {


    private RadioButton r_btn1, r_btn2, r_btn3, r_btn4 ,r_btn5;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        //라디오 버튼 설정
        //r_btn1 = (RadioButton) findViewById(R.id.r_btn1);
        //r_btn2 = (RadioButton) findViewById(R.id.r_btn2);
        //r_btn1.setOnClickListener(radioButtonClickListener);
        //r_btn2.setOnClickListener(radioButtonClickListener);

        //라디오 그룹 설정
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
    }

    //라디오 버튼 클릭 리스너
    RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(List3Activity.this, "r_btn1 : " + r_btn1.isChecked() + "r_btn2 : " + r_btn2.isChecked(), Toast.LENGTH_SHORT).show();
        }
    };

    //라디오 그룹 클릭 리스너
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if (i == R.id.rg_btn1) {
                Toast.makeText(List3Activity.this, "라디오 그룹 버튼1 눌렸습니다.", Toast.LENGTH_SHORT).show();
            } else if (i == R.id.rg_btn2) {
                Toast.makeText(List3Activity.this, "라디오 그룹 버튼2 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
