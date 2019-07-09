package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class HelperSignUpStartActivity extends AppCompatActivity {


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


        view = findViewById(R.id.signupstart);
        back = findViewById(R.id.back_btn);
        back.setVisibility(View.INVISIBLE);
        cancel = findViewById(R.id.toolbar_list_btn_cancel);

        cancel.setOnClickListener(new cancel_btn_listener());

        Button nextbtn = findViewById(R.id.h_su_start_btn); //버튼이름 변경

        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelperSignUpStartActivity.this, HelperSignUpActivity0.class);
                startActivityForResult(intent,REQUEST_CODE);


            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){



        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    private class cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();

        }
    }
}