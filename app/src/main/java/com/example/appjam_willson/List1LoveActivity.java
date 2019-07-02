package com.example.appjam_willson;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List1LoveActivity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_radioGroup1;
    RadioGroup list1_radioGroup2;

    Button list1_nextbtn;
    LinearLayout custom_text;
    EditText custom_edit_text;
    LinearLayout usercustom_layout;

    LinearLayout list1_love_backbtn;
    LinearLayout list1_love_cancelbtn;

    private CustomDialog dialog;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_love);

        context = this;

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

        usercustom_layout = (LinearLayout)findViewById(R.id.list1_btn_usercustom_layout);
    }

    private OnCheckedChangeListener radioGroup_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
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

    class custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            list1_radioGroup1.setOnCheckedChangeListener(null);
            list1_radioGroup1.clearCheck();
            list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            list1_radioGroup2.setOnCheckedChangeListener(null);
            list1_radioGroup2.clearCheck();
            list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
            custom_text.setVisibility(View.INVISIBLE);
            custom_edit_text.setVisibility(View.VISIBLE);
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
                list1_nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_nextbtn.setEnabled(true);
            }
            list1_radioGroup1.setOnCheckedChangeListener(null);
            list1_radioGroup1.clearCheck();
            list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            list1_radioGroup2.setOnCheckedChangeListener(null);
            list1_radioGroup2.clearCheck();
            list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
            custom_text.setVisibility(View.INVISIBLE);
            custom_edit_text.setVisibility(View.VISIBLE);
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

    public void Dialog() {
        dialog = new CustomDialog(List1LoveActivity.this,
                "정말 그만두시겠어요?\\n아직 하나도 작성하시지 않으셨어요!", keepListener, exitListener);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private View.OnClickListener keepListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

}
