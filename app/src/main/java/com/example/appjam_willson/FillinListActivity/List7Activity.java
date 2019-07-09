package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;


public class List7Activity extends AppCompatActivity {

    int REQUEST_CODE;

    private OneTextTwoButton_CustomDialog dialog;
    LinearLayout list7_cancelbtn;
    LinearLayout list7_backbtn;
    Button list7_nextbtn;
    Context context;

    String resName;
    String packName;
    int resid;

    View view1;
    View view2;
    View view3;

    RadioGroup group1;
    RadioGroup group2;
    RadioGroup group3;


    int empathy =1;
    int advice =1;
    int experience=1;

    Bundle bundle7 = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list7);

        context = this;

        REQUEST_CODE = ((List7Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list7_nextbtn = (Button) findViewById(R.id.submit);
        list7_nextbtn.setOnClickListener(new list7_nextbtn_listener());

        list7_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list7_cancelbtn.setOnClickListener(new list7_cancelbtn_listener());

        list7_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list7_backbtn.setOnClickListener(new list7_backbtn_listener());

        view1 = (View) findViewById(R.id.list7_radioGroup1);
        view2 = (View) findViewById(R.id.list7_radioGroup2);
        view3 = (View) findViewById(R.id.list7_radioGroup3);

        group1 = (RadioGroup)view1.findViewById(R.id.radiogroup);
        group2 = (RadioGroup)view2.findViewById(R.id.radiogroup);
        group3 = (RadioGroup)view3.findViewById(R.id.radiogroup);


        group1.setOnCheckedChangeListener(new group_click1());
        group2.setOnCheckedChangeListener(new group_click2());
        group3.setOnCheckedChangeListener(new group_click3());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    Intent intent = new Intent();
                    bundle7.putInt("empathy",empathy);
                    bundle7.putInt("advice",advice);
                    bundle7.putInt("experience",experience);
                    intent.putExtras(bundle7);
                    setResult(RESULT_OK,intent);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class list7_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list7_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list7_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, ListAgreementActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List7Activity.this, resid,
                "벌써 80%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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


    private class group_click1 implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.radio_1:
                    empathy=1;
                    break;

                case R.id.radio_2:
                    empathy = 2;
                    break;

                case  R.id.radio_3:
                    empathy = 3;
                    break;

                case R.id.radio_4:
                    empathy = 4;
                    break;

                case R.id.radio_5:
                    empathy = 5;
                    break;


            }

        }
    }

    private class group_click2 implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.radio_1:
                    advice=1;
                    break;

                case R.id.radio_2:
                    advice = 2;
                    break;

                case  R.id.radio_3:
                    advice = 3;
                    break;

                case R.id.radio_4:
                    advice = 4;
                    break;

                case R.id.radio_5:
                    advice = 5;
                    break;


            }

        }
    }

    private class group_click3 implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.radio_1:
                    experience=1;
                    break;

                case R.id.radio_2:
                    experience = 2;
                    break;

                case  R.id.radio_3:
                    experience = 3;
                    break;

                case R.id.radio_4:
                    experience = 4;
                    break;

                case R.id.radio_5:
                    experience = 5;
                    break;


            }

        }
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("result", "BACK");
        setResult(REQUEST_CODE, intent);
        finish();
    }

}
