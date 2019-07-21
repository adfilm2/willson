package com.example.appjam_willson.LoginRegisterActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity_asker extends AppCompatActivity {

    private String userEmail;
    private String userPassword;
    private AlertDialog dialog;
    private String userNickname;
    private boolean nickNameCheck;
    private ArrayAdapter adapter;
    private int userAge;
    private String userGender;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("askerUsers");


    RadioGroup genderGroup;

    Button register_btn;
    LinearLayout background;

    LinearLayout back_btn;

    EditText nickName;
    private FirebaseAuth mAuth;
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_asker);

        ImageView cancel = findViewById(R.id.cancel_btn);
        cancel.setVisibility(View.INVISIBLE);

        TextView text = findViewById(R.id.toolbar_text);
        text.setText("회원가입");

        final EditText idText=findViewById(R.id.registerasker_email);
        final EditText passwordText=findViewById(R.id.registerasker_password);
        final EditText passwordConfirm = findViewById(R.id.registerasker_passwordConfirm);
        final TextView ConfirmMsg_password = findViewById(R.id.registerasker_passwordConfirm_Msg);
        nickName = findViewById(R.id.registerasker_nickName);
        final CheckBox checkBox = findViewById(R.id.registerasker_checkBox);
        final Spinner ageSpinner = findViewById(R.id.registerasker_age);
        final TextView checkBox_text = findViewById(R.id.registerasker_checkBox_text);

        register_btn = findViewById(R.id.register_btn);

        back_btn = findViewById(R.id.back_btn_layout);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        background = findViewById(R.id.background_id);
        background.setOnClickListener(new background_listener());

        mAuth = FirebaseAuth.getInstance();

        adapter = ArrayAdapter.createFromResource(this, R.array.Age_group, android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);
        ageSpinner.setSelection(0);

        genderGroup = findViewById(R.id.registerasker_gender);
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                RadioButton genderButton = findViewById(i);
                userGender = genderButton.getText().toString();
            }
        });

        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = passwordText.getText().toString();
                String confirm = passwordConfirm.getText().toString();
                if(password.equals(confirm) && password.length() >= 6 ){
                    ConfirmMsg_password.setTextColor(Color.parseColor("#2eb3b2"));
                    ConfirmMsg_password.setText("비밀번호 확인");
                }
                else if(password.length() < 6 ){
                    ConfirmMsg_password.setTextColor(Color.parseColor("#ED2939"));
                    ConfirmMsg_password.setText("비밀번호를 6자리 이상 입력해주세요.");
                }
                else{
                    ConfirmMsg_password.setTextColor(Color.parseColor("#ED2939"));
                    ConfirmMsg_password.setText("비밀번호가 맞지 않습니다");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = passwordText.getText().toString();
                String confirm = passwordConfirm.getText().toString();
                if(password.equals(confirm) && password.length() >= 6){
                    ConfirmMsg_password.setTextColor(Color.parseColor("#2eb3b2"));
                    ConfirmMsg_password.setText("비밀번호 확인");
                }
                else if(password.length() < 6 ){
                    ConfirmMsg_password.setTextColor(Color.parseColor("#ED2939"));
                    ConfirmMsg_password.setText("비밀번호를 6자리 이상 입력해주세요.");
                }
                else{
                    ConfirmMsg_password.setTextColor(Color.parseColor("#ED2939"));
                    ConfirmMsg_password.setText("비밀번호가 맞지 않습니다");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final Button completeButton = findViewById(R.id.register_btn);

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toCheckAge = ageSpinner.getSelectedItem().toString();
                userEmail = idText.getText().toString();
                userPassword = passwordText.getText().toString();
                userNickname = nickName.getText().toString();
                RadioButton gender = findViewById(genderGroup.getCheckedRadioButtonId());
                userGender = gender.getText().toString();
                userAge = Integer.parseInt(ageSpinner.getSelectedItem().toString());

                if(userEmail.equals("") || userPassword.equals("") || userNickname.equals("") ||
                        toCheckAge.equals("나이를 선택해주세요.") || userGender.equals("")){
                    showAlert("빈 항목을 채워주세요.");
                    return ;
                }
                else if(!userPassword.equals(passwordConfirm.getText().toString()) ||
                        userPassword.length()<6 ){
                    showAlert("비밀번호를 다시 확인해주세요.");
                    return;
                }

                bundle.putString("nickname",userNickname);
                bundle.putString("email",userEmail);
                bundle.putInt("age",userAge);
                bundle.putString("password",userPassword);
                bundle.putString("gender",userGender);

                Intent intent = new Intent(RegisterActivity_asker.this,SignUpPersonalityActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

//                checkNickName(userNickname, new Runnable() {
//                    @Override
//                    public void run() {
//                        if(nickNameCheck == false){
//                            showAlert("존재하는 닉네임 입니다.");
//                            Log.d("닉네임체크값",String.valueOf(nickNameCheck));
//                            return;
//                        }
//                        Intent intent = new Intent(getApplicationContext(),SignUpPersonalityActivity.class);
//                        intent.putExtras(bundle);
//                        startActivity(intent);
//                    }
//                });
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    completeButton.setEnabled(true);
                    checkBox_text.setTextColor(Color.parseColor("#37376d"));
                }
                else{
                    completeButton.setEnabled(false);
                    checkBox_text.setTextColor(Color.parseColor("#bdbdbd"));
                }
            }
        });
    }

    protected void checkNickName(String NickName, final Runnable callback){

        FirebaseDatabase.getInstance().getReference("willsonUsers").orderByChild("nickName").equalTo(NickName).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() == null){
                    nickNameCheck = true;
                }
                else{
                    nickNameCheck = false;
                }
                RegisterActivity_asker.this.runOnUiThread(callback);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    protected void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity_asker.this);
        dialog = builder.setMessage(message)
                .setNegativeButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.cancel();
                    }
                })
                .create();
        dialog.show();
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    class background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            hidekeyboard(nickName);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog!=null)
        {
            dialog.dismiss();
            dialog = null;

        }
    }
}
