package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.MainActivities.HelperActivity;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperSignUpStartActivity extends AppCompatActivity {


    HelperRegistModel helperRegistModel = new HelperRegistModel();
    Bundle bundle = new Bundle();
    String token;

    int REQUEST_CODE;
    Context context;
    View view;
    ImageView back;
    LinearLayout cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_start);

        context = this;
        REQUEST_CODE = ((HelperSignUpStartActivity) context).getTaskId();
        token = ApplicationFields.userToken;


        view = findViewById(R.id.signupstart);
        back = findViewById(R.id.back_btn);
        back.setVisibility(View.INVISIBLE);
        cancel = findViewById(R.id.toolbar_list_btn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button start_btn = findViewById(R.id.h_su_start_btn); //버튼이름 변경
        start_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelperSignUpStartActivity.this, HelperSignUpActivity0.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:

                    bundle = data.getExtras();
                    helperRegistModel.helper.title = bundle.getString("title");
                    helperRegistModel.helper.category_idx = bundle.getInt("category_idx");
                    helperRegistModel.helper.categoryList_idx = bundle.getInt("categoryList_idx");
                    helperRegistModel.helper.content= bundle.getString("content");
                    helperRegistModel.experience.experience_name = bundle.getStringArray("experience_name");
                    setResult(RESULT_OK, data);

                    Call<HelperRegistResponseModel> helper_regist = RetrofitService.getInstance().getService().helper_regist_post(token,helperRegistModel);
                    helper_regist.enqueue(retrofitCallback_helperReg);

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    private Callback<HelperRegistResponseModel> retrofitCallback_helperReg = new Callback<HelperRegistResponseModel>() {

        @Override
        public void onResponse(Call<HelperRegistResponseModel> call, Response<HelperRegistResponseModel> response) {
            HelperRegistResponseModel result = response.body();
            if(response.isSuccessful()){

                String user_uid = ApplicationFields.uid;
                Map<String,Object> helper_data = new HashMap<String,Object>();
                helper_data.put("uid",user_uid);
                helper_data.put("photo","");
                helper_data.put("nickname",ApplicationFields.user_nickname);
                helper_data.put("helper_idx",result.data.helper_idx);

                FirebaseDatabase.getInstance().getReference("helperUsers").child(user_uid).setValue(helper_data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context, "환영합니다 ! 당신은 "+ result.data.helper_idx + "번째 헬퍼입니다.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, HelperActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
            else{
                return ;
            }
        }
        @Override
        public void onFailure(Call<HelperRegistResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };

}