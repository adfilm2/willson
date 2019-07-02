package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class List1EtcStartActivity extends AppCompatActivity {

    LinearLayout toolbar_backbtn;
    Button etc_start_btn;
    LinearLayout etc_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_etc_start);

        context = this;

        toolbar_backbtn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        etc_start_btn = (Button)findViewById(R.id.list1_etc_start_btn);
        etc_start_btn.setOnClickListener(new etc_start_btn_listener());

        etc_cancel_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_cancel);
        etc_cancel_btn.setOnClickListener(new etc_cancel_btn_listener());
    }

    class etc_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1EtcActivity.class);
            startActivity(intent);
        }
    }

    class etc_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
