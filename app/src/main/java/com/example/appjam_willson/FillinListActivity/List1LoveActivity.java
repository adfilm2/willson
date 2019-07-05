package com.example.appjam_willson.FillinListActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

public class List1LoveActivity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_radioGroup1;
    RadioGroup list1_radioGroup2;

    Button list1_nextbtn;
    LinearLayout custom_text;
    EditText custom_edit_text;
    LinearLayout usercustom_layout;

    LinearLayout background;

    LinearLayout list1_love_backbtn;
    LinearLayout list1_love_cancelbtn;

    private OneTextTwoButton_CustomDialog dialog;

    Context context;

    String resName;
    String packName;
    int resid;

    RadioButton onesidelove;
    RadioButton somthing;
    RadioButton conflict;
    RadioButton saygoodbye;

    Typeface typebold;
    Typeface typereg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_love);

        context = this;

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        onesidelove = (RadioButton) findViewById(R.id.list1_btn_onesidelove);
        somthing = (RadioButton) findViewById(R.id.list1_btn_somthing);
        conflict = (RadioButton) findViewById(R.id.list1_btn_conflict);
        saygoodbye = (RadioButton) findViewById(R.id.list1_btn_saygoodbye);

        conflict.setTypeface(typereg);
        saygoodbye.setTypeface(typereg);
        onesidelove.setTypeface(typereg);
        somthing.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list1_love_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list1_love_cancelbtn.setOnClickListener(new list1_love_cancelbtn_listener());

        list1_love_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_love_backbtn.setOnClickListener(new list1_love_backbtn_listener());

        list1_radioGroup1 = (RadioGroup) findViewById(R.id.list1_radioGroup1);
        list1_radioGroup1.clearCheck();
        list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
        list1_radioGroup2 = (RadioGroup) findViewById(R.id.list1_radioGroup2);
        list1_radioGroup2.clearCheck();
        list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);

        list1_nextbtn = (Button) findViewById(R.id.list1_btn_next);
        list1_nextbtn.setOnClickListener(this);

        custom_text = (LinearLayout)findViewById(R.id.list1_btn_usercustom);
        custom_text.setOnClickListener(new custom_btn_listener());

        custom_edit_text = (EditText)findViewById(R.id.list1_usercustom_edittext);
        custom_edit_text.setOnClickListener(new custom_edit_Clicklistener());
        custom_edit_text.setOnKeyListener(new custom_edit_listener());
        custom_edit_text.setTypeface(typebold);

        usercustom_layout = (LinearLayout)findViewById(R.id.list1_btn_usercustom_layout);

        background = (LinearLayout)findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());
    }

    private OnCheckedChangeListener radioGroup_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.list1_btn_onesidelove){
                    onesidelove.setTypeface(typebold);
                    somthing.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_btn_somthing){
                    somthing.setTypeface(typebold);
                    onesidelove.setTypeface(typereg);
                }
                conflict.setTypeface(typereg);
                saygoodbye.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                list1_nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);
                list1_radioGroup2.setOnCheckedChangeListener(null);
                list1_radioGroup2.clearCheck();
                list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
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

    private OnCheckedChangeListener radioGroup_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);

                if(checkedId == R.id.list1_btn_conflict){
                    conflict.setTypeface(typebold);
                    saygoodbye.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_btn_saygoodbye){
                    saygoodbye.setTypeface(typebold);
                    conflict.setTypeface(typereg);
                }
                onesidelove.setTypeface(typereg);
                somthing.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                list1_radioGroup1.setOnCheckedChangeListener(null);
                list1_radioGroup1.clearCheck();
                list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
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

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, List2Activity.class);
        startActivity(intent);
    }

    class list1_love_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_love_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            hidekeyboard(custom_edit_text);
        }
    }

    class custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            onesidelove.setTypeface(typereg);
            somthing.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            list1_radioGroup1.setOnCheckedChangeListener(null);
            list1_radioGroup1.clearCheck();
            list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            list1_radioGroup2.setOnCheckedChangeListener(null);
            list1_radioGroup2.clearCheck();
            list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
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

    class custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_nextbtn.setEnabled(true);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            onesidelove.setTypeface(typereg);
            somthing.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            list1_radioGroup1.setOnCheckedChangeListener(null);
            list1_radioGroup1.clearCheck();
            list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            list1_radioGroup2.setOnCheckedChangeListener(null);
            list1_radioGroup2.clearCheck();
            list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
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
                    int backcolor = getResources().getColor(R.color.white);
                    custom_edit_text.setTextColor(backcolor);
                    hidekeyboard(custom_edit_text);
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

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List1LoveActivity.this, resid,
                "정말 그만두시겠어요?\n아직 하나도 작성하시지 않으셨어요!", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCancelable(true);

        //바깥에 눌러도 안없어지기
        dialog.setCanceledOnTouchOutside(false);

        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private OnClickListener keepListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private OnClickListener exitListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

}