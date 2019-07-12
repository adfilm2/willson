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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.TwoTextOneButton_CustomDialog;
import com.example.appjam_willson.model.SendRequestModel;
import com.example.appjam_willson.model.SendRequestResponseModel;
import com.example.appjam_willson.model.UserProfileWatchResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AskerProfileActivity extends AppCompatActivity {

    Button request_btn;
    Context context;

    TextView toolbar_textView;
    ImageView cancel;
    LinearLayout back;

    Intent intent;

    TextView Nickname;
    TextView Gender;
    TextView Age;
    TextView Person1;
    TextView Person2;
    TextView Person3;
    TextView Category_L;
    TextView Content_L;
    TextView Category;
    TextView Question_person;
    ProgressBar Weight;
    TextView Content;
    TextView Want_gender;
    TextView Want_person;
    TextView Want_exper;
    ProgressBar Emotion;
    ProgressBar Advice;
    ProgressBar Experience;
    ImageView image;

    TwoTextOneButton_CustomDialog dialog;

    int question_idx;
    int helper_idx;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asker_profile);

        toolbar_textView = findViewById(R.id.toolbar_text);
        toolbar_textView.setText("프로필");

        cancel = findViewById(R.id.cancel_btn);
        cancel.setVisibility(View.INVISIBLE);

        back = findViewById(R.id.back_btn_layout);
        back.setOnClickListener(new set_back_listener());

        Nickname = findViewById(R.id.profile_helper_id);
        Gender = findViewById(R.id.profile_helper_gender);
        Age = findViewById(R.id.profile_helper_age);
        Person1 = findViewById(R.id.profile_helper_tag1);
        Person2 = findViewById(R.id.profile_helper_tag2);
        Person3 = findViewById(R.id.profile_helper_tag3);
        Category_L = findViewById(R.id.category_name);
        Content_L = findViewById(R.id.profile_asker_info);
        Category = findViewById(R.id.content_list_name);
        Question_person = findViewById(R.id.question_personality);
        Weight = findViewById(R.id.user_weight);
        Content = findViewById(R.id.user_content_detail);
        Want_gender = findViewById(R.id.want_gender);
        Want_person = findViewById(R.id.want_person);
        Want_exper = findViewById(R.id.want_exper);
        Emotion = findViewById(R.id.progress_emotion);
        Advice = findViewById(R.id.progress_advise);
        Experience = findViewById(R.id.progress_experience);
        image = findViewById(R.id.profile_helper_img);

        context = this;
        request_btn = findViewById(R.id.floating_btn_request);
        request_btn.setOnClickListener(new request_conversation());

        intent = getIntent();
        helper_idx = intent.getIntExtra("helper_idx", 0);
        question_idx = intent.getIntExtra("question_idx", 0);


        /*token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";
*///그전 token

        Log.d("이거는 프로필 볼때 idx", String.valueOf(question_idx));

       /* token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NDYsIm5pY2tuYW1lIjoi64uJ64S0IiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNzU0NTE3LCJleHAiOjE1NzEzOTQ1MTcsImlzcyI6IndpbGxzb24ifQ.8QFtG_wNveh114Fs6NDxcsvMhRocHhKhkYTJjqCFYnc";
*///그전 token

      /*  token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3ODEyNTQsImV4cCI6MTU3MTQyMTI1NCwiaXNzIjoid2lsbHNvbiJ9.R86ritC1vJ6gX2QVLNfaEp6aF8JDYwdtGPzPNzPqmcU";
*///그전 token

        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTksIm5pY2tuYW1lIjoi7J2066aE7J2066aEIiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyODU3MDU3LCJleHAiOjE1NzE0OTcwNTcsImlzcyI6IndpbGxzb24ifQ.j8sNiLFIXRsZ-CZORN6zuG9IZAS8rQ7m_i0FyRr6LQY";

        Call<UserProfileWatchResponseModel> user_profile = RetrofitService.getInstance().getService().get_user_profile(question_idx);
        user_profile.enqueue(retrofitCallback);

    }

    private Callback<UserProfileWatchResponseModel> retrofitCallback = new Callback<UserProfileWatchResponseModel>() {
        @Override
        public void onResponse(Call<UserProfileWatchResponseModel> call, Response<UserProfileWatchResponseModel> response) {
            UserProfileWatchResponseModel result = response.body();

            if(result.getCode() == 300){

                Nickname.setText(result.getData().getUser().getNickname());
                Log.d("이거 유저 닉네임", result.getData().getUser().getNickname());
                if(result.getData().getUser().getGender().equals("여성")){
                    image.setImageResource(R.drawable.helper_img_profile_woman);
                }
                else {
                    image.setImageResource(R.drawable.helper_img_profile_man);
                }

                Gender.setText(result.getData().getUser().getGender());
                Age.setText(result.getData().getUser().getAge());
                Person1.setText("#" + result.getData().getUser_personality().get(0).getPersonality_name());
                Person2.setText("#" + result.getData().getUser_personality().get(1).getPersonality_name());
                Person3.setText("#" + result.getData().getUser_personality().get(2).getPersonality_name());
                Category_L.setText(result.getData().getQuestion().getCategory_name());
                Content_L.setText(result.getData().getQuestion().getCategory_name());
                Category.setText("#" + result.getData().getQuestion().getCategoryList_name());
                String person = "";
                for(int i = 0;  i < result.getData().getQuestion().getQuestion_feeling().size(); i++){
                    String temp = null;
                    temp = "#" + result.getData().getQuestion().getQuestion_feeling().get(i).getFeeling_name();
                    person += temp + " ";
                }
                Question_person.setText(person);
                Weight.setProgress(result.getData().getQuestion().getWeight());
                Content.setText(result.getData().getQuestion().getContent());
                String temp = "성별 : " + result.getData().getQuestion().getHelper_gender();
                Want_gender.setText(temp);
                temp = "성격 : ";
                for(int i = 0; i < result.getData().getQuestion().getQuestion_personality().size(); i++){
                    temp += "#" + result.getData().getQuestion().getQuestion_personality().get(i).getPersonality_name();
                }
                Want_person.setText(temp);
                temp = "경험 : ";
                for(int i = 0; i < result.getData().getQuestion().getQuestion_experience().size(); i++) {
                    if (result.getData().getQuestion().getQuestion_experience().get(i).getExperience_name() != null) {
                        temp += "#" + result.getData().getQuestion().getQuestion_experience().get(i).getExperience_name();
                    }
                }
                Emotion.setProgress(result.getData().getQuestion().getEmotion());
                Advice.setProgress(result.getData().getQuestion().getAdvise());
                Experience.setProgress(result.getData().getQuestion().getExperience());

            }
        }

        @Override
        public void onFailure(Call<UserProfileWatchResponseModel> call, Throwable t) {

        }
    };

    class set_back_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private class request_conversation implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;

            SendRequestModel sendRequestModel = new SendRequestModel();
            sendRequestModel.setQuestion_idx(question_idx);
            Log.d("요청을 보낸다아아앗", String.valueOf(question_idx));
            Call<SendRequestResponseModel> send_request = RetrofitService.getInstance().getService().send_request_post(token, sendRequestModel);
            send_request.enqueue(retrofit_Callback);

           /* ChoiceHelperModel choiceHelperModel = new ChoiceHelperModel();
            choiceHelperModel.setQuestion_idx(question_idx);
            choiceHelperModel.setHelper_idx(helper_idx);
            Log.d("qesution_idxidxidx_헬퍼 결정", String.valueOf(question_idx));
            Log.d("helper_idxidxidx_헬퍼 결정!!!!!!!", String.valueOf(helper_idx));
            Call<ChoiceHelperResponseModel> send_request = RetrofitService.getInstance().getService().choice_helper_post(token, choiceHelperModel);
            send_request.enqueue(retrofit_Callback);*/
        }
    }

    private Callback<SendRequestResponseModel> retrofit_Callback = new Callback<SendRequestResponseModel>() {
        @Override
        public void onResponse(Call<SendRequestResponseModel> call, Response<SendRequestResponseModel> response) {
            SendRequestResponseModel result = response.body();

            Log.d("코드코드받은코드", String.valueOf(result.getCode()));

            if(response.code() == 200 && result.getCode() == 1400 ){
                intent = new Intent(context, HelperRequestCompleteActivity.class);
                /*intent.putExtra("question_idx", question_idx);*/
                startActivity(intent);
                finish();
            }
            else if(response.code() == 200 && result.getCode() == 1404){
                Dialog();
            }
            else{
                Toast.makeText(context, "HELPER_SELECTION_ERROR", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("이거는 response코드값", ">>>>>>>>>>>" + response.code());
            Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.getCode());
        }

        @Override
        public void onFailure(Call<SendRequestResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };

    public void Dialog() {
        dialog = new TwoTextOneButton_CustomDialog(AskerProfileActivity.this,
                "지금은 요청할 수 없어요", "대화를 진행 중인 경우에는\n다른 질문자에게 중복 요청이 불가능합니다", "확인", keepListener);

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
