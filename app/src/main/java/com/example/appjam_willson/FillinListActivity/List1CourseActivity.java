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

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


    Bundle bundle1 = new Bundle();
    int category_listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_course);

        context = this;

        REQUEST_CODE = ((List1CourseActivity) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        study = findViewById(R.id.list1_course_btn_study);
        employment = findViewById(R.id.list1_course_btn_employment);
        transfer = findViewById(R.id.list1_course_btn_transfer);

        study.setTypeface(typereg);
        employment.setTypeface(typereg);
        transfer.setTypeface(typereg);

        resName = "@drawable/request_couldnt_find";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list1_course_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list1_course_cancelbtn.setOnClickListener(new list1_course_cancelbtn_listener());

        list1_course_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list1_course_backbtn.setOnClickListener(new list1_course_backbtn_listener());

        list1_course_radioGroup1 = findViewById(R.id.list1_course_radioGroup1);
        list1_course_radioGroup1.clearCheck();
        list1_course_radioGroup1.setOnCheckedChangeListener(radioGroup_course_listener1);
        list1_course_radioGroup2 = findViewById(R.id.list1_course_radioGroup2);
        list1_course_radioGroup2.clearCheck();
        list1_course_radioGroup2.setOnCheckedChangeListener(radioGroup_course_listener2);

        list1_course_nextbtn = findViewById(R.id.list1_course_btn_next);
        list1_course_nextbtn.setOnClickListener(this);

        course_custom_text = findViewById(R.id.list1_course_btn_usercustom);
        course_custom_text.setOnClickListener(new course_custom_btn_listener());

        course_custom_edit_text = findViewById(R.id.list1_course_usercustom_edittext);
        course_custom_edit_text.setOnClickListener(new course_custom_edit_Clicklistener());
        course_custom_edit_text.setOnKeyListener(new course_custom_edit_listener());
        course_custom_edit_text.setTypeface(typebold);

        course_usercustom_layout = findViewById(R.id.list1_course_btn_usercustom_layout);

        background = findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:

                    bundle1 = data.getExtras();
                    bundle1.putInt("categoryList_idx",category_listId);
                    data.putExtras(bundle1);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
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
                int backcolor = getResources().getColor(R.color.lightBlue);
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
                int backcolor = getResources().getColor(R.color.lightBlue);
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
        if(study.isChecked()){
            category_listId = 5;
        }
        else if (employment.isChecked()){
            category_listId = 6;
        }
        else if (transfer.isChecked()){
            category_listId = 7;
        }
        else if (course_custom_edit_text.isFocused()){
            //통신
            WorryCategoryListAddModel worryCategoryListAddModel = new WorryCategoryListAddModel();
            worryCategoryListAddModel.category_idx = 2;
            worryCategoryListAddModel.categoryList_name = course_custom_edit_text.getText().toString();


            String token = ApplicationFields.userToken;

            Call<WorryCategoryListAddResponseModel> call_helper = RetrofitService.getInstance().getService().concern_category_list_post(token,worryCategoryListAddModel);

            call_helper.enqueue(new Callback<WorryCategoryListAddResponseModel>() {
                @Override
                public void onResponse(Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
                    WorryCategoryListAddResponseModel result = response.body();
                    category_listId= result.data.categoryList_idx;
                }

                @Override
                public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                    t.printStackTrace();
                }


            });


        }
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
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            if(course_custom_edit_text.isFocused()){
                String title;
                title = course_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    list1_course_nextbtn.setEnabled(false);
                    course_custom_text.setVisibility(View.VISIBLE);
                    course_custom_edit_text.setVisibility(View.INVISIBLE);
                    course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                }
                else{
                    list1_course_nextbtn.setEnabled(true);
                }
                hidekeyboard(course_custom_edit_text);
                course_custom_edit_text.setCursorVisible(false);
            }
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
                    String title;
                    title = course_custom_edit_text.getText().toString();
                    if(title.getBytes().length <= 0) {
                        list1_course_nextbtn.setEnabled(false);
                        course_custom_text.setVisibility(View.VISIBLE);
                        course_custom_edit_text.setVisibility(View.INVISIBLE);
                        course_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    hidekeyboard(course_custom_edit_text);
                    course_custom_edit_text.setCursorVisible(false);
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

        dialog.setCanceledOnTouchOutside(false);

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
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    };

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("result", "BACK");
        setResult(REQUEST_CODE, intent);
        finish();
    }

}

