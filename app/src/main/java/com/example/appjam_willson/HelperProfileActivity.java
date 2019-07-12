package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.TwoTextOneButton_CustomDialog;
import com.example.appjam_willson.model.ChoiceHelperModel;
import com.example.appjam_willson.model.ChoiceHelperResponseModel;
import com.example.appjam_willson.model.HelperProfileWatchResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperProfileActivity extends AppCompatActivity {

    Button request_btn;
    Context context;

    TextView toolbar_textView;
    ImageView cancel;
    LinearLayout back;

    Intent intent;
    int helper_idx;
    int question_idx;

    TextView nick;
    TextView gend;
    TextView age;
    TextView cate;
    TextView stars;
    TextView review;
    TextView exper1;
    TextView exper2;
    TextView exper3;
    TextView title;
    TextView detail;
    TextView person1;
    TextView person2;
    TextView person3;

    TwoTextOneButton_CustomDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_helper_profile);

        intent = getIntent();
        helper_idx = intent.getIntExtra("helper_idx", 0);

        toolbar_textView = (TextView)findViewById(R.id.toolbar_text);
        toolbar_textView.setText("헬퍼 프로필");

        cancel = (ImageView)findViewById(R.id.cancel_btn);
        cancel.setVisibility(View.INVISIBLE);

        back = (LinearLayout)findViewById(R.id.back_btn_layout);
        back.setOnClickListener(new back_listener());

        context = this;
        request_btn = (Button)findViewById(R.id.floating_btn_start);
        request_btn.setOnClickListener(new select());

        nick = (TextView)findViewById(R.id.profile_helper_id);
        gend = (TextView)findViewById(R.id.profile_helper_gender);
        age = (TextView)findViewById(R.id.profile_helper_age);
        cate = (TextView)findViewById(R.id.category);
        stars = (TextView)findViewById(R.id.profile_star);
        review = (TextView)findViewById(R.id.review_num);
        exper1 = (TextView)findViewById(R.id.ex1);
        exper2 = (TextView)findViewById(R.id.ex2);
        exper3 = (TextView)findViewById(R.id.ex3);
        title = (TextView)findViewById(R.id.profile_asker_info);
        detail = (TextView)findViewById(R.id.infomation);
        person1 = (TextView)findViewById(R.id.profile_helper_tag1);
        person2 = (TextView)findViewById(R.id.profile_helper_tag2);
        person3 = (TextView)findViewById(R.id.profile_helper_tag3);


        intent = getIntent();
        helper_idx = intent.getIntExtra("helper_idx", 0);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3ODEyNTQsImV4cCI6MTU3MTQyMTI1NCwiaXNzIjoid2lsbHNvbiJ9.R86ritC1vJ6gX2QVLNfaEp6aF8JDYwdtGPzPNzPqmcU";

        Call<HelperProfileWatchResponseModel> helper_profile = RetrofitService.getInstance().getService().watch_helperProfile_get(token, helper_idx);
        helper_profile.enqueue(retrofitCallback);


    }

    private class select implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;

            /*int question_idx = 38;
            int helper_idx = 1;*/
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3ODEyNTQsImV4cCI6MTU3MTQyMTI1NCwiaXNzIjoid2lsbHNvbiJ9.R86ritC1vJ6gX2QVLNfaEp6aF8JDYwdtGPzPNzPqmcU";

            ChoiceHelperModel choiceHelperModel = new ChoiceHelperModel();
            choiceHelperModel.setQuestion_idx(question_idx);
            choiceHelperModel.setHelper_idx(helper_idx);

            choiceHelperModel.setStatus("doing");

            Log.d("qesution_idxidxidx_헬퍼 결정", String.valueOf(question_idx));
            Log.d("helper_idxidxidx_헬퍼 결정!!!!!!!", String.valueOf(helper_idx));
            Call<ChoiceHelperResponseModel> send_request = RetrofitService.getInstance().getService().choice_helper_post(token, choiceHelperModel);
            send_request.enqueue(retrofit_Callback);

            /*ChoiceHelperModel choiceHelperModel = new ChoiceHelperModel();
            choiceHelperModel.setQuestion_idx(question_idx);
            Log.d("qesution_idxidxidx", String.valueOf(question_idx));
            choiceHelperModel.setHelper_idx(helper_idx);

            Call<ChoiceHelperResponseModel> send_request = RetrofitService.getInstance().getService().choice_helper_post(token, choiceHelperModel);
            send_request.enqueue(retrofit_Callback);*/

        }
    }


    private Callback<HelperProfileWatchResponseModel> retrofitCallback = new Callback<HelperProfileWatchResponseModel>() {
        @Override
        public void onResponse(Call<HelperProfileWatchResponseModel> call, Response<HelperProfileWatchResponseModel> response) {
            HelperProfileWatchResponseModel result = response.body();

            if(result.getCode() == 1100 && result.getData() != null){
                nick.setText(result.getData().getHelper().get(0).getNickname());
                gend.setText(result.getData().getHelper().get(0).getGender());
                age.setText("/ " + result.getData().getHelper().get(0).getAge());
                cate.setText(result.getData().getHelper().get(0).getCategory_name());
                stars.setText(result.getData().getHelper().get(0).getStars() + ".0");
                review.setText(result.getData().getHelper().get(0).getReview_count() + "개의 후기");

               if(result.getData().getExperience().get(0).getExperience_name() != null){
                   exper1.setText("#" + result.getData().getExperience().get(0).getExperience_name());
               }
               else {
                   exper1.setVisibility(View.GONE);
               }
                if(result.getData().getExperience().get(1).getExperience_name() != null){
                    exper2.setText("#" + result.getData().getExperience().get(0).getExperience_name());
                }
                else {
                    exper2.setVisibility(View.GONE);
                }
                if(result.getData().getExperience().get(2).getExperience_name() != null){
                    exper3.setText("#" + result.getData().getExperience().get(0).getExperience_name());
                }
                else {
                    exper3.setVisibility(View.GONE);
                }
                title.setText('"' + result.getData().getHelper().get(0).getTitle() + '"');
                detail.setText(result.getData().getHelper().get(0).getContent());
                person1.setText("#" + result.getData().getPersonality().get(0).getPersonality_name());
                person2.setText("#" + result.getData().getPersonality().get(1).getPersonality_name());
                person3.setText("#" + result.getData().getPersonality().get(2).getPersonality_name());
            }
            else{
                finish();
            }
        }

        @Override
        public void onFailure(Call<HelperProfileWatchResponseModel> call, Throwable t) {

        }
    };

    class back_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private Callback<ChoiceHelperResponseModel> retrofit_Callback = new Callback<ChoiceHelperResponseModel>() {
        @Override
        public void onResponse(Call<ChoiceHelperResponseModel> call, Response<ChoiceHelperResponseModel> response) {
            ChoiceHelperResponseModel result = response.body();

            Log.d("코드코드받은코드", String.valueOf(result.getCode()));

            if(response.code() == 200 && result.getCode() == 2100){
                ApplicationFields.matching_idx = result.getData().getMatching_idx();
                intent = new Intent(context, ConvConfirmActivity.class);
                /*intent.putExtra("question_idx", question_idx);*/
                startActivity(intent);
                finish();
            }
            else if(response.code() == 200 && result.getCode() == 2103){
                Dialog();
            }
            else{
                Toast.makeText(context, "USER_SELECTION_ERROR", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("이거는 response코드값", ">>>>>>>>>>>" + response.code());
            Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.getCode());
        }

        @Override
        public void onFailure(Call<ChoiceHelperResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };

    public void Dialog() {
        dialog = new TwoTextOneButton_CustomDialog(HelperProfileActivity.this,
                "앗! 이미 매칭된 헬퍼입니다", "해당 헬퍼님은 다른 고민자와 매칭되었습니다.\n다른 헬퍼님의 프로필을 보러가볼까요?", "확인", keepListener);

        dialog.setCanceledOnTouchOutside(false);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private View.OnClickListener keepListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

}
