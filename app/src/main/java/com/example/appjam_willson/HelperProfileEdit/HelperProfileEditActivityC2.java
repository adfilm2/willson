package com.example.appjam_willson.HelperProfileEdit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;


public class HelperProfileEditActivityC2 extends AppCompatActivity {
    //다음버튼에 액티비티 2 와 연결 해야함

    int REQUEST_CODE;

    RadioGroup radioGroup_1;
    RadioGroup radioGroup_2;
    Button nextbtn;
    LinearLayout custom_text;
    EditText custom_edit_text;
    LinearLayout usercustom_layout;
    LinearLayout background;

    LinearLayout backbtn;

    RadioButton oneside;
    RadioButton some;
    RadioButton conflict;
    RadioButton saygoodbye;

    TextView title;

    Context context;

    Bundle bundle1 = new Bundle();

    Typeface typebold;
    Typeface typereg;


    LinearLayout cancelbtn;

    String small_category;
   /* EditText edit;
    TextView HSUtextview;
    LinearLayout HSU_usercustom_layout;
    String title;*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_c2);

        context = this;
        REQUEST_CODE = ((HelperProfileEditActivityC2) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        ImageView btn;
        nextbtn = findViewById(R.id.btn_next);
        nextbtn.setOnClickListener(new next_btn_listener());

        backbtn = findViewById(R.id.back_btn_layout);
        backbtn.setOnClickListener(new backbtn_listener());

        btn = findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        title = findViewById(R.id.toolbar_text);
        title.setText("프로필 수정");

        radioGroup_1 = findViewById(R.id.radioGroup1);
        radioGroup_2 = findViewById(R.id.radioGroup2);
        radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
        radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);

        oneside = findViewById(R.id.btn_onesidelove);
        some = findViewById(R.id.btn_somthing);
        conflict = findViewById(R.id.btn_conflict);
        saygoodbye = findViewById(R.id.btn_saygoodbye);

        oneside.setTypeface(typereg);
        some.setTypeface(typereg);
        conflict.setTypeface(typereg);
        saygoodbye.setTypeface(typereg);

        custom_text = findViewById(R.id.btn_user_custom_layout);
        custom_text.setOnClickListener(new custom_btn_listener());

        usercustom_layout = findViewById(R.id.btn_usercustom_layout_l);

        background = findViewById(R.id.background);
        background.setOnClickListener(new background_listener());

        custom_edit_text = findViewById(R.id.usercustom_edittext);
        custom_edit_text.setOnClickListener(new custom_edit_Clicklistener());
        custom_edit_text.setOnKeyListener(new custom_edit_listener());
        custom_edit_text.setTypeface(typebold);


        cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        cancelbtn.setOnClickListener(new HelperProfileEditActivityC2.cancelbtn_listener());

    }

    private RadioGroup.OnCheckedChangeListener radioGroup_listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.btn_onesidelove){
                    oneside.setTypeface(typebold);
                    some.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_somthing){
                    some.setTypeface(typebold);
                    oneside.setTypeface(typereg);
                }
                conflict.setTypeface(typereg);
                saygoodbye.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);
                radioGroup_2.setOnCheckedChangeListener(null);
                radioGroup_2.clearCheck();
                radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
                usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                custom_edit_text.setTextColor(backcolor);
                String title;
                title = custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    custom_text.setVisibility(View.VISIBLE);
                    custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);
                if(checkedId == R.id.btn_conflict){
                    conflict.setTypeface(typebold);
                    saygoodbye.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_saygoodbye){
                    saygoodbye.setTypeface(typebold);
                    conflict.setTypeface(typereg);
                }
                oneside.setTypeface(typereg);
                some.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                radioGroup_1.setOnCheckedChangeListener(null);
                radioGroup_1.clearCheck();
                radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
                usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                custom_edit_text.setTextColor(backcolor);
                String title;
                title = custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    custom_text.setVisibility(View.VISIBLE);
                    custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    class background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (custom_edit_text.isFocused()) {
                String title;
                title = custom_edit_text.getText().toString();
                if (title.getBytes().length <= 0) {
                    nextbtn.setEnabled(false);
                    custom_text.setVisibility(View.VISIBLE);
                    custom_edit_text.setVisibility(View.INVISIBLE);
                    usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                } else {
                    nextbtn.setEnabled(true);
                }
                hidekeyboard(custom_edit_text);
                custom_edit_text.setCursorVisible(false);
            }
        }
    }

    class custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            oneside.setTypeface(typereg);
            some.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            radioGroup_1.setOnCheckedChangeListener(null);
            radioGroup_1.clearCheck();
            radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
            radioGroup_2.setOnCheckedChangeListener(null);
            radioGroup_2.clearCheck();
            radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
            custom_text.setVisibility(View.INVISIBLE);
            custom_edit_text.setVisibility(View.VISIBLE);
            custom_edit_text.setCursorVisible(true);
            custom_edit_text.requestFocus();
            showkeyboard(custom_edit_text);
            int backcolor = getResources().getColor(R.color.white);
            usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            custom_edit_text.setTextColor(backcolor);
        }
    }

    class custom_edit_Clicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                nextbtn.setEnabled(true);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            oneside.setTypeface(typereg);
            some.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            radioGroup_1.setOnCheckedChangeListener(null);
            radioGroup_1.clearCheck();
            radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
            radioGroup_2.setOnCheckedChangeListener(null);
            radioGroup_2.clearCheck();
            radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
            custom_text.setVisibility(View.INVISIBLE);
            custom_edit_text.setVisibility(View.VISIBLE);
            custom_edit_text.setCursorVisible(true);
            int backcolor = getResources().getColor(R.color.white);
            usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            custom_edit_text.setTextColor(backcolor);
        }
    }

    class custom_edit_listener implements View.OnKeyListener {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    hidekeyboard(custom_edit_text);
                    String title;
                    title = custom_edit_text.getText().toString();
                    if(title.getBytes().length <= 0) {
                        nextbtn.setEnabled(false);
                        custom_text.setVisibility(View.VISIBLE);
                        custom_edit_text.setVisibility(View.INVISIBLE);
                        usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    custom_edit_text.setCursorVisible(false);
            }
            return false;
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    private void showkeyboard(EditText edit){
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    class next_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intentProfileEdit = new Intent(context, HelperProfileEditActivityStart.class);
            startActivityForResult(intentProfileEdit,REQUEST_CODE);
        }
    }

    class backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }







}







