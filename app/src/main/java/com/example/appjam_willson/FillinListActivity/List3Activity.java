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

    Bundle bundle = new Bundle();
    int importance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        resName = "@drawable/request_couldnt_find";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        list3_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list3_cancelbtn.setOnClickListener(new list3_cancelbtn_listener());

        list3_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list3_backbtn.setOnClickListener(new list3_backbtn_listener());

        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(radioGroup_listener);

        context = this;
        REQUEST_CODE = ((List3Activity) context).getTaskId();

        btnNext = findViewById(R.id.list3_btn1);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton checkedId = findViewById(radioGroup.getCheckedRadioButtonId());

                switch (checkedId.getId()){
                    case R.id.radio_1:
                        importance = 1;
                        break;
                    case R.id.radio_2:
                        importance = 2;
                        break;
                    case R.id.radio_3:
                        importance = 3;
                        break;
                    case R.id.radio_4:
                        importance = 4;
                        break;
                    case R.id.radio_5:
                        importance = 5;
                        break;

                }

                Intent intent = new Intent(context, List4Activity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:

                    bundle = data.getExtras();
                    bundle.putInt("importance",importance);
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
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
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List3Activity.this, resid,
                "벌써 30%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCanceledOnTouchOutside(false);

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
