package com.example.appjam_willson;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestActivity extends AppCompatActivity {

    Button btn;

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btn = findViewById(R.id.test_button);

/*        retrofit = new Retrofit.Builder()
                .baseUrl("http://13.125.216.169/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);*/

        HelperRegistModel helperRegistModel = new HelperRegistModel();
        helperRegistModel.helper.title = "호이이이이잉이이이이이잉ㅇ잇";
        helperRegistModel.helper.category_name = "진로";
        helperRegistModel.helper.categoryList_name = "너로 정햇따!!!!!";
        helperRegistModel.helper.content = "가라아아앗 피카츄우우우우우우";

        String[] tt = {"er", "er", "er"};
        helperRegistModel.experience.experience_name = tt;

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";


        Call<HelperRegistResponseModel> call_helper = RetrofitService.getInstance().getService().helper_regist_post(token, helperRegistModel);

        call_helper.enqueue(new Callback<HelperRegistResponseModel>() {
            @Override
            public void onResponse(Call<HelperRegistResponseModel> call, Response<HelperRegistResponseModel> response) {
                Log.d("test", response.isSuccessful() + "");
                HelperRegistResponseModel result = response.body();
                Log.d("dlfkdlfjkdl", ">>>>>>>>>>>" + response.code());
                Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.code);

            }

            @Override
            public void onFailure(Call<HelperRegistResponseModel> call, Throwable t) {
                t.printStackTrace();
                Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
            }
        });

    }


}
