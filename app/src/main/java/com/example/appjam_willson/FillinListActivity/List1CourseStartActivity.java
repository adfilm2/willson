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
    Bundle bundle_course = new Bundle();

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
                    bundle_course = data.getExtras();
                    bundle_course.putInt("category",2);

                    CreateWorryModel createWorryModel = new CreateWorryModel();
                    createWorryModel.question.weight = data.getIntExtra("importance",0);
                    createWorryModel.question.content = data.getStringExtra("contents");
                    createWorryModel.question.emotion = data.getIntExtra("empathy",0);
                    createWorryModel.question.advise = data.getIntExtra("advice",0);
                    createWorryModel.question.experience = data.getIntExtra("experience",0);
                    createWorryModel.question.agreement = CreateWorryModel.Question.Agreement.agree;
                    //categoryList_idx
                    createWorryModel.feeling = data.getIntArrayExtra("feeling");


                    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";
                    Call<WorryCategoryListAddResponseModel> call_helper = RetrofitService.getInstance().getService().create_model_post(token, createWorryModel);
                    call_helper.enqueue(new Callback<WorryCategoryListAddResponseModel>() {
                        @Override
                        public void onResponse(Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
                            Log.d("test", response.isSuccessful() + "");
                            WorryCategoryListAddResponseModel result = response.body();
                            Log.d("dlfkdlfjkdl", ">>>>>>>>>>>" + response.code());
                            Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.code);

                        }

                        @Override
                        public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                            t.printStackTrace();
                            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                        }
                    });






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
