package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class AgreementActivity extends AppCompatActivity {

    private CustomDialog dialog;
    LinearLayout agree_cancelbtn;
    LinearLayout agree_backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);


        agree_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        agree_cancelbtn.setOnClickListener(new agree_cancelbtn_listener());

        agree_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        agree_backbtn.setOnClickListener(new agree_backbtn_listener());
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

    public void Dialog() {
        dialog = new CustomDialog(AgreementActivity.this,
                "이제 거의 다왔어요!\n그래도 그만 작성하시겠어요?", keepListener, exitListener);

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
