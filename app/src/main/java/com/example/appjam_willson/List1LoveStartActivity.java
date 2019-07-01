package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class List1LoveStartActivity extends AppCompatActivity {

    ImageButton toolbar_backbtn;
    Button love_start_btn;
    ImageButton love_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_love_start);

        context = this;

        toolbar_backbtn = (ImageButton)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        love_start_btn = (Button)findViewById(R.id.list1_love_start_btn);
        love_start_btn.setOnClickListener(new love_start_btn_listener());

        love_cancel_btn = (ImageButton)findViewById(R.id.toolbar_list_btn_cancel);
        love_cancel_btn.setOnClickListener(new love_cancel_btn_listener());
    }

    class love_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1LoveActivity.class);
            startActivity(intent);
        }
    }

    class love_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
