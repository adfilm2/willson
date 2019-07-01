package com.example.appjam_willson;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class List1Activity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_radioGroup1;
    RadioGroup list1_radioGroup2;

    Button list1_nextbtn;
    TextView custom_text;
    EditText custom_edit_text;
    LinearLayout usercustom_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        list1_radioGroup1 = (RadioGroup) findViewById(R.id.list1_radioGroup1);
        list1_radioGroup1.clearCheck();
        list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
        list1_radioGroup2 = (RadioGroup) findViewById(R.id.list1_radioGroup2);
        list1_radioGroup2.clearCheck();
        list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);

        list1_nextbtn = (Button) findViewById(R.id.list1_btn_next);
        list1_nextbtn.setOnClickListener(this);

        custom_text = (TextView)findViewById(R.id.list1_btn_usercustom);
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

    }

    class custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
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
            list1_radioGroup1.setOnCheckedChangeListener(null);
            list1_radioGroup1.clearCheck();
            list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            list1_radioGroup2.setOnCheckedChangeListener(null);
            list1_radioGroup2.clearCheck();
            list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
            custom_text.setVisibility(View.INVISIBLE);
            custom_edit_text.setVisibility(View.VISIBLE);
            usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
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



}
