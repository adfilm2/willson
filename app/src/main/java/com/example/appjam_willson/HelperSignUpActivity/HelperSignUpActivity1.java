package com.example.appjam_willson.HelperSignUpActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;
// public class HelperSignUpActivity1 extends AppCompatActivity implements View.OnClickListener {


public class HelperSignUpActivity1 extends AppCompatActivity  {
//다음버튼에 액티비티 2 와 연결 해야함

    int REQUEST_CODE;
    Context context;
    Bundle bundle1 = new Bundle();
    String small_category;
    EditText edit;




    public void onCreate(Bundle savedInstanceState)
    {

        context = this;
        REQUEST_CODE = ((HelperSignUpActivity1) context).getTaskId();


        ImageView btn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up1);
        CheckBox button1 = (CheckBox) findViewById(R.id.helperSU_btn_love1) ;
        CheckBox button2 = (CheckBox) findViewById(R.id.helperSU_btn_love2) ;
        CheckBox button3 = (CheckBox) findViewById(R.id.helperSU_btn_love3) ;
        CheckBox button4 = (CheckBox) findViewById(R.id.helperSU_btn_love4) ;
        Button nextbtn = (Button)findViewById(R.id.HelperSU_btn_next);

        btn =(ImageView)findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        ImageView btn_back;

        edit = (EditText)findViewById(R.id.edit);

        btn_back = (ImageView) findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new backbtn_listener());




        button1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button1.setBackgroundResource(R.drawable.helpersignupbackground);
                button1.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }



        });
        button2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button2.setBackgroundResource(R.drawable.helpersignupbackground);
                button2.setTextColor(getColor(R.color.white));
                button1.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);






            }
        });

        button3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button3.setBackgroundResource(R.drawable.helpersignupbackground);
                button3.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button1.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);




            }
        });

        button4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button4.setBackgroundResource(R.drawable.helpersignupbackground);
                button4.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button1.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }
        });

        nextbtn.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button1.isChecked()){
                    small_category = button1.getText().toString();
                }
                else if (button2.isChecked()){
                    small_category = button2.getText().toString();
                }
                else if (button3.isChecked()){
                    small_category = button3.getText().toString();
                }
                else if (button4.isChecked()){
                    small_category = button4.getText().toString();
                }
                else if (edit.isFocused()){
                    small_category = edit.getText().toString();
                }
                else{}


                Intent intentProfileEdit = new Intent(context, HelperSignUpActivity2.class);
                startActivityForResult(intentProfileEdit,REQUEST_CODE);

            }


        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle1 = data.getExtras();
                    bundle1.putInt("category",1);
                    bundle1.putString("small category",small_category);

                    data.putExtras(bundle1);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }


    class backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }








    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //이곳에 버튼 클릭시 일어날 일을 적습니다.
        }
    };
};






