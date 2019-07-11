package com.example.appjam_willson;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.google.android.gms.common.internal.service.Common;

import retrofit2.Retrofit;

public class TestActivity extends AppCompatActivity {

    Button btn;

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;

    String cidx;
    WebView webView;

    Common comm;
    public static Context ctx;


    TextView test;

    public class user {
        String nick = "피카츄";
        int id = 10;
    }

    user userser = new user();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  setContentView(R.layout.activity_test);

     //   test = (TextView)findViewById(R.id.test_text);

        user userd = userser;


/*        String[] tt = {"gl", "아아오오오", "후후이이후후이이"};

        String temp = "성격 : ";

        for(int i = 0; i < tt.length; i++){
            temp += "# " + tt[i] + " ";
        }

        test.setText(temp);*/

        test.setText(userd.nick);

       /* String refreshedToken = FirebaseInstanceId.getInstance().getToken();*/


       /* retrofit = new Retrofit.Builder()
                .baseUrl("http://13.125.216.169/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);

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
*/




    }


}