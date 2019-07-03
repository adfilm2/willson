package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class List5Activity extends AppCompatActivity {

    public int check_num = 0;
    LinearLayout list5_cancelbtn;
    LinearLayout list5_backbtn;
    private CustomDialog dialog;
    Button list5_nextbtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list5);

        context = this;

        list5_nextbtn = (Button) findViewById(R.id.submit) ;
        list5_nextbtn.setOnClickListener(new list5_nextbtn_listener());

        list5_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list5_cancelbtn.setOnClickListener(new list5_cancelbtn_listener());

        list5_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list5_backbtn.setOnClickListener(new list5_backbtn_listener());


    }

    public void char_check(View view){
        Button nextbtn = (Button)findViewById(R.id.submit);
        CheckBox checkBox = (CheckBox)view;

                if (check_num < 3) {
                    if (!checkBox.isChecked()) {
                        checkBox.setChecked(false);
                        check_num -= 1;
                        if(check_num<=0) check_num=0;

                    } else {
                        checkBox.setChecked(true);
                        check_num += 1;
                        if(check_num>3) check_num =3;

                    }
                } else {
                    if (checkBox.isChecked()) {
                        checkBox.setChecked(false);
                        Toast.makeText(getApplicationContext(), "성격은 최대 세 개까지 고를 수 있습니다.", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        checkBox.setChecked(false);
                        check_num -= 1;

                    }
                }

                if(check_num == 3) nextbtn.setEnabled(true);
                else nextbtn.setEnabled(false);
    }

    class list5_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list5_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list5_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, List6Activity.class);
            startActivity(intent);
        }
    }
    public void Dialog() {
        dialog = new CustomDialog(List5Activity.this,
                "벌써 50%나 진행했어요!\n그래도 그만 작성하시겠어요?", keepListener, exitListener);

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




