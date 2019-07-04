package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class ListAgreementActivity extends AppCompatActivity {

    private CustomDialog dialog;
    LinearLayout agree_cancelbtn;
    LinearLayout agree_backbtn;
    Button submit_btn;
    Context context;

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);


        context = this;


        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        agree_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        agree_cancelbtn.setOnClickListener(new agree_cancelbtn_listener());

        agree_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        agree_backbtn.setOnClickListener(new agree_backbtn_listener());

        submit_btn = (Button)findViewById(R.id.submit);
        submit_btn.setOnClickListener((new submitbtn_listener()));
    }

    public void btn_check(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check2);
        Button submit = (Button) findViewById(R.id.submit);

        if(checkBox1.isChecked() && checkBox2.isChecked()){
            submit.setEnabled(true);
        } else{
            submit.setEnabled(false);
        }
    }

    class agree_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class agree_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class submitbtn_listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent( context, ListLoadingActivity.class);
            startActivity(intent);

        }
    }

    public void Dialog() {
        dialog = new CustomDialog(ListAgreementActivity.this, resid,
                "이제 거의 다왔어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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

}
