package com.example.appjam_willson.HelperSignUpActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class helperSignUpActivityStart extends AppCompatActivity {

    View view;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_start);

        view = (View)findViewById(R.id.signupstart);
        back = (ImageView)findViewById(R.id.back_btn);
        back.setVisibility(View.INVISIBLE);


        Button nextbtn = (Button)findViewById(R.id.HelperSU_btn_next); //버튼이름 변경


    }
}

