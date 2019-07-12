package com.example.appjam_willson.LoginRegisterActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.SignupModel;
import com.example.appjam_willson.model.SignupResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPersonalityActivity extends AppCompatActivity {

    Context context;


    private AlertDialog dialog;
    public int check_num = 0;

    private OneTextTwoButton_CustomDialog this_dialog;

    LinearLayout list5_cancelbtn;
    LinearLayout list5_backbtn;

    Button list5_nextbtn;

    String resName;
    String packName;
    int resid;



    Intent intent;
    int[] strings = new int[3];


    Typeface typebold;
    Typeface typereg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_personality);

        context = this;

        intent = getIntent();


        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list5_nextbtn = findViewById(R.id.submit);
        list5_nextbtn.setOnClickListener(new list5_1_nextbtn_listener());

        list5_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list5_cancelbtn.setOnClickListener(new list5_1_cancelbtn_listener());

        list5_backbtn = findViewById(R.id.back_btn_layout);
        list5_backbtn.setOnClickListener(new list5_1_backbtn_listener());




    }
    public void char_check(View view){
        Button nextbtn = findViewById(R.id.submit);
        CheckBox checkBox = (CheckBox)view;

        if (check_num < 3) {
            if (!checkBox.isChecked()) {
                checkBox.setChecked(false);
                checkBox.setTypeface(typereg);
                check_num -= 1;
                if(check_num<=0) check_num=0;

                for(int i = 0 ; i<3 ; i++){
                    if(Integer.parseInt(checkBox.getTag().toString()) == strings[i]){
                        strings[i] = 0;
                    }
                }

            } else {
                checkBox.setChecked(true);
                check_num += 1;
                checkBox.setTypeface(typebold);
                if(check_num>3) check_num =3;

                for(int i = 0; i<3; i++){
                    if(strings[i]== 0) {
                        strings[i] = Integer.parseInt(checkBox.getTag().toString());
                        break;
                    }
                }
            }
        } else {
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                Toast.makeText(getApplicationContext(), "성격은 최대 세 개까지 고를 수 있습니다.", Toast.LENGTH_SHORT).show();

            }
            else{
                checkBox.setChecked(false);
                checkBox.setTypeface(typereg);
                check_num -= 1;
                for(int i = 0 ; i<3 ; i++) {
                    if (Integer.parseInt(checkBox.getTag().toString())== strings[i]) {
                        strings[i] = 0;
                    }
                }

            }
        }

        if(check_num == 3) nextbtn.setEnabled(true);
        else nextbtn.setEnabled(false);
    }

    class list5_1_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }

        private void Dialog() {
            this_dialog = new OneTextTwoButton_CustomDialog(context, resid,
                    "벌써 60%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

            this_dialog.setCanceledOnTouchOutside(false);

            this_dialog.setCancelable(true);
            this_dialog.getWindow().setGravity(Gravity.CENTER);
            this_dialog.show();

        }
    }

    class list5_1_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            Intent intent = new Intent();
//            intent.putExtra("result", "BACK");
//            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list5_1_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {



            //통신
            SignupModel signupModel = new SignupModel();
            signupModel.gender = intent.getStringExtra("gender");
            signupModel.age = intent.getIntExtra("age",0);
            signupModel.nickname = intent.getStringExtra("nickname");
            signupModel.password = intent.getStringExtra("password");
            signupModel.email = intent.getStringExtra("email");
            signupModel.device_token = "token";
            signupModel.personality = strings;




            Call<SignupResponseModel> call_helper = RetrofitService.getInstance().getService().user_signup_post(signupModel);
            call_helper.enqueue(retrofitCallback);
        }
    }


    private View.OnClickListener keepListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    };

    public void onBackPressed(){
        finish();
    }

    private Callback<SignupResponseModel> retrofitCallback = new Callback<SignupResponseModel>() {

        @Override
        public void onResponse(retrofit2.Call<SignupResponseModel> call, Response<SignupResponseModel> response) {
            SignupResponseModel result = response.body();

            Log.d(">>>>response code>>>",""+response.code());
            Log.d(">>>>reult code>>>",""+result.code);


            if(response.code() == 200){

                if (result.code == 101) {
                    showAlert("이메일 또는 닉네임이 중복되었습니다 :(\n다시 작성해주세요!");
                }
                if (response.code() == 200 && result.code == 100) {
                    showAlert("가입이 완료되었습니다!\n로그인 화면으로 넘어갑니다 :)");
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "가입이 완료되었습니다! 로그인 화면으로 돌아갑니다 ><", Toast.LENGTH_SHORT).show();
                }
            }

        }

        @Override
        public void onFailure(Call<SignupResponseModel> call, Throwable t) {

        }
    };

    protected void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        dialog = builder.setMessage(message)
                .setNegativeButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.cancel();

                    }
                }).create();
        dialog.show();
    }
}
