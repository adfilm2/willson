package com.example.appjam_willson.HelperProfileEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appjam_willson.R;

public class HelperProfileEditActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_start);


        Button button1 = (Button) findViewById(R.id.h_edit_btn1);
        Button button2 = (Button) findViewById(R.id.h_edit_btn2);
        Button button3 = (Button) findViewById(R.id.h_edit_btn3); //helperSU_btn_life helperSU_btn_etc
        Button button4 = (Button) findViewById(R.id.h_edit_btn4);


        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityStart.this, HelperProfileEditActivityC1.class);
                startActivity(intentProfileEdit);


            }


        });

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityStart.this, HelperProfileEditActivityExp.class);
                startActivity(intentProfileEdit);


            }


        });
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityStart.this, HelperProfileEditActivityHash.class);
                startActivity(intentProfileEdit);


            }


        });
        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityStart.this, HelperProfileEditActivityIntro.class);
                startActivity(intentProfileEdit);


            }


        });


    }



}
