package com.example.appjam_willson.HelperSignUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.appjam_willson.R;

public class helperSignUpActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_start);

        Button nextbtn = (Button)findViewById(R.id.HelperSU_btn_next); //버튼이름 변경


    }
}

