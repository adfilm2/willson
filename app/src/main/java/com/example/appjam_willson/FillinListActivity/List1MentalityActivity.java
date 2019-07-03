package com.example.appjam_willson.FillinListActivity;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class List1MentalityActivity extends AppCompatActivity implements OnClickListener{

    RadioGroup list1_mentality_radioGroup1;
    RadioGroup list1_mentality_radioGroup2;
    RadioGroup list1_mentality_radioGroup3;

    Button list1_mentality_nextbtn;
    LinearLayout mentality_custom_text;
    EditText mentality_custom_edit_text;
    LinearLayout mentality_usercustom_layout;

    LinearLayout list1_mentality_backbtn;
    LinearLayout list1_mentality_cancelbtn;

    private CustomDialog dialog;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_mentality);

        context = this;

        list1_mentality_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list1_mentality_cancelbtn.setOnClickListener(new list1_mentality_cancelbtn_listener());

        list1_mentality_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_mentality_backbtn.setOnClickListener(new list1_mentality_backbtn_listener());

        list1_mentality_radioGroup1 = (RadioGroup)findViewById(R.id.list1_mentality_radioGroup1);
        list1_mentality_radioGroup1.clearCheck();
        list1_mentality_radioGroup1.setOnCheckedChangeListener(radioGroup_mentality_listener1);
        list1_mentality_radioGroup2 = (RadioGroup)findViewById(R.id.list1_mentality_radioGroup2);
        list1_mentality_radioGroup2.clearCheck();
        list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
        list1_mentality_radioGroup3 = (RadioGroup)findViewById(R.id.list1_mentality_radioGroup3);
        list1_mentality_radioGroup3.clearCheck();
        list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);

        list1_mentality_nextbtn = (Button) findViewById(R.id.list1_mentality_btn_next);
        list1_mentality_nextbtn.setOnClickListener(this);

        mentality_custom_text = (LinearLayout)findViewById(R.id.list1_mentality_btn_usercustom);
        mentality_custom_text.setOnClickListener(new mentality_custom_btn_listener());

        mentality_custom_edit_text = (EditText)findViewById(R.id.list1_mentality_usercustom_edittext);
        mentality_custom_edit_text.setOnClickListener(new mentality_custom_edit_Clicklistener());
        mentality_custom_edit_text.setOnKeyListener(new mentality_custom_edit_listener());

        mentality_usercustom_layout = (LinearLayout)findViewById(R.id.list1_mentality_btn_usercustom_layout);
    }

    private OnCheckedChangeListener radioGroup_mentality_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                list1_mentality_nextbtn.setEnabled(true);
                hidekeyboard(mentality_custom_edit_text);
                list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup2.clearCheck();
                list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
                list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup3.clearCheck();
                list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
                mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                mentality_custom_edit_text.setTextColor(backcolor);
                String title;
                title = mentality_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    mentality_custom_text.setVisibility(View.VISIBLE);
                    mentality_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_mentality_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_mentality_nextbtn.setEnabled(true);
                hidekeyboard(mentality_custom_edit_text);
                list1_mentality_radioGroup1.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup1.clearCheck();
                list1_mentality_radioGroup1.setOnCheckedChangeListener(radioGroup_mentality_listener1);
                list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup3.clearCheck();
                list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
                mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                mentality_custom_edit_text.setTextColor(backcolor);
                String title;
                title = mentality_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    mentality_custom_text.setVisibility(View.VISIBLE);
                    mentality_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_mentality_listener3 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_mentality_nextbtn.setEnabled(true);
                hidekeyboard(mentality_custom_edit_text);
                list1_mentality_radioGroup1.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup1.clearCheck();
                list1_mentality_radioGroup1.setOnCheckedChangeListener(radioGroup_mentality_listener1);
                list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup2.clearCheck();
                list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
                mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                mentality_custom_edit_text.setTextColor(backcolor);
                String title;
                title = mentality_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    mentality_custom_text.setVisibility(View.VISIBLE);
                    mentality_custom_edit_text.setVisibility(View.INVISIBLE);
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

    class list1_mentality_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_mentality_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class mentality_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = mentality_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_mentality_nextbtn.setEnabled(false);
                mentality_custom_text.setVisibility(View.VISIBLE);
                mentality_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            list1_mentality_radioGroup1.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup1.clearCheck();
            list1_mentality_radioGroup1.setOnCheckedChangeListener(radioGroup_mentality_listener1);
            list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup2.clearCheck();
            list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
            list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup3.clearCheck();
            list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
            mentality_custom_text.setVisibility(View.INVISIBLE);
            mentality_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            mentality_custom_edit_text.setTextColor(backcolor);
        }
    }
    class mentality_custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = mentality_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_mentality_nextbtn.setEnabled(false);
                mentality_custom_text.setVisibility(View.VISIBLE);
                mentality_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_mentality_nextbtn.setEnabled(true);
            }
            list1_mentality_radioGroup1.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup1.clearCheck();
            list1_mentality_radioGroup1.setOnCheckedChangeListener(radioGroup_mentality_listener1);
            list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup2.clearCheck();
            list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
            list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
            list1_mentality_radioGroup3.clearCheck();
            list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
            mentality_custom_text.setVisibility(View.INVISIBLE);
            mentality_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            mentality_custom_edit_text.setTextColor(backcolor);
        }
    }

    class mentality_custom_edit_listener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    int backcolor = getResources().getColor(R.color.white);
                    mentality_custom_edit_text.setTextColor(backcolor);
                    hidekeyboard(mentality_custom_edit_text);
            }
            return false;
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    public void Dialog() {
        dialog = new CustomDialog(List1MentalityActivity.this,
                "정말 그만두시겠어요?\n아직 하나도 작성하시지 않으셨어요!", keepListener, exitListener);

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