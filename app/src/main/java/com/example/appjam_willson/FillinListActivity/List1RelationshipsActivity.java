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

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class List1RelationshipsActivity extends AppCompatActivity implements OnClickListener {

    RadioGroup list1_relationships_radioGroup1;
    RadioGroup list1_relationships_radioGroup2;

    Button list1_relationships_nextbtn;
    LinearLayout relationships_custom_text;
    EditText relationships_custom_edit_text;
    LinearLayout relationships_usercustom_layout;

    LinearLayout list1_relationships_backbtn;
    LinearLayout list1_relationships_cancelbtn;

    private CustomDialog dialog;
    Context context;

    String resName;
    String packName;
    int resid;

    RadioButton family;
    RadioButton friend;
    RadioButton companion;
    RadioButton junior;

    Typeface typebold;
    Typeface typereg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_relationships);

        context = this;

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        family = (RadioButton) findViewById(R.id.list1_btn_onesidelove);
        friend = (RadioButton) findViewById(R.id.list1_btn_somthing);
        companion = (RadioButton) findViewById(R.id.list1_btn_conflict);
        junior = (RadioButton) findViewById(R.id.list1_btn_saygoodbye);

        family.setTypeface(typereg);
        friend.setTypeface(typereg);
        companion.setTypeface(typereg);
        junior.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list1_relationships_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list1_relationships_cancelbtn.setOnClickListener(new list1_relationships_cancelbtn_listener());

        list1_relationships_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list1_relationships_backbtn.setOnClickListener(new list1_relationships_backbtn_listener());


        list1_relationships_radioGroup1 = (RadioGroup) findViewById(R.id.list1_relationships_radioGroup1);
        list1_relationships_radioGroup1.clearCheck();
        list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
        list1_relationships_radioGroup2 = (RadioGroup) findViewById(R.id.list1_relationships_radioGroup2);
        list1_relationships_radioGroup2.clearCheck();
        list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);

        list1_relationships_nextbtn = (Button) findViewById(R.id.list1_relationships_btn_next);
        list1_relationships_nextbtn.setOnClickListener(this);

        relationships_custom_text = (LinearLayout)findViewById(R.id.list1_relationships_btn_usercustom);
        relationships_custom_text.setOnClickListener(new relationships_custom_btn_listener());

        relationships_custom_edit_text = (EditText)findViewById(R.id.list1_relationships_usercustom_edittext);
        relationships_custom_edit_text.setOnClickListener(new relationships_custom_edit_Clicklistener());
        relationships_custom_edit_text.setOnKeyListener(new relationships_custom_edit_listener());
        relationships_custom_edit_text.setTypeface(typebold);

        relationships_usercustom_layout = (LinearLayout)findViewById(R.id.list1_relationships_btn_usercustom_layout);
    }

    private OnCheckedChangeListener radioGroup_relationships_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.list1_relationships_btn_family){
                    family.setTypeface(typebold);
                    friend.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_relationships_btn_friends){
                    friend.setTypeface(typebold);
                    family.setTypeface(typereg);
                }
                companion.setTypeface(typereg);
                junior.setTypeface(typereg);
                relationships_custom_edit_text.setTypeface(typereg);

                list1_relationships_nextbtn.setEnabled(true);
                hidekeyboard(relationships_custom_edit_text);
                list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
                list1_relationships_radioGroup2.clearCheck();
                list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
                relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                relationships_custom_edit_text.setTextColor(backcolor);
                String title;
                title = relationships_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    relationships_custom_text.setVisibility(View.VISIBLE);
                    relationships_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_relationships_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {

                if(checkedId == R.id.list1_relationships_btn_companion){
                    companion.setTypeface(typebold);
                    junior.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_relationships_btn_junior){
                    friend.setTypeface(typebold);
                    junior.setTypeface(typereg);
                }
                family.setTypeface(typereg);
                friend.setTypeface(typereg);
                relationships_custom_edit_text.setTypeface(typereg);

                list1_relationships_nextbtn.setEnabled(true);
                hidekeyboard(relationships_custom_edit_text);
                list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
                list1_relationships_radioGroup1.clearCheck();
                list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
                relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                relationships_custom_edit_text.setTextColor(backcolor);
                String title;
                title = relationships_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    relationships_custom_text.setVisibility(View.VISIBLE);
                    relationships_custom_edit_text.setVisibility(View.INVISIBLE);
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

    class list1_relationships_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_relationships_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class relationships_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = relationships_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_relationships_nextbtn.setEnabled(false);
                relationships_custom_text.setVisibility(View.VISIBLE);
                relationships_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            family.setTypeface(typereg);
            friend.setTypeface(typereg);
            companion.setTypeface(typereg);
            junior.setTypeface(typereg);
            relationships_custom_edit_text.setTypeface(typebold);

            list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup1.clearCheck();
            list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
            list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup2.clearCheck();
            list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
            relationships_custom_text.setVisibility(View.INVISIBLE);
            relationships_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            relationships_custom_edit_text.setTextColor(backcolor);
        }
    }

    class relationships_custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = relationships_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_relationships_nextbtn.setEnabled(false);
                relationships_custom_text.setVisibility(View.VISIBLE);
                relationships_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_relationships_nextbtn.setEnabled(true);
            }
            family.setTypeface(typereg);
            friend.setTypeface(typereg);
            companion.setTypeface(typereg);
            junior.setTypeface(typereg);
            relationships_custom_edit_text.setTypeface(typebold);

            list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup1.clearCheck();
            list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
            list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup2.clearCheck();
            list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
            relationships_custom_text.setVisibility(View.INVISIBLE);
            relationships_custom_edit_text.setVisibility(View.VISIBLE);
            int backcolor = getResources().getColor(R.color.white);
            relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            relationships_custom_edit_text.setTextColor(backcolor);
        }
    }

    class relationships_custom_edit_listener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    int backcolor = getResources().getColor(R.color.white);
                    relationships_custom_edit_text.setTextColor(backcolor);
                    hidekeyboard(relationships_custom_edit_text);
            }
            return false;
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    public void Dialog() {
        dialog = new CustomDialog(List1RelationshipsActivity.this, resid,
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
