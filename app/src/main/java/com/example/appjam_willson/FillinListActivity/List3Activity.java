package com.example.appjam_willson.FillinListActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

public class List3Activity extends AppCompatActivity {

    int REQUEST_CODE;

    Button btnNext;     // 버튼
    Context context;    // Intent 객체 생성 시 넘길 프로퍼티( 현재객체 맥락 )
    LinearLayout list3_cancelbtn;
    LinearLayout list3_backbtn;

    private RadioButton r_btn1, r_btn2, r_btn3, r_btn4 ,r_btn5;
    private RadioGroup radioGroup;

    private OneTextTwoButton_CustomDialog dialog;

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list3_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list3_cancelbtn.setOnClickListener(new list3_cancelbtn_listener());

        list3_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list3_backbtn.setOnClickListener(new list3_backbtn_listener());

        radioGroup = (RadioGroup) findViewById(R.id.list3_radiogroup);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(radioGroup_listener);

        context = this;
        REQUEST_CODE = ((List3Activity) context).getTaskId();

        btnNext = findViewById(R.id.list3_btn1);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent 객체생성
                Intent intent = new Intent(context, List4Activity.class);
                //Activity 실행메소드
                startActivityForResult(intent, REQUEST_CODE);

            }
        });




        //라디오 버튼 설정
        //r_btn1 = (RadioButton) findViewById(R.id.r_btn1);
        //r_btn2 = (RadioButton) findViewById(R.id.r_btn2);
        //r_btn1.setOnClickListener(radioButtonClickListener);
        //r_btn2.setOnClickListener(radioButtonClickListener);

        //라디오 그룹 설정
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener radioGroup_listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                btnNext.setEnabled(true);
            }

        }
    };

    class list3_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list3_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List3Activity.this, resid,
                "벌써 30%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private View.OnClickListener keepListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };



/*    //라디오 그룹 클릭 리스너
   RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            btnNext.setEnabled(true);

          if (i != -1) {
              btnNext.setEnabled(true);
          }
        }
   };*/
}
