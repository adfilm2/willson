package com.example.appjam_willson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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

public class List1CourseActivity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_course_radioGroup1;
    RadioGroup list1_course_radioGroup2;

    Button list1_course_nextbtn;
    LinearLayout course_custom_text;
    EditText course_custom_edit_text;
    LinearLayout course_usercustom_layout;

    LinearLayout list1_course_backbtn;
    LinearLayout list1_course_cancelbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course);

        list1_course_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list1_course_cancelbtn.setOnClickListener(new list1_course_cancelbtn_listener());

        list1_course_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_course_backbtn.setOnClickListener(new list1_course_backbtn_listener());

        list1_course_radioGroup1 = (RadioGroup) findViewById(R.id.list1_course_radioGroup1);
        list1_course_radioGroup1.clearCheck();
        list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
        list1_course_radioGroup2 = (RadioGroup) findViewById(R.id.list1_course_radioGroup2);
        list1_course_radioGroup2.clearCheck();
        list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);

        list1_course_nextbtn = (Button) findViewById(R.id.list1_course_btn_next);
        list1_course_nextbtn.setOnClickListener(this);

        course_custom_text = (LinearLayout) findViewById(R.id.list1_course_btn_usercustom);
        course_custom_text.setOnClickListener(new course_custom_btn_listener());

        course_custom_edit_text = (EditText)findViewById(R.id.list1_course_usercustom_edittext);
        course_custom_edit_text.setOnClickListener(new course_custom_edit_Clicklistener());
        course_custom_edit_text.setOnKeyListener(new course_custom_edit_listener());

        course_usercustom_layout = (LinearLayout)findViewById(R.id.list1_course_btn_usercustom_layout);
    }

    private OnCheckedChangeListener radioGroup_course_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                list1_course_nextbtn.setEnabled(true);
                hidekeyboard(course_custom_edit_text);
                list1_course_radioGroup2.setOnCheckedChangeListener(null);
                list1_course_radioGroup2.clearCheck();
                list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);
                course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                course_custom_edit_text.setTextColor(backcolor);
                String title;
                title = course_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    course_custom_text.setVisibility(View.VISIBLE);
                    course_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_course_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_course_nextbtn.setEnabled(true);
                hidekeyboard(course_custom_edit_text);
                list1_course_radioGroup1.setOnCheckedChangeListener(null);
                list1_course_radioGroup1.clearCheck();
                list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
                course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                course_custom_edit_text.setTextColor(backcolor);
                String title;
                title = course_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    course_custom_text.setVisibility(View.VISIBLE);
                    course_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    @SuppressLint("ResourceType")
    public void onClick(View v) {


    }

    class list1_course_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            ListPopupActivity customDialog = new ListPopupActivity(List1CourseActivity.this);
            customDialog.callFunction();
        }
    }

    class list1_course_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }



    class course_custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = course_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_course_nextbtn.setEnabled(false);
                course_custom_text.setVisibility(View.VISIBLE);
                course_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            list1_course_radioGroup1.setOnCheckedChangeListener(null);
            list1_course_radioGroup1.clearCheck();
            list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
            list1_course_radioGroup2.setOnCheckedChangeListener(null);
            list1_course_radioGroup2.clearCheck();
            list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);
            course_custom_text.setVisibility(View.INVISIBLE);
            course_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            course_custom_edit_text.setTextColor(backcolor);
        }
    }

    class course_custom_edit_Clicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = course_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_course_nextbtn.setEnabled(false);
                course_custom_text.setVisibility(View.VISIBLE);
                course_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else {
                list1_course_nextbtn.setEnabled(true);
            }
            list1_course_radioGroup1.setOnCheckedChangeListener(null);
            list1_course_radioGroup1.clearCheck();
            list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
            list1_course_radioGroup2.setOnCheckedChangeListener(null);
            list1_course_radioGroup2.clearCheck();
            list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);
            course_custom_text.setVisibility(View.INVISIBLE);
            course_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            course_custom_edit_text.setTextColor(backcolor);
        }
    }

    class course_custom_edit_listener implements View.OnKeyListener {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    int backcolor = getResources().getColor(R.color.white);
                    course_custom_edit_text.setTextColor(backcolor);
                    hidekeyboard(course_custom_edit_text);
            }
            return false;
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

}
