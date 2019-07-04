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

public class List1DailyActivity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_daily_radioGroup1;
    RadioGroup list1_daily_radioGroup2;

    Button list1_daily_nextbtn;
    LinearLayout daily_custom_text;
    EditText daily_custom_edit_text;
    LinearLayout daily_usercustom_layout;

    LinearLayout list1_daily_backbtn;
    LinearLayout list1_daily_cancelbtn;

    private CustomDialog dialog;
    Context context;

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_daily);

        context=this;

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list1_daily_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list1_daily_cancelbtn.setOnClickListener(new list1_daily_cancelbtn_listener());

        list1_daily_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_daily_backbtn.setOnClickListener(new list1_daily_backbtn_listener());

        list1_daily_radioGroup1 = (RadioGroup) findViewById(R.id.helperSU_radioGroup1);
        list1_daily_radioGroup1.clearCheck();
        list1_daily_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
        list1_daily_radioGroup2 = (RadioGroup) findViewById(R.id.list1_daily_radioGroup2);
        list1_daily_radioGroup2.clearCheck();
        list1_daily_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);

        list1_daily_nextbtn = (Button) findViewById(R.id.list1_daily_btn_next);
        list1_daily_nextbtn.setOnClickListener(this);

        daily_custom_text = (LinearLayout)findViewById(R.id.list1_daily_btn_usercustom);
        daily_custom_text.setOnClickListener(new daily_custom_btn_listener());

        daily_custom_edit_text = (EditText)findViewById(R.id.list1_daily_usercustom_edittext);
        daily_custom_edit_text.setOnClickListener(new daily_custom_edit_Clicklistener());
        daily_custom_edit_text.setOnKeyListener(new daily_custom_edit_listener());

        daily_usercustom_layout = (LinearLayout)findViewById(R.id.list1_daily_btn_usercustom_layout);

    }

    private OnCheckedChangeListener radioGroup_daily_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                list1_daily_nextbtn.setEnabled(true);
                hidekeyboard(daily_custom_edit_text);
                list1_daily_radioGroup2.setOnCheckedChangeListener(null);
                list1_daily_radioGroup2.clearCheck();
                list1_daily_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
                daily_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                daily_custom_edit_text.setTextColor(backcolor);
                String title;
                title = daily_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    daily_custom_text.setVisibility(View.VISIBLE);
                    daily_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_daily_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_daily_nextbtn.setEnabled(true);
                hidekeyboard(daily_custom_edit_text);
                list1_daily_radioGroup1.setOnCheckedChangeListener(null);
                list1_daily_radioGroup1.clearCheck();
                list1_daily_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                daily_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                daily_custom_edit_text.setTextColor(backcolor);
                String title;
                title = daily_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    daily_custom_text.setVisibility(View.VISIBLE);
                    daily_custom_edit_text.setVisibility(View.INVISIBLE);
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

    class list1_daily_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_daily_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }


    class daily_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = daily_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_daily_nextbtn.setEnabled(false);
                daily_custom_text.setVisibility(View.VISIBLE);
                daily_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            list1_daily_radioGroup1.setOnCheckedChangeListener(null);
            list1_daily_radioGroup1.clearCheck();
            list1_daily_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
            list1_daily_radioGroup2.setOnCheckedChangeListener(null);
            list1_daily_radioGroup2.clearCheck();
            list1_daily_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
            daily_custom_text.setVisibility(View.INVISIBLE);
            daily_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            daily_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            daily_custom_edit_text.setTextColor(backcolor);
        }
    }

    class daily_custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = daily_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_daily_nextbtn.setEnabled(false);
                daily_custom_text.setVisibility(View.VISIBLE);
                daily_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_daily_nextbtn.setEnabled(true);
            }
            list1_daily_radioGroup1.setOnCheckedChangeListener(null);
            list1_daily_radioGroup1.clearCheck();
            list1_daily_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
            list1_daily_radioGroup2.setOnCheckedChangeListener(null);
            list1_daily_radioGroup2.clearCheck();
            list1_daily_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
            daily_custom_text.setVisibility(View.INVISIBLE);
            daily_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            daily_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            daily_custom_edit_text.setTextColor(backcolor);
        }
    }

    class daily_custom_edit_listener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    int backcolor = getResources().getColor(R.color.white);
                    daily_custom_edit_text.setTextColor(backcolor);
                    hidekeyboard(daily_custom_edit_text);
            }
            return false;
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    public void Dialog() {
        dialog = new CustomDialog(List1DailyActivity.this, resid,
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
