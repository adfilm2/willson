package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class List1CourseStartActivity extends AppCompatActivity {

    ImageButton toolbar_backbtn;
    Button course_start_btn;
    ImageButton course_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course_start);

        context = this;

        toolbar_backbtn = (ImageButton)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        course_start_btn = (Button)findViewById(R.id.list1_course_start_btn);
        course_start_btn.setOnClickListener(new course_start_btn_listener());

        course_cancel_btn = (ImageButton)findViewById(R.id.toolbar_list_btn_cancel);
        course_cancel_btn.setOnClickListener(new course_cancel_btn_listener());
    }

    class course_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, List1CourseActivity.class);
            startActivity(intent);
        }
    }

    class course_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
