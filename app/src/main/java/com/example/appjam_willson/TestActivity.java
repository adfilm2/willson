package com.example.appjam_willson;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperResgistResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {

    Button btn;

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;

    HelperRegistModel helperRegistModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn=findViewById(R.id.button);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://13.125.216.169/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);

        String[] str = {"긍정적인", "친절한", "활발한"};

        helperRegistModel = new HelperRegistModel();

        helperRegistModel.helper.title = "test";
        helperRegistModel.helper.category_name = "진로";
        helperRegistModel.helper.categoryList_name= "dkansjk";
        helperRegistModel.helper.content = "sdf";

        helperRegistModel.experience.experience_name = str;
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";
        Call<HelperResgistResponseModel> call_helper = retrofitAPI.helper_regist_post(token, helperRegistModel);
        call_helper.enqueue(retrofitCallback);

    }

    private Callback<HelperResgistResponseModel> retrofitCallback = new Callback<HelperResgistResponseModel>() {

        @Override
        public void onResponse(Call<HelperResgistResponseModel> call, Response<HelperResgistResponseModel> response) {
            HelperResgistResponseModel result = response.body();
            Log.d(".>>>>>>>>>",""+response);
        }

        @Override
        public void onFailure(Call<HelperResgistResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };
}