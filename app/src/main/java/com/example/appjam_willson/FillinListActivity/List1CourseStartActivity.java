package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.CreateWorryModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List1CourseStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout toolbar_backbtn;
    Button course_start_btn;
    LinearLayout course_cancel_btn;
    Context context;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course_start);

        context = this;

        REQUEST_CODE = ((List1CourseStartActivity) context).getTaskId();

        toolbar_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        course_start_btn = findViewById(R.id.list1_course_start_btn);
        course_start_btn.setOnClickListener(new course_start_btn_listener());

        course_cancel_btn = findViewById(R.id.toolbar_list_btn_cancel);
        course_cancel_btn.setOnClickListener(new course_cancel_btn_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle = data.getExtras();
                    bundle.putInt("category_idx",2);
                    data.putExtras(bundle);
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
