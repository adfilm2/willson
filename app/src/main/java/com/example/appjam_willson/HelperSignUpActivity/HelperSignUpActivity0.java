        package com.example.appjam_willson.HelperSignUpActivity;

        import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.FillinListActivity.List2Activity;
import com.example.appjam_willson.R;


public class HelperSignUpActivity0 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup helperSU_radioGroup1;
    RadioGroup helperSU_radioGroup2;
    RadioGroup helperSU_radioGroup3;

    Button list1_daily_nextbtn;
    LinearLayout daily_custom_text;
    EditText daily_custom_edit_text;
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

    Typeface typebold;
    Typeface typereg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up0);

        context=this;

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        btn1 = (RadioButton) findViewById(R.id.helperSU_btn_love);
        btn2 = (RadioButton) findViewById(R.id.helperSU_btn_dream);
        btn3 = (RadioButton) findViewById(R.id.helperSU_btn_mind);
        btn4 = (RadioButton) findViewById(R.id.helperSU_btn_relationship);

        btn1.setTypeface(typereg);
        btn2.setTypeface(typereg);
        btn3.setTypeface(typereg);
        btn4.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);




        list1_daily_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_daily_backbtn.setOnClickListener(new list1_daily_backbtn_listener());

        helperSU_radioGroup1 = (RadioGroup) findViewById(R.id.helperSU_radioGroup1);
        helperSU_radioGroup1.clearCheck();
        helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
        helperSU_radioGroup2 = (RadioGroup) findViewById(R.id.helperSU_radioGroup2);
        helperSU_radioGroup2.clearCheck();
        helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);

        list1_daily_nextbtn = (Button) findViewById(R.id.list1_daily_btn_next);
        list1_daily_nextbtn.setOnClickListener(this);


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


                list1_daily_nextbtn.setEnabled(true);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener2);

            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener2 = new RadioGroup.OnCheckedChangeListener() {
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


                list1_daily_nextbtn.setEnabled(true);

                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener1);

            }
        }
    };



    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, List2Activity.class);
        startActivity(intent);
    }

    class list1_daily_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }


    class daily_custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = daily_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_daily_nextbtn.setEnabled(false);
                daily_custom_text.setVisibility(View.VISIBLE);
                daily_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            btn1.setTypeface(typereg);
            btn2.setTypeface(typereg);
            btn3.setTypeface(typereg);
            btn4.setTypeface(typereg);
            daily_custom_edit_text.setTypeface(typebold);

            helperSU_radioGroup1.setOnCheckedChangeListener(null);
            helperSU_radioGroup1.clearCheck();
            helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
            helperSU_radioGroup2.setOnCheckedChangeListener(null);
            helperSU_radioGroup2.clearCheck();
            helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);

        }
    }



    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }


}
