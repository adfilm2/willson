package com.example.appjam_willson.HelperProfileEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.appjam_willson.R;

public class HelperProfileEditActivityHash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_hash);


        Button nextbtn = (Button) findViewById(R.id.button1);


        ImageView btn_back;
        btn_back = (ImageView)findViewById(R.id.h_pro_btn_backbtn);
        btn_back.setOnClickListener(new HelperProfileEditActivityHash.list1_love_backbtn_listener());

        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityHash.this, HelperProfileEditActivityStart.class);
                startActivity(intentProfileEdit);


            }


        });
    }


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }



}
