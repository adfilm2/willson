package com.example.appjam_willson.HelperSignUpActivity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
// public class HelperSignUpActivity1 extends AppCompatActivity implements View.OnClickListener {


public class HelperSignUpActivity1 extends AppCompatActivity {
//다음버튼에 액티비티 2 와 연결 해야함

    int REQUEST_CODE;

    RadioGroup radioGroup_1;
    RadioGroup radioGroup_2;
    Button nextbtn;
    LinearLayout custom_text;
    EditText custom_edit_text;
    LinearLayout usercustom_layout;
    LinearLayout background;
    LinearLayout backbtn;

    RadioButton oneside;
    RadioButton some;
    RadioButton conflict;
    RadioButton saygoodbye;


    Context context;

    Bundle bundle1 = new Bundle();

    Typeface typebold;
    Typeface typereg;

    int small_category;
   /* EditText edit;
    TextView HSUtextview;
    LinearLayout HSU_usercustom_layout;
    String title;*/

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;

    HelperRegistModel helperRegistModel;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up1);

        context = this;
        REQUEST_CODE = ((HelperSignUpActivity1) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        ImageView btn;
        nextbtn = findViewById(R.id.HelperSU_btn_next);
        nextbtn.setOnClickListener(new next_btn_listener());

        backbtn = findViewById(R.id.back_btn_layout);
        backbtn.setOnClickListener(new backbtn_listener());

        btn = findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        radioGroup_1 = findViewById(R.id.radioGroup1);
        radioGroup_2 = findViewById(R.id.radioGroup2);
        radioGroup_1.clearCheck();
        radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
        radioGroup_2.clearCheck();
        radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);

        oneside = findViewById(R.id.btn_onesidelove);
        some = findViewById(R.id.btn_somthing);
        conflict = findViewById(R.id.btn_conflict);
        saygoodbye = findViewById(R.id.btn_saygoodbye);

        oneside.setTypeface(typereg);
        some.setTypeface(typereg);
        conflict.setTypeface(typereg);
        saygoodbye.setTypeface(typereg);

        custom_text = findViewById(R.id.btn_user_custom_layout);
        custom_text.setOnClickListener(new custom_btn_listener());

        usercustom_layout = findViewById(R.id.btn_user_custom_layout);

        background = findViewById(R.id.background);
        background.setOnClickListener(new background_listener());

        custom_edit_text = findViewById(R.id.usercustom_edittext);
        custom_edit_text.setOnClickListener(new custom_edit_Clicklistener());
        custom_edit_text.setOnKeyListener(new custom_edit_listener());
        custom_edit_text.setTypeface(typebold);



       /* edit = (EditText)findViewById(R.id.edit);
        HSUtextview=(TextView)findViewById(R.id.HSUtextview);

        HSU_usercustom_layout =(LinearLayout)findViewById(R.id.HSU_usercustom_layout);*/






       /* button1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button1.setBackgroundResource(R.drawable.helpersignupbackground);
                button1.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);

                HSU_usercustom_layout.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                title = edit.getText().toString();
                if(title.getBytes().length <= 0) {
                    HSUtextview.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.INVISIBLE);
                    HSUtextview.setTextColor(getColor(R.color.lightPurple));
                }
                else{
                    edit.setVisibility(View.VISIBLE);
                    HSUtextview.setVisibility(View.INVISIBLE);
                    edit.setTextColor(getColor(R.color.lightPurple));
                }




            }



        });
        button2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button2.setBackgroundResource(R.drawable.helpersignupbackground);
                button2.setTextColor(getColor(R.color.white));
                button1.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);



                HSU_usercustom_layout.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                title = edit.getText().toString();
                if(title.getBytes().length <= 0) {
                    HSUtextview.setVisibility(View.VISIBLE);edit.setVisibility(View.INVISIBLE);HSUtextview.setTextColor(getColor(R.color.lightPurple));
                }
                else{
                    edit.setVisibility(View.VISIBLE);HSUtextview.setVisibility(View.INVISIBLE);edit.setTextColor(getColor(R.color.lightPurple));
                }





            }
        });

        button3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button3.setBackgroundResource(R.drawable.helpersignupbackground);
                button3.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button1.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);



                HSU_usercustom_layout.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                title = edit.getText().toString();
                if(title.getBytes().length <= 0) {
                    HSUtextview.setVisibility(View.VISIBLE);edit.setVisibility(View.INVISIBLE);HSUtextview.setTextColor(getColor(R.color.lightPurple));
                }
                else{
                    edit.setVisibility(View.VISIBLE);HSUtextview.setVisibility(View.INVISIBLE);edit.setTextColor(getColor(R.color.lightPurple));
                }



            }
        });

        button4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button4.setBackgroundResource(R.drawable.helpersignupbackground);
                button4.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button1.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);


                HSU_usercustom_layout.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                title = edit.getText().toString();
                if(title.getBytes().length <= 0) {
                    HSUtextview.setVisibility(View.VISIBLE);edit.setVisibility(View.INVISIBLE);HSUtextview.setTextColor(getColor(R.color.lightPurple));
                }
                else{
                    edit.setVisibility(View.VISIBLE);HSUtextview.setVisibility(View.INVISIBLE);edit.setTextColor(getColor(R.color.lightPurple));
                }


            }
        });


        HSUtextview.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {

                showkeyboard(edit);
                nextbtn.setEnabled(true);

                HSUtextview.setVisibility(View.INVISIBLE);
                edit.setVisibility(View.VISIBLE);

                //눌리면 파란색 글자수 있으면 파란색
                edit.setTextColor(getColor(R.color.white));
                HSU_usercustom_layout.setBackgroundResource(R.drawable.helpersignupbackground);




                button1.setTextColor(getColor(R.color.lightPurple));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);


            }
        });*/

    }

    public class next_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(oneside.isChecked()){
                small_category = 1;
            }
            else if (some.isChecked()){
                small_category = 2;
            }
            else if (conflict.isChecked()){
                small_category = 3;
            }
            else if (saygoodbye.isChecked()){
                small_category = 4;
            }
            else if (custom_edit_text.isFocused()){
                //통신
                WorryCategoryListAddModel worryCategoryListAddModel = new WorryCategoryListAddModel();
                worryCategoryListAddModel.category_idx = 2;
                worryCategoryListAddModel.categoryList_name = custom_edit_text.getText().toString();

                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";


                Call<WorryCategoryListAddResponseModel> call_helper = RetrofitService.getInstance().getService().concern_category_list_post(token,worryCategoryListAddModel);

                call_helper.enqueue(new Callback<WorryCategoryListAddResponseModel>() {
                    @Override
                    public void onResponse(Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
                        Log.d("test", response.isSuccessful() + "");
                        WorryCategoryListAddResponseModel result = response.body();
                        Log.d("진로", ">>>>>>>>>>>" + response.code());
                        Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.code);
                        small_category= result.data.categoryList_idx;


                        Log.d(">>>>>리스트 아이디 ",""+small_category);
                        Intent intent = new Intent(context, HelperSignUpActivity2.class);
                        startActivityForResult(intent, REQUEST_CODE);

                    }

                    @Override
                    public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                        t.printStackTrace();
                        Log.d(" 진로 액티비티 실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                    }


                });



            }
            else{}

            Intent intentProfileEdit = new Intent(context, HelperSignUpActivity2.class);
            startActivityForResult(intentProfileEdit,REQUEST_CODE);
        }
    }

    private RadioGroup.OnCheckedChangeListener radioGroup_listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.btn_onesidelove){
                    oneside.setTypeface(typebold);
                    some.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_somthing){
                    some.setTypeface(typebold);
                    oneside.setTypeface(typereg);
                }
                conflict.setTypeface(typereg);
                saygoodbye.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);
                radioGroup_2.setOnCheckedChangeListener(null);
                radioGroup_2.clearCheck();
                radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
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

    private RadioGroup.OnCheckedChangeListener radioGroup_listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                nextbtn.setEnabled(true);
                hidekeyboard(custom_edit_text);
                if(checkedId == R.id.btn_conflict){
                    conflict.setTypeface(typebold);
                    saygoodbye.setTypeface(typereg);
                }
                else if(checkedId == R.id.btn_saygoodbye){
                    saygoodbye.setTypeface(typebold);
                    conflict.setTypeface(typereg);
                }
                oneside.setTypeface(typereg);
                some.setTypeface(typereg);
                custom_edit_text.setTypeface(typereg);
                custom_edit_text.setCursorVisible(false);
                radioGroup_1.setOnCheckedChangeListener(null);
                radioGroup_1.clearCheck();
                radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
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

    class backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            /*Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);*/
            finish();
        }
    }

    class background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (custom_edit_text.isFocused()) {
                String title;
                title = custom_edit_text.getText().toString();
                if (title.getBytes().length <= 0) {
                    nextbtn.setEnabled(false);
                    custom_text.setVisibility(View.VISIBLE);
                    custom_edit_text.setVisibility(View.INVISIBLE);
                    usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                } else {
                    nextbtn.setEnabled(true);
                }
                hidekeyboard(custom_edit_text);
                custom_edit_text.setCursorVisible(false);
            }
        }
    }

    class custom_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            oneside.setTypeface(typereg);
            some.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            radioGroup_1.setOnCheckedChangeListener(null);
            radioGroup_1.clearCheck();
            radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
            radioGroup_2.setOnCheckedChangeListener(null);
            radioGroup_2.clearCheck();
            radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
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

    class custom_edit_Clicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                nextbtn.setEnabled(false);
                custom_text.setVisibility(View.VISIBLE);
                custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                nextbtn.setEnabled(true);
            }
            conflict.setTypeface(typereg);
            saygoodbye.setTypeface(typereg);
            oneside.setTypeface(typereg);
            some.setTypeface(typereg);
            custom_edit_text.setTypeface(typebold);
            radioGroup_1.setOnCheckedChangeListener(null);
            radioGroup_1.clearCheck();
            radioGroup_1.setOnCheckedChangeListener(radioGroup_listener1);
            radioGroup_2.setOnCheckedChangeListener(null);
            radioGroup_2.clearCheck();
            radioGroup_2.setOnCheckedChangeListener(radioGroup_listener2);
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
                        nextbtn.setEnabled(false);
                        custom_text.setVisibility(View.VISIBLE);
                        custom_edit_text.setVisibility(View.INVISIBLE);
                        usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    custom_edit_text.setCursorVisible(false);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle1 = data.getExtras();
                    bundle1.putString("category","연애");
                    bundle1.putInt("small category",small_category);

                    data.putExtras(bundle1);
                    setResult(RESULT_OK,data);

                    Log.d("msg","bundle test"+bundle1);

