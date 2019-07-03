package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1DailyStartActivity extends AppCompatActivity {

    LinearLayout toolbar_backbtn;
    Button daily_start_btn;
    LinearLayout daily_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_daily_start);

        context = this;

        toolbar_backbtn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        daily_start_btn = (Button)findViewById(R.id.list1_daily_start_btn);
        daily_start_btn.setOnClickListener(new daily_start_btn_listener());

        daily_cancel_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_cancel);
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
