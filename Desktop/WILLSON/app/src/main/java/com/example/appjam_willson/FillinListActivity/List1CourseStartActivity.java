package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1CourseStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout toolbar_backbtn;
    Button course_start_btn;
    LinearLayout course_cancel_btn;
    Context context;
    Bundle bundle_course = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course_start);

        context = this;

        REQUEST_CODE = ((List1CourseStartActivity) context).getTaskId();

        toolbar_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        course_start_btn = (Button)findViewById(R.id.list1_course_start_btn);
        course_start_btn.setOnClickListener(new course_start_btn_listener());

        course_cancel_btn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        course_cancel_btn.setOnClickListener(new course_cancel_btn_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle_course = data.getExtras();
                    bundle_course.putInt("category",2);
                    data.putExtras(bundle_course);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class course_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, List1CourseActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class course_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