/*
                    retrofit = new Retrofit.Builder()
                            .baseUrl("http://13.125.216.169/api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    retrofitAPI = retrofit.create(RetrofitAPI.class);*/

                    HelperRegistModel helperRegistModel = new HelperRegistModel();
                    helperRegistModel.helper.title = data.getStringExtra("intro");
                    //helperRegistModel.helper.category_name = "ㅋㅋㅋ";
                    helperRegistModel.helper.category_name = data.getStringExtra("category");
                    helperRegistModel.helper.categoryList_name =  data.getStringExtra("small category");
                    helperRegistModel.helper.content = data.getStringExtra("content");

                    String[] tt = {data.getStringExtra("tag1"), data.getStringExtra("tag2"), data.getStringExtra("tag3")};
                    helperRegistModel.experience.experience_name = tt;

                    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3Njc4OTcsImV4cCI6MTU3MTQwNzg5NywiaXNzIjoid2lsbHNvbiJ9.VX9-dSw1vzLO7j94UsqOnw6kA3-PeNFp8dic_jHtUt0";

                    Call<HelperRegistResponseModel> call_helper = RetrofitService.getInstance().getService().helper_regist_post(token, helperRegistModel);

                    call_helper.enqueue(new Callback<HelperRegistResponseModel>() {
                        @Override
                        public void onResponse(Call<HelperRegistResponseModel> call, Response<HelperRegistResponseModel> response) {
                            Log.d("test", response.isSuccessful() + "");
                            HelperRegistResponseModel result = response.body();
                            Log.d("response code", ">>>>>>>>>>>>>>>>>>>>>>" + response.code());
                           // Log.d("코드값", ">>>>>>>>>>>>>>>>>>>>>>" + result.code);



                        }

                        @Override
                        public void onFailure(Call<HelperRegistResponseModel> call, Throwable t) {
                            t.printStackTrace();
                            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                        }
                    });

                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //이곳에 버튼 클릭시 일어날 일을 적습니다.
        }
    };
}






