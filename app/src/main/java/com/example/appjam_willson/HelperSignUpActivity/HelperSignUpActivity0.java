package com.example.appjam_willson.HelperSignUpActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.HelperStoryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HelperSignUpActivity0 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup helperSU_radioGroup1;
    RadioGroup helperSU_radioGroup2;
    RadioGroup helperSU_radioGroup3;

    Button helperSU_0_btn_next;
    LinearLayout daily_custom_text;
    EditText helperSU_love_edittext; //daily_custom_edit_text
    LinearLayout daily_usercustom_layout;

    LinearLayout list1_daily_backbtn;

    String nowCheck;


    Context context;

    String resName;
    String packName;
    int resid;


    RadioButton btn1;
    RadioButton btn2;
    RadioButton btn3;
    RadioButton btn4;
    RadioButton btn5;
    RadioButton btn6;

    Typeface typebold;
    Typeface typereg;

    int REQUEST_CODE;
    int category;

    TextView text;
    ImageView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up0);

        context= this;


        text = findViewById(R.id.toolbar_text);
        text.setText("헬퍼 가입");
        btn = findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        Button nextbtn = findViewById(R.id.helperSU_0_btn_next);
        ImageView btn_back;


        btn_back = findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new HelperSignUpActivity0.list1_love_backbtn_listener());

        context=this;

        REQUEST_CODE = ((HelperSignUpActivity0) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        btn1 = findViewById(R.id.helperSU_btn_love);
        btn2 = findViewById(R.id.helperSU_btn_dream);
        btn3 = findViewById(R.id.helperSU_btn_mind);
        btn4 = findViewById(R.id.helperSU_btn_relationship);
        btn5 = findViewById(R.id.helperSU_btn_life);
        btn6 = findViewById(R.id.helperSU_btn_etc);

        btn1.setTypeface(typereg);
        btn2.setTypeface(typereg);
        btn3.setTypeface(typereg);
        btn4.setTypeface(typereg);
        btn5.setTypeface(typereg);
        btn6.setTypeface(typereg);



      //  list1_daily_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        //  list1_daily_backbtn.setOnClickListener(new list1_daily_backbtn_listener());

        helperSU_radioGroup1 = findViewById(R.id.helperSU_radioGroup1);
        helperSU_radioGroup1.clearCheck();
        helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
        helperSU_radioGroup2 = findViewById(R.id.helperSU_radioGroup2);
        helperSU_radioGroup2.clearCheck();
        helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
        helperSU_radioGroup3 = findViewById(R.id.helperSU_radioGroup3);
        helperSU_radioGroup3.clearCheck();
        helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);

        helperSU_0_btn_next = findViewById(R.id.helperSU_0_btn_next);
        helperSU_0_btn_next.setOnClickListener(this);


        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (nowCheck){
                    case "연애":
                        category = 1;
                        Intent intent1 = new Intent(context, HelperSignUp1_L_Activity.class);
                        startActivityForResult(intent1,REQUEST_CODE);

                    case "진로":
                        category = 2;
                        Intent intent2 = new Intent(context, HelperSignUp1_C_Activity.class);
                        startActivityForResult(intent2, REQUEST_CODE);

                    case "자존감":
                        category = 3;
                        Intent intent3 = new Intent(context, HelperSignUp1_M_Activity.class);
                        startActivityForResult(intent3,REQUEST_CODE);
                    case "인간관계":
                        category = 4;
                        Intent intent4 = new Intent(context, HelperSignUp1_R_Activity.class);
                        startActivityForResult(intent4,REQUEST_CODE);
                    case "일상":
                        category = 5;
                        Intent intent5 = new Intent(context, HelperSignUp1_D_Activity.class);
                        startActivityForResult(intent5,REQUEST_CODE);
                    case "기타":
                        category = 6;
                        Intent intent6 = new Intent(context, HelperSignUp1_E_Activity.class);
                        startActivityForResult(intent6,REQUEST_CODE);


                }



            }


        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    Bundle bundle = new Bundle();
                    bundle = data.getExtras();
                    HelperRegistModel helperRegistModel = new HelperRegistModel();
                    helperRegistModel.helper.category_idx = category;
                    helperRegistModel.helper.title = bundle.getString("intro");
                    helperRegistModel.helper.categoryList_idx = bundle.getInt("category_id");
                    helperRegistModel.helper.content = bundle.getString("content");
                    helperRegistModel.experience.experience_name = bundle.getStringArray("tags");

                    Call<HelperRegistResponseModel> call_helper = RetrofitService.getInstance().getService().helper_regist_post(ApplicationFields.userToken,helperRegistModel);
                    call_helper.enqueue(retrofitCallback_helperReg);

                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    private Callback<HelperRegistResponseModel> retrofitCallback_helperReg = new Callback<HelperRegistResponseModel>() {

        @Override
        public void onResponse(Call<HelperRegistResponseModel> call, Response<HelperRegistResponseModel> response) {
            HelperRegistResponseModel result = response.body();
            ApplicationFields.myHelper_idx = result.data.helper_idx;


        }
        @Override
        public void onFailure(Call<HelperRegistResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }


    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {


            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_love){
                    RadioButton btn = findViewById(R.id.helperSU_btn_love);
                    nowCheck = btn.getText().toString();
                    btn1.setTypeface(typebold);
                    btn2.setTypeface(typereg);

                }
                else if(checkedId == R.id.helperSU_btn_dream){
                    RadioButton btn = findViewById(R.id.helperSU_btn_dream);
                    nowCheck = btn.getText().toString();
                    btn2.setTypeface(typebold);
                    btn1.setTypeface(typereg);
                }
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
                helperSU_radioGroup3.setOnCheckedChangeListener(null);
                helperSU_radioGroup3.clearCheck();
                helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);


                /*
                 list1_mentality_nextbtn.setEnabled(true);
                hidekeyboard(mentality_custom_edit_text);
                list1_mentality_radioGroup2.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup2.clearCheck();
                list1_mentality_radioGroup2.setOnCheckedChangeListener(radioGroup_mentality_listener2);
                list1_mentality_radioGroup3.setOnCheckedChangeListener(null);
                list1_mentality_radioGroup3.clearCheck();
                list1_mentality_radioGroup3.setOnCheckedChangeListener(radioGroup_mentality_listener3);
                mentality_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);



                 */
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_mind){
                    RadioButton btn = findViewById(R.id.helperSU_btn_mind);
                    nowCheck = btn.getText().toString();
                    btn3.setTypeface(typebold);
                    btn4.setTypeface(typereg);
                }
                else if(checkedId == R.id.helperSU_btn_relationship){
                    RadioButton btn = findViewById(R.id.helperSU_btn_relationship);
                    nowCheck = btn.getText().toString();
                    btn4.setTypeface(typebold);
                    btn3.setTypeface(typereg);
                }
                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup3.setOnCheckedChangeListener(null);
                helperSU_radioGroup3.clearCheck();
                helperSU_radioGroup3.setOnCheckedChangeListener(radioGroup_daily_listener3);

            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroup_daily_listener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.helperSU_btn_life){
                    RadioButton btn = findViewById(R.id.helperSU_btn_life);
                    nowCheck = btn.getText().toString();
                    btn5.setTypeface(typebold);
                    btn6.setTypeface(typereg);
                }
                else if(checkedId == R.id.helperSU_btn_etc){
                    RadioButton btn = findViewById(R.id.helperSU_btn_etc);
                    nowCheck = btn.getText().toString();
                    btn6.setTypeface(typebold);
                    btn5.setTypeface(typereg);
                }
                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);


                helperSU_0_btn_next.setEnabled(true);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);

            }
        }
    };




    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        //if (v.getId() == R.id.helperSU_0_btn_next) {
   //         //선택된 View가 R.id.button1와 같은 ID를 가지고 있다면 해당 로직 실행
    //        Intent intentSU = new Intent(HelperSignUpActivity0.this, HelperSignUpActivity1.class);
      /*      startActivity(intentSU);
        }
*/








        class daily_custom_btn_listener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String title;
                title = helperSU_love_edittext.getText().toString();
                if(title.getBytes().length <= 0) {
                    helperSU_0_btn_next.setEnabled(false);
                    daily_custom_text.setVisibility(View.VISIBLE);
                    helperSU_love_edittext.setVisibility(View.INVISIBLE);
                }

                btn1.setTypeface(typereg);
                btn2.setTypeface(typereg);
                btn3.setTypeface(typereg);
                btn4.setTypeface(typereg);
                btn5.setTypeface(typereg);
                btn6.setTypeface(typereg);
                helperSU_love_edittext.setTypeface(typebold);

                helperSU_radioGroup1.setOnCheckedChangeListener(null);
                helperSU_radioGroup1.clearCheck();
                helperSU_radioGroup1.setOnCheckedChangeListener(radioGroup_daily_listener1);
                helperSU_radioGroup2.setOnCheckedChangeListener(null);
                helperSU_radioGroup2.clearCheck();
                helperSU_radioGroup2.setOnCheckedChangeListener(radioGroup_daily_listener2);
            }
        }


    }}
