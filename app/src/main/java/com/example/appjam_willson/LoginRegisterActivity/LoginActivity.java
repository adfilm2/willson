package com.example.appjam_willson.LoginRegisterActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.MainActivities.MainActivity;
import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.LoginModel;
import com.example.appjam_willson.model.LoginResponseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private LoginModel loginModel = new LoginModel();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        EditText idText=findViewById(R.id.Login_ID);
        EditText passwordText=findViewById(R.id.Login_Password);

        Button registerButton = findViewById(R.id.Email_register);
        Button emailLoginButton = findViewById(R.id.Email_login);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity_asker.class);
                startActivity(intent);
            }
        });

        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = idText.getText().toString();
                String password = passwordText.getText().toString();

                loginModel.setEmail(email);
                loginModel.setPassword(password);

                LoginUser(email,password);

            }
        });





    }




    public void LoginUser(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Call<LoginResponseModel> call_helper = RetrofitService.getInstance().getService().user_login_post(loginModel);
                            call_helper.enqueue(retrofitCallback);
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "로그인에 실패했습니다.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private Callback<LoginResponseModel> retrofitCallback = new Callback<LoginResponseModel>() {

        @Override
        public void onResponse(retrofit2.Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
            LoginResponseModel result = response.body();
            if(response.isSuccessful()){
                ApplicationFields.userToken = result.data.Token;
                ApplicationFields.uid = result.data.userInfo.uid;
                ApplicationFields.user_nickname = result.data.userInfo.nickname;
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                return ;
            }
        }

        @Override
        public void onFailure(Call<LoginResponseModel> call, Throwable t) {
            t.printStackTrace();

        }
    };
}
