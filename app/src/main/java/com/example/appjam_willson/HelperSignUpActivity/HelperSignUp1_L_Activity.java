package com.example.appjam_willson.HelperSignUpActivity;


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

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperSignUp1_L_Activity extends AppCompatActivity implements OnClickListener {

    int REQUEST_CODE;

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

    Bundle bundle = new Bundle();
    int category_listId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_love);

        context = this;

        REQUEST_CODE = ((HelperSignUp1_L_Activity) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        onesidelove = findViewById(R.id.list1_btn_onesidelove);
        somthing = findViewById(R.id.list1_btn_somthing);
        conflict = findViewById(R.id.list1_btn_conflict);
        saygoodbye = findViewById(R.id.list1_btn_saygoodbye);

        conflict.setTypeface(typereg);
        saygoodbye.setTypeface(typereg);
        onesidelove.setTypeface(typereg);
        somthing.setTypeface(typereg);

        resName = "@drawable/request_couldnt_find";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list1_love_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list1_love_cancelbtn.setOnClickListener(new list1_love_cancelbtn_listener());

        list1_love_backbtn = findViewById(R.id.back_btn_layout);
        list1_love_backbtn.setOnClickListener(new list1_love_backbtn_listener());

        list1_radioGroup1 = findViewById(R.id.list1_radioGroup1);
        list1_radioGroup1.clearCheck();
        list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
        list1_radioGroup2 = findViewById(R.id.list1_radioGroup2);
        list1_radioGroup2.clearCheck();
        list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);

        list1_nextbtn = findViewById(R.id.list1_btn_next);
        list1_nextbtn.setOnClickListener(this);

        custom_text = findViewById(R.id.list1_btn_usercustom);
        custom_text.setOnClickListener(new custom_btn_listener());

        custom_edit_text = findViewById(R.id.list1_usercustom_edittext);
        custom_edit_text.setOnClickListener(new custom_edit_Clicklistener());
        custom_edit_text.setOnKeyListener(new custom_edit_listener());
        custom_edit_text.setTypeface(typebold);

        usercustom_layout = findViewById(R.id.list1_btn_usercustom_layout);

        background = findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle = data.getExtras();
                    bundle.putInt("categoryList_idx",category_listId);
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
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
                int backcolor = getResources().getColor(R.color.lightBlue);
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
                int backcolor = getResources().getColor(R.color.lightBlue);
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

        if(onesidelove.isChecked()){
            category_listId = 1;
            Intent intent = new Intent(context,HelperSignUpActivity2.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if (somthing.isChecked()){
            category_listId = 2;
            Intent intent = new Intent(context,HelperSignUpActivity2.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if (conflict.isChecked()){
            category_listId = 3;
            Intent intent = new Intent(context,HelperSignUpActivity2.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if (saygoodbye.isChecked()){
            category_listId = 4;
            Intent intent = new Intent(context,HelperSignUpActivity2.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        else if (custom_edit_text.isFocused()){
            WorryCategoryListAddModel worryCategoryListAddModel = new WorryCategoryListAddModel();
            worryCategoryListAddModel.category_idx = 1;
            worryCategoryListAddModel.categoryList_name = custom_edit_text.getText().toString();

            String token = ApplicationFields.userToken;
            Call<WorryCategoryListAddResponseModel> call_helper = RetrofitService.getInstance().getService().concern_category_list_post(token,worryCategoryListAddModel);
            call_helper.enqueue(new Callback<WorryCategoryListAddResponseModel>() {
                @Override
                public void onResponse(Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
                    WorryCategoryListAddResponseModel result = response.body();
                    category_listId= result.data.categoryList_idx;

                    Intent intent = new Intent(context,HelperSignUpActivity2.class);
                    startActivityForResult(intent, REQUEST_CODE);

                }

                @Override
                public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
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
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            if (custom_edit_text.isFocused()) {
                String title;
                title = custom_edit_text.getText().toString();
                if (title.getBytes().length <= 0) {
                    list1_nextbtn.setEnabled(false);
                    custom_text.setVisibility(View.VISIBLE);
                    custom_edit_text.setVisibility(View.INVISIBLE);
                    usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                } else {
                    list1_nextbtn.setEnabled(true);
                }
                hidekeyboard(custom_edit_text);
                custom_edit_text.setCursorVisible(false);
            }
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
                    hidekeyboard(custom_edit_text);
                    String title;
                    title = custom_edit_text.getText().toString();
                    if(title.getBytes().length <= 0) {
                        list1_nextbtn.setEnabled(false);
                        custom_text.setVisibility(View.VISIBLE);
                        custom_edit_text.setVisibility(View.INVISIBLE);
                        usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    custom_edit_text.setCursorVisible(false);
            }
            return false;
        }
    }

    private Callback<WorryCategoryListAddResponseModel> retrofitCallback = new Callback<WorryCategoryListAddResponseModel>() {

        @Override
        public void onResponse(retrofit2.Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
            WorryCategoryListAddResponseModel result = response.body();
            if(response.isSuccessful()){
                category_listId= result.data.categoryList_idx;
                Intent intent = new Intent(context,HelperSignUpActivity2.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
            else{
            }

        }

        @Override
        public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
            t.printStackTrace();

        }
    };

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    private void showkeyboard(EditText edit){
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(HelperSignUp1_L_Activity.this, resid,
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
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    };

}