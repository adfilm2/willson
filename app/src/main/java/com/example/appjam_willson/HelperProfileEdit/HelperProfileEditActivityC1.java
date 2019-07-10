

package com.example.appjam_willson.HelperProfileEdit;



        import android.content.Context;
        import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;
// public class HelperSignUpActivity1 extends AppCompatActivity implements View.OnClickListener {

public class HelperProfileEditActivityC1 extends AppCompatActivity {


    ImageView btn_profile;
    TextView text_toolbar;
    int REQUEST_CODE;
    Context context;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_c1);
        context = this;

        REQUEST_CODE = ((HelperProfileEditActivityC1) context).getTaskId();

        Button button1 = findViewById(R.id.helperSU_btn_love);
        Button button2 = findViewById(R.id.helperSU_btn_dream);
        Button button3 = findViewById(R.id.helperSU_btn_mind); //helperSU_btn_life helperSU_btn_etc
        Button button4 = findViewById(R.id.helperSU_btn_relationship);
        Button button5 = findViewById(R.id.helperSU_btn_life);
        Button button6 = findViewById(R.id.helperSU_btn_etc);
        Button nextbtn = findViewById(R.id.btn_next);
        //Button backbtn = (Button) findViewById(R.id.btn_backbtn);

        /*ImageView btn_back;*/

        btn_profile = findViewById(R.id.back_btn);
        btn_profile.setVisibility(View.INVISIBLE);

        text_toolbar = findViewById(R.id.toolbar_text);
        text_toolbar.setText("프로필 수정");

       /* btn_back = (ImageView) findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new HelperProfileEditActivityC1.list1_love_backbtn_listener());
*/



        button1.setOnClickListener(new Button.OnClickListener() {
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
                button5.setTextColor(getColor(R.color.lightPurple));
                button5.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button6.setTextColor(getColor(R.color.lightPurple));
                button6.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }


        });
        button2.setOnClickListener(new Button.OnClickListener() {
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
                button5.setTextColor(getColor(R.color.lightPurple));
                button5.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button6.setTextColor(getColor(R.color.lightPurple));
                button6.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {
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
                button5.setTextColor(getColor(R.color.lightPurple));
                button5.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button6.setTextColor(getColor(R.color.lightPurple));
                button6.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {
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
                button5.setTextColor(getColor(R.color.lightPurple));
                button5.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button6.setTextColor(getColor(R.color.lightPurple));
                button6.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }
        });
        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button5.setBackgroundResource(R.drawable.helpersignupbackground);
                button5.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button1.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button6.setTextColor(getColor(R.color.lightPurple));
                button6.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }


        });
        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button6.setBackgroundResource(R.drawable.helpersignupbackground);
                button6.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button5.setTextColor(getColor(R.color.lightPurple));
                button5.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button1.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }


        });

        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(context, HelperProfileEditActivityC2.class);
                startActivityForResult(intentProfileEdit,REQUEST_CODE);


            }


        });

     /*   backbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }


        });*/

    }

/*
    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //이곳에 버튼 클릭시 일어날 일을 적습니다.
        }
    };

    */


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}















