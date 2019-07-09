package com.example.appjam_willson.HelperSignUpActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;


public class HelperSignUpActivity0 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup helperSU_radioGroup1;
    RadioGroup helperSU_radioGroup2;
    RadioGroup helperSU_radioGroup3;

    Button helperSU_0_btn_next;
    LinearLayout daily_custom_text;
    EditText helperSU_love_edittext; //daily_custom_edit_text
    LinearLayout daily_usercustom_layout;

    LinearLayout list1_daily_backbtn;



    Context context;

    String resName;
    String packName;
    int resid;


    RadioButton btn1;
    RadioButton btn2;
    RadioButton btn3;
    RadioButton btn4;
    RadioButton btn5;
    RadioButton btn6;

    Typeface typebold;
    Typeface typereg;

    int REQUEST_CODE;

    TextView text;
    ImageView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up0);

        context= this;


        text = (TextView)findViewById(R.id.toolbar_text);
        text.setText("헬퍼 가입");
        btn =(ImageView)findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        Button nextbtn = (Button)findViewById(R.id.helperSU_0_btn_next);
        ImageView btn_back;


        btn_back = (ImageView) findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new HelperSignUpActivity0.list1_love_backbtn_listener());

        context=this;

        REQUEST_CODE = ((HelperSignUpActivity0) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        btn1 = (RadioButton) findViewById(R.id.helperSU_btn_love);
        btn2 = (RadioButton) findViewById(R.id.helperSU_btn_dream);
        btn3 = (RadioButton) findViewById(R.id.helperSU_btn_mind);
        btn4 = (RadioButton) findViewById(R.id.helperSU_btn_relationship);
        btn5 = (RadioButton) findViewById(R.id.helperSU_btn_life);
        btn6 = (RadioButton) findViewById(R.id.helperSU_btn_etc);

        btn1.setTypeface(typereg);
        btn2.setTypeface(typereg);
        btn3.setTypeface(typereg);
        btn4.setTypeface(typereg);
        btn5.setTypeface(typereg);
        btn6.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);




      //  list1_daily_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        //  list1_daily_backbtn.setOnClickListener(new list1_daily_backbtn_listener());

        helperSU_radioGroup1 = (RadioGroup) findViewById(R.id.helperSU_radioGroup1);
        helperSU_radioGroup1.clearCheck();
        helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
        helperSU_radioGroup2 = (RadioGroup) findViewById(R.id.helperSU_radioGroup2);
        helperSU_radioGroup2.clearCheck();
        helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
        helperSU_radioGroup3 = (RadioGroup) findViewById(R.id.helperSU_radioGroup3);
        helperSU_radioGroup3.clearCheck();
        helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);

        helperSU_0_btn_next = (Button) findViewById(R.id.helperSU_0_btn_next);
        helperSU_0_btn_next.setOnClickListener(this);


        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(context, HelperSignUpActivity1.class);
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

                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }


    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_love){
                    btn1.setTypeface(typebold);
                    btn2.setTypeface(typereg);
                }
                else if(checkedId == R.id.helperSU_btn_dream){
                    btn2.setTypeface(typebold);
                    btn1.setTypeface(typereg);
                }
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
                helperSU_radioGroup3.setOnCheckedChangeListener(null);
                helperSU_radioGroup3.clearCheck();
                helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);


                /*
                 list1_mentality_nextbtn.setEnabled(true);
                hidekeyboard(mentality_custom_edit_text);
                list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup2.clearCheck();
                list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
                list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup3.clearCheck();
                list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
                mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);



                 */
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_mind){
                    btn3.setTypeface(typebold);
                    btn4.setTypeface(typereg);
                }
                else if(checkedId == R.id.helperSU_btn_relationship){
                    btn4.setTypeface(typebold);
                    btn3.setTypeface(typereg);
                }
                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup3.setOnCheckedChangeListener(null);
                helperSU_radioGroup3.clearCheck();
                helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);

            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_life){
                    btn5.setTypeface(typebold);
                    btn6.setTypeface(typereg);
                }
                else if(checkedId == R.id.helperSU_btn_etc){
                    btn6.setTypeface(typebold);
                    btn5.setTypeface(typereg);
                }
                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);

            }
        }
    };




    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        //if (v.getId() == R.id.helperSU_0_btn_next) {
   //         //선택된 View가 R.id.button1와 같은 ID를 가지고 있다면 해당 로직 실행
    //        Intent intentSU = new Intent(HelperSignUpActivity0.this, HelperSignUpActivity1.class);
      /*      startActivity(intentSU);
        }
*/








        class daily_custom_btn_listener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String title;
                title = helperSU_love_edittext.getText().toString();
                if(title.getBytes().length <= 0) {
                    helperSU_0_btn_next.setEnabled(false);
                    daily_custom_text.setVisibility(View.VISIBLE);
                    helperSU_love_edittext.setVisibility(View.INVISIBLE);
                }

                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);
                helperSU_love_edittext.setTypeface(typebold);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
            }
        }


    }}
