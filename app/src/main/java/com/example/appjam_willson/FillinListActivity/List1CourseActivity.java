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

public class List1CourseActivity extends AppCompatActivity implements OnClickListener {

    int REQUEST_CODE;

    RadioGroup list1_course_radioGroup1;
    RadioGroup list1_course_radioGroup2;

    Button list1_course_nextbtn;
    LinearLayout course_custom_text;
    EditText course_custom_edit_text;
    LinearLayout course_usercustom_layout;

    LinearLayout list1_course_backbtn;
    LinearLayout list1_course_cancelbtn;

    LinearLayout background;

    Context context;
    private OneTextTwoButton_CustomDialog dialog;

    String resName;
    String packName;
    int resid;

    RadioButton study;
    RadioButton employment;
    RadioButton transfer;

    Typeface typebold;
    Typeface typereg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course);

        context = this;

        REQUEST_CODE = ((List1CourseActivity) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        study = (RadioButton) findViewById(R.id.list1_course_btn_study);
        employment = (RadioButton) findViewById(R.id.list1_course_btn_employment);
        transfer = (RadioButton) findViewById(R.id.list1_course_btn_transfer);

        study.setTypeface(typereg);
        employment.setTypeface(typereg);
        transfer.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

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
        course_custom_edit_text.setTypeface(typebold);

        course_usercustom_layout = (LinearLayout)findViewById(R.id.list1_course_btn_usercustom_layout);

        background = (LinearLayout)findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());
    }

    private OnCheckedChangeListener radioGroup_course_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.list1_course_btn_study){
                    study.setTypeface(typebold);
                    employment.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_course_btn_employment){
                    employment.setTypeface(typebold);
                    study.setTypeface(typereg);
                }
                transfer.setTypeface(typereg);
                course_custom_edit_text.setTypeface(typereg);
                course_custom_edit_text.setCursorVisible(false);
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

                if(checkedId == R.id.list1_course_btn_transfer){
                    transfer.setTypeface(typebold);
                }
                else {
                    transfer.setTypeface(typereg);
                }
                study.setTypeface(typereg);
                employment.setTypeface(typereg);
                course_custom_edit_text.setTypeface(typereg);
                course_custom_edit_text.setCursorVisible(false);
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
        Intent intent = new Intent(context, List2Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    class list1_course_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_course_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            hidekeyboard(course_custom_edit_text);
        }
    }

    class course_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = course_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_course_nextbtn.setEnabled(false);
                course_custom_text.setVisibility(View.VISIBLE);
                course_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            study.setTypeface(typereg);
            employment.setTypeface(typereg);
            transfer.setTypeface(typereg);
            course_custom_edit_text.setTypeface(typebold);

            list1_course_radioGroup1.setOnCheckedChangeListener(null);
            list1_course_radioGroup1.clearCheck();
            list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
            list1_course_radioGroup2.setOnCheckedChangeListener(null);
            list1_course_radioGroup2.clearCheck();
            list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);
            course_custom_text.setVisibility(View.INVISIBLE);
            course_custom_edit_text.setVisibility(View.VISIBLE);
            course_custom_edit_text.setCursorVisible(true);
            course_custom_edit_text.requestFocus();
            showkeyboard(course_custom_edit_text);
            int backcolor = getResources().getColor(R.color.white);
            course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            course_custom_edit_text.setTextColor(backcolor);
        }
    }

    class course_custom_edit_Clicklistener implements OnClickListener {
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
            study.setTypeface(typereg);
            employment.setTypeface(typereg);
            transfer.setTypeface(typereg);
            course_custom_edit_text.setTypeface(typebold);
            list1_course_radioGroup1.setOnCheckedChangeListener(null);
            list1_course_radioGroup1.clearCheck();
            list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
            list1_course_radioGroup2.setOnCheckedChangeListener(null);
            list1_course_radioGroup2.clearCheck();
            list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);
            course_custom_text.setVisibility(View.INVISIBLE);
            course_custom_edit_text.setVisibility(View.VISIBLE);
            course_custom_edit_text.setCursorVisible(true);
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

    private void showkeyboard(EditText edit){
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List1CourseActivity.this, resid,
                "정말 그만두시겠어요?\n아직 하나도 작성하시지 않으셨어요!", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCancelable(true);
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

