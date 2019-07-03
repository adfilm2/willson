package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1LoveStartActivity extends AppCompatActivity {

    LinearLayout toolbar_backbtn;
    Button love_start_btn;
    LinearLayout love_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_love_start);

        context = this;

        toolbar_backbtn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        love_start_btn = (Button)findViewById(R.id.list1_love_start_btn);
        love_start_btn.setOnClickListener(new love_start_btn_listener());

        love_cancel_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_cancel);
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