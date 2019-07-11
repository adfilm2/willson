package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.appjam_willson.FillinListActivity.List2Activity;
import com.example.appjam_willson.FillinListActivity.List4Activity;
import com.example.appjam_willson.MainActivities.MainActivity;
import com.example.appjam_willson.PopUp.ChatFeedback_CustomDialog;
import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;

public class test2Activity extends AppCompatActivity {


    private ChatFeedback_CustomDialog dialog;
    Button btn01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_test4);

        findViewById(R.id.btn01).setOnClickListener(mClickListener);


//        class list1_etc_cancelbtn_listener implements View.OnClickListener {
//            @Override
//            public void onClick(View view) {
//                Dialog();
//            }
//        }





    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
//            dialog.setCanceledOnTouchOutside(false);

          //  dialog.setCancelable(true);
          //  dialog.getWindow().setGravity(Gravity.CENTER);
            dialog = new ChatFeedback_CustomDialog(test2Activity.this, cancel_listener, commit_listener);
            dialog.show();


        }
    };



    public void Dialog() {
        dialog = new ChatFeedback_CustomDialog(test2Activity.this, cancel_listener, commit_listener);
        //dialog.setCanceledOnTouchOutside(false);
       // dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private View.OnClickListener cancel_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener commit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    };

    /*public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("result", "BACK");
        setResult(REQUEST_CODE, intent);
        finish();
    }*/




}


//    public void Dialog() {
//        dialog = new OneTextTwoButton_CustomDialog(List4Activity.this, resid, "벌써 40%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);
//
//        dialog.setCanceledOnTouchOutside(false);
//
//        dialog.setCancelable(true);
//        dialog.getWindow().setGravity(Gravity.CENTER);
//        dialog.show();
//    }


/*    private View.OnClickListener keepListener = new View.OnClickListener() {
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
    };*/

