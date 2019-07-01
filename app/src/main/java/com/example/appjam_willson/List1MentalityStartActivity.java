package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class List1MentalityStartActivity extends AppCompatActivity {

    ImageButton toolbar_backbtn;
    Button mentality_start_btn;
    ImageButton mentality_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_mentality_start);

        context = this;

        toolbar_backbtn = (ImageButton)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        mentality_start_btn = (Button)findViewById(R.id.list1_mentality_start_btn);
        mentality_start_btn.setOnClickListener(new mentality_start_btn_listener());

        mentality_cancel_btn = (ImageButton)findViewById(R.id.toolbar_list_btn_cancel);
        mentality_cancel_btn.setOnClickListener(new mentality_cancel_btn_listener());
    }

    class mentality_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1MentalityActivity.class);
            startActivity(intent);
        }
    }

    class mentality_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
