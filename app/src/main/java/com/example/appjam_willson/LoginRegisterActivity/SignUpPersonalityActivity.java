package com.example.appjam_willson.LoginRegisterActivity;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class SignUpPersonalityActivity extends AppCompatActivity {

    Context context;

    private String user_uid ;
    private String useremail;
    private String password;
    private String userNickname;
    private SignupModel signupModel = new SignupModel();
    private Map<String, String> profile = new HashMap<>();

    private AlertDialog dialog;
    public int check_num = 0;

    private OneTextTwoButton_CustomDialog this_dialog;

    LinearLayout list5_cancelbtn;
    LinearLayout list5_backbtn;

    Button list5_nextbtn;


    String resName;
    String packName;
    int resid;

    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("askerUsers");

    Intent intent;
    int[] strings = new int[3];

    Typeface typebold;
    Typeface typereg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_personality);

        mAuth = FirebaseAuth.getInstance();
        context = this;

        intent = getIntent();

        signupModel.gender = intent.getStringExtra("gender");
        signupModel.age = intent.getIntExtra("age",0);
        signupModel.nickname = intent.getStringExtra("nickname");
        signupModel.password = intent.getStringExtra("password");
        signupModel.email = intent.getStringExtra("email");
        signupModel.device_token = "token";
        signupModel.personality_idx = strings;

        userNickname = signupModel.nickname;
        useremail = signupModel.email;
        password = signupModel.password;

        list5_nextbtn = findViewById(R.id.submit);
        list5_nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("눌렀습니다","눌렀습니다");
                RegisterUser(useremail,password);
            }
        });

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
            finish();
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
        }

        @Override
        public void onFailure(Call<SignupResponseModel> call, Throwable t) {

        }
    };
    public void RegisterUser(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUpPersonalityActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(useremail).build();

                            task.getResult().getUser().updateProfile(userProfileChangeRequest);

                            user_uid = mAuth.getCurrentUser().getUid();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("willsonUsers");
                            signupModel.uid = user_uid;
                            Call<SignupResponseModel> call_helper = RetrofitService.getInstance().getService().user_signup_post(signupModel);
                            call_helper.enqueue(retrofitCallback);
                            profile.put("photo", "");
                            profile.put("uid",user_uid);
                            profile.put("nickName",userNickname);

                            myRef.child(user_uid).setValue(profile);
                            Intent intent = new Intent(context, LoginActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(SignUpPersonalityActivity.this, "회원가입을 축하드립니다.",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        else {
                            Toast.makeText(SignUpPersonalityActivity.this, "등록된 이메일이거나 이메일 형식이 아닙니다.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
