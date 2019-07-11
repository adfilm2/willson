

package com.example.appjam_willson.HelperProfileEdit;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;
// public class HelperSignUpActivity1 extends AppCompatActivity implements View.OnClickListener {

public class HelperProfileEditActivityC1 extends AppCompatActivity {

    int REQUEST_CODE;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;

    Button nextbtn;
    LinearLayout cancelbtn;

    Context context;

    RadioButton love;
    RadioButton course;
    RadioButton mind;
    RadioButton rela;
    RadioButton daily;
    RadioButton etc;

    Typeface typebold;
    Typeface typereg;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_c1);
        context = this;

        context = this;

        REQUEST_CODE = ((HelperProfileEditActivityC1) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        love = findViewById(R.id.btn_love);
        course = findViewById(R.id.btn_course);
        mind = findViewById(R.id.btn_mind);
        rela = findViewById(R.id.btn_rela);
        daily = findViewById(R.id.btn_life);
        etc = findViewById(R.id.btn_guitar);

        love.setTypeface(typereg);
        course.setTypeface(typereg);
        mind.setTypeface(typereg);
        rela.setTypeface(typereg);
        daily.setTypeface(typereg);
        etc.setTypeface(typereg);

        cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        cancelbtn.setOnClickListener(new cancelbtn_listener());

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup3.setOnCheckedChangeListener(radioGroup_listener3);

        nextbtn = findViewById(R.id.btn_next);
        nextbtn.setOnClickListener(new next_btn_listener());
    }

    private RadioGroup.OnCheckedChangeListener radioGroup_listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.btn_love){
                    love.setTypeface(typebold);
                    course.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_course){
                    course.setTypeface(typebold);
                    love.setTypeface(typereg);
                }

                mind.setTypeface(typereg);
                rela.setTypeface(typereg);
                daily.setTypeface(typereg);
                etc.setTypeface(typereg);

                nextbtn.setEnabled(true);
                radioGroup2.setOnCheckedChangeListener(null);
                radioGroup2.clearCheck();
                radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
                radioGroup3.setOnCheckedChangeListener(null);
                radioGroup3.clearCheck();
                radioGroup3.setOnCheckedChangeListener(radioGroup_listener3);

            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {

                if(checkedId == R.id.btn_mind){
                    mind.setTypeface(typebold);
                    rela.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_rela){
                    rela.setTypeface(typebold);
                    mind.setTypeface(typereg);
                }
                love.setTypeface(typereg);
                course.setTypeface(typereg);
                daily.setTypeface(typereg);
                etc.setTypeface(typereg);

                nextbtn.setEnabled(true);
                radioGroup1.setOnCheckedChangeListener(null);
                radioGroup1.clearCheck();
                radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
                radioGroup3.setOnCheckedChangeListener(null);
                radioGroup3.clearCheck();
                radioGroup3.setOnCheckedChangeListener(radioGroup_listener3);

            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_listener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {

                if(checkedId == R.id.btn_life){
                    daily.setTypeface(typebold);
                    etc.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_guitar){
                    etc.setTypeface(typebold);
                    daily.setTypeface(typereg);
                }
                love.setTypeface(typereg);
                course.setTypeface(typereg);
                mind.setTypeface(typereg);
                rela.setTypeface(typereg);

                nextbtn.setEnabled(true);

                radioGroup1.setOnCheckedChangeListener(null);
                radioGroup1.clearCheck();
                radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
                radioGroup2.setOnCheckedChangeListener(null);
                radioGroup2.clearCheck();
                radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
            }
        }
    };


    class cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class next_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, HelperProfileEditActivityC2.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
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















