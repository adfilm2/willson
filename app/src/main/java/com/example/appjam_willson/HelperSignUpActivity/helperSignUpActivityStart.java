package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityC1;
import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityC2;
import com.example.appjam_willson.R;

public class helperSignUpActivityStart extends AppCompatActivity {

    View view;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_start);

        back = (ImageView)findViewById(R.id.back_btn);
        back.setVisibility(View.INVISIBLE);


        Button nextbtn = (Button)findViewById(R.id.HelperSU_btn_next); //버튼이름 변경

        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(helperSignUpActivityStart.this, HelperSignUpActivity0.class);
                startActivity(intentProfileEdit);


            }


        });

    }
}

