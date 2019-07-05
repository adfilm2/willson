package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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

public class List5Activity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout list5_cancelbtn;
    LinearLayout list5_backbtn;

    RadioGroup list5_radioGroup;

    private OneTextTwoButton_CustomDialog dialog;

    Button list5_nextbtn;
    Context context;

    String resName;
    String packName;
    int resid;

    RadioButton man;
    RadioButton woman;
    RadioButton all;

    Typeface typebold;
    Typeface typereg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list5);

        context = this;

        REQUEST_CODE = ((List5Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        man = (RadioButton) findViewById(R.id.man_btn);
        woman = (RadioButton) findViewById(R.id.woman_btn);
        all = (RadioButton) findViewById(R.id.all_btn);

        man.setTypeface(typereg);
        woman.setTypeface(typereg);
        all.setTypeface(typereg);

        list5_nextbtn = (Button) findViewById(R.id.submit) ;
        list5_nextbtn.setOnClickListener(new list5_nextbtn_listener());

        list5_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list5_cancelbtn.setOnClickListener(new list5_cancelbtn_listener());

        list5_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list5_backbtn.setOnClickListener(new list5_backbtn_listener());

        list5_radioGroup = (RadioGroup) findViewById(R.id.list5_radiogroup);
        list5_radioGroup.setOnCheckedChangeListener(radioGroup_list5_listener);
    }

    private RadioGroup.OnCheckedChangeListener radioGroup_list5_listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.man_btn){
                    man.setTypeface(typebold);
                    woman.setTypeface(typereg);
                    all.setTypeface(typereg);
                }
                else if(checkedId == R.id.woman_btn){
                    woman.setTypeface(typebold);
                    man.setTypeface(typereg);
                    all.setTypeface(typereg);
                }
                else {
                    man.setTypeface(typereg);
                    woman.setTypeface(typereg);
                    all.setTypeface(typebold);
                }
            }
        }
    };



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
            Intent intent = new Intent(context, List5_1Activity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List5Activity.this, resid,
                "벌써 50%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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
