package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityC1;
import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityC2;
import com.example.appjam_willson.R;

public class helperSignUpActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_start);
        Button nextbtn = (Button) findViewById(R.id.h_su_start_btn);

        //Button nextbtn = (Button)findViewById(R.id.list1_course_start_btn); //버튼이름 변경


        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(helperSignUpActivityStart.this, HelperSignUpActivity0.class);
                startActivity(intentProfileEdit);


            }


        });

    }
}

