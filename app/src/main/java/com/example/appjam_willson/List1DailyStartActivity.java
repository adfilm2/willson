package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class List1DailyStartActivity extends AppCompatActivity {

    ImageButton toolbar_backbtn;
    Button daily_start_btn;
    ImageButton daily_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_daily_start);

        context = this;

        toolbar_backbtn = (ImageButton)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        daily_start_btn = (Button)findViewById(R.id.list1_daily_start_btn);
        daily_start_btn.setOnClickListener(new daily_start_btn_listener());

        daily_cancel_btn = (ImageButton)findViewById(R.id.toolbar_list_btn_cancel);
        daily_cancel_btn.setOnClickListener(new daily_cancel_btn_listener());
    }

    class daily_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1DailyActivity.class);
            startActivity(intent);
        }
    }

    class daily_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
